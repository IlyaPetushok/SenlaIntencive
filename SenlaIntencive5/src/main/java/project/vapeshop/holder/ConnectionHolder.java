package project.vapeshop.holder;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


@Component
public class ConnectionHolder {
    private static final Map<Long, Queue<ConnectionEntity>> connections = new HashMap<>();

    public Connection getConnectionTransaction() {
        ConnectionEntity connectionEntity=null;
        checkCreateConnectionsList();
        Queue<ConnectionEntity> connectionEntities = connections.get(Thread.currentThread().getId());
        if (connectionEntities.size() == 0) {
            createConnection();
            connectionEntities.peek().setInTransaction(true);
            return connectionEntities.peek().getConnection();
        }
        for (int i = 0; i < connectionEntities.size(); ) {
            connectionEntity = connectionEntities.poll();
            connectionEntities.add(connectionEntity);
            if (connectionEntity.isInTransaction()) {
                return connectionEntity.getConnection();
            }
        }
        try {
            connectionEntity.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionEntity.setInTransaction(true);
        return connectionEntity.getConnection();
    }

    public void checkCreateConnectionsList(){
        if (connections.get(Thread.currentThread().getId()) == null) {
            Queue<ConnectionEntity> queue = new LinkedList<>();
            connections.put(Thread.currentThread().getId(), queue);
        }
    }

    public Connection getConnection() {
        checkCreateConnectionsList();
        Queue<ConnectionEntity> connectionEntities = connections.get(Thread.currentThread().getId());
        if (connectionEntities.size() == 0) {
            createConnection();
            return connectionEntities.poll().getConnection();
        }
        ConnectionEntity connectionEntity = null;
        for (int i = 0; i < connectionEntities.size(); i++) {
            connectionEntity = connectionEntities.poll();
            if (!connectionEntity.isInTransaction()) {
                return connectionEntity.getConnection();
            }
        }
        createConnection();
        return connectionEntities.poll().getConnection();
    }

    public void createConnection() {
        Properties properties = loadProperty();
        Connection connection;
        Queue<ConnectionEntity> connectionEntities = connections.get(Thread.currentThread().getId());
        try {
            connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
            connectionEntities.add(new ConnectionEntity(connection, false));
            connections.put(Thread.currentThread().getId(), connectionEntities);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void putConnection(Connection connection) {
        connections.get(Thread.currentThread().getId()).add(new ConnectionEntity(connection, false));
    }

    public Properties loadProperty() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/aplication.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
