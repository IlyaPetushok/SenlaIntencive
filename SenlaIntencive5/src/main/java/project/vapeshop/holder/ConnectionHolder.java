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

    public void connectionCommit() {
        ConnectionEntity connectionEntity = connections.get(Thread.currentThread().getId()).stream()
                .filter(ConnectionEntity::isInTransaction)
                .findAny()
                .orElse(null);
        try {
            connectionEntity.getConnection().commit();
            connectionEntity.getConnection().setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connectionEntity.setInTransaction(false);
    }

    public void connectionRollBck() {
        try {
            getConnectionTransaction().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                if (connectionEntity.isInTransaction()) {
                    if (connectionEntity.getConnection().isClosed()) {
                        throw new SQLException("connection was closed");
                    }
                    return connectionEntity.getConnection();
                }
                connectionEntities.add(connectionEntities.poll());
            }
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
            return createConnection().peek().getConnection();
        }
        for (int i = 0; i < connectionEntities.size(); i++) {
            connectionEntity = connectionEntities.peek();
            if (!connectionEntity.isInTransaction()) {
                return connectionEntity.getConnection();
            }
            connectionEntities.add(connectionEntities.poll());
        }
        return createConnection().peek().getConnection();
    }

    public Queue<ConnectionEntity> createConnection() {
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
        return connectionEntities;
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
