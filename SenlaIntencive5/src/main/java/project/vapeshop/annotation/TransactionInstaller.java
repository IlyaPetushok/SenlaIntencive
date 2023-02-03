package project.vapeshop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.vapeshop.holder.ConnectionHolder;
import java.sql.Connection;
import java.sql.SQLException;


@Aspect
@Component
public class TransactionInstaller {
    ConnectionHolder connectionHolder;

    @Autowired
    public TransactionInstaller(ConnectionHolder connectionHolder) {
        this.connectionHolder = connectionHolder;
    }

    @Around(value = "@annotation(project.vapeshop.annotation.Transaction)")
    public boolean transactional(ProceedingJoinPoint proceedingJoinPoint) throws SQLException {
        System.out.println(Thread.currentThread().getId());
        Connection connection= connectionHolder.getConnectionTransaction();
        connection.setAutoCommit(false);
        try {
            proceedingJoinPoint.proceed();
//            connection.commit();
            connectionHolder.connectionCommit();
        } catch (Throwable e) {
//            connection.rollback();
            connectionHolder.connectionRollBck();
            e.printStackTrace();
        }
        return  true;
    }
}
