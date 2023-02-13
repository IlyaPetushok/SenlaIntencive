package project.vapeshop.holder;

import java.sql.Connection;

public class ConnectionEntity {
    private Connection connection;
    private boolean inTransaction;


    public ConnectionEntity(Connection connection, boolean isTransaction) {
        this.connection = connection;
        this.inTransaction = isTransaction;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean isInTransaction() {
        return inTransaction;
    }

    public void setInTransaction(boolean inTransaction) {
        this.inTransaction = inTransaction;
    }
}
