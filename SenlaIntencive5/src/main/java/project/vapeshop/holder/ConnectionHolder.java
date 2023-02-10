package project.vapeshop.holder;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;


@Component
public class ConnectionHolder {
    private static final Map<Long, Queue<ConnectionEntity>> connections = new HashMap<>();

    public void connectionCommit() {
        ConnectionEntity connectionEntity = connections.get(Thread.currentThread().getId()).stream()
                .filter(ConnectionEntity::isInTransaction)
                .findAny()
                .orElse(null);
        try {
            assert connectionEntity != null:"connection commit dont perhaps because connection is null";
            connectionEntity.getConnection().commit();
            connectionEntity.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionEntity.setInTransaction(false);
    }

    public void connectionRollBck() {
        ConnectionEntity connectionEntity = connections.get(Thread.currentThread().getId()).stream()
                .filter(ConnectionEntity::isInTransaction)
                .findAny()
                .orElse(null);
        try {
            assert connectionEntity != null:"connection commit dont perhaps because connection is null";
            connectionEntity.getConnection().setAutoCommit(false);
            connectionEntity.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionEntity.setInTransaction(false);
    }

    public Connection getConnectionTransaction() {
        ConnectionEntity connectionEntity = null;
        connections.computeIfAbsent(Thread.currentThread().getId(), (key) -> new LinkedList<>());
        Queue<ConnectionEntity> connectionEntities = connections.get(Thread.currentThread().getId());
        if (connectionEntities.size() == 0) {
            connectionEntity = createConnection().peek();
            if (connectionEntity != null) {
                connectionEntity.setInTransaction(true);
                return connectionEntity.getConnection();
            }
        }
        try {
            for (int i = 0; i < connectionEntities.size(); ) {
                connectionEntity = connectionEntities.peek();
                if (connectionEntity.isInTransaction() && !connectionEntity.getConnection().isClosed()) {
                    return connectionEntity.getConnection();
                }
                connectionEntities.add(connectionEntities.poll());
            }
            assert connectionEntity != null:"connection  is null";
            connectionEntity.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionEntity.setInTransaction(true);
        return connectionEntity.getConnection();
    }

    public Connection getConnection() {
        connections.computeIfAbsent(Thread.currentThread().getId(), (key) -> new LinkedList<>());
        ConnectionEntity connectionEntity;
        Queue<ConnectionEntity> connectionEntities = connections.get(Thread.currentThread().getId());
        if (connectionEntities.size() == 0) {
            connectionEntity=createConnection().peek();
            assert connectionEntity!=null:"connection  is null";
            return connectionEntity.getConnection();
        }
        for (int i = 0; i < connectionEntities.size(); i++) {
            connectionEntity = connectionEntities.peek();
            if (!connectionEntity.isInTransaction()) {
                return connectionEntity.getConnection();
            }
            connectionEntities.add(connectionEntities.poll());
        }
        connectionEntity=createConnection().peek();
        assert connectionEntity!=null:"connection  is null";
        return connectionEntity.getConnection();
    }

    public Queue<ConnectionEntity> createConnection() {
        Properties properties = loadProperty();
        Connection connection;
        try {
            connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.username"), properties.getProperty("db.password"));
            connections.get(Thread.currentThread().getId()).add(new ConnectionEntity(connection, false));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connections.get(Thread.currentThread().getId());
    }


    public Properties loadProperty() {
        Properties properties = new Properties();
        try(InputStream inputStream=new FileInputStream("src/main/resources/aplication.properties")){
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
