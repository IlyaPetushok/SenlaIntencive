package project.vapeshop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.vapeshop.dao.Dao;
import project.vapeshop.entity.product.Category;
import project.vapeshop.entity.product.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ItemProduct implements Dao<Item> {
    public static final String DELETE_FROM_ITEM_WHERE_ID_ITEM = "DELETE from item Where id_item=?";
    public static final String INSERT_ITEM = "INSERT INTO item(photo,name,id_category,price,quantity) VALUES (?,?,?,?,?)";
    public static final String SELECT_FROM_ITEM = "SELECT * From item;";
    public static final String SELECT_FROM_ITEM_WHERE_ID_ITEM = "SELECT * From item WHERE id_item=?;";
    public static final String UPDATE_ITEM = "Update item SET id_category=?,photo=?,name=?,price=?,quantity=? WHERE id_item=?;";
//    ConnectionHolder connectionHolder;

//    @Autowired
//    public ItemProduct(ConnectionHolder connectionHolder) {
//        this.connectionHolder = connectionHolder;
//    }

//    SessionFactory sessionFactory;
//
//    @Autowired
//    public ItemProduct(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean insertObject(Item item) {
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, 1);
        item.setCategory(category);
        entityManager.merge(item);
        entityManager.getTransaction().commit();
//        entityManager.persist(item);
//        Session session=sessionFactory.getCurrentSession();
//        item.setCategory(session.get(Category.class,1));
//        session.save(item);
//        try {
//            Connection connection = connectionHolder.getConnectionTransaction();
//            System.out.println(connection.getAutoCommit());
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM);
//            preparedStatement.setString(1, item.getPhoto());
//            preparedStatement.setString(2, item.getName());
//            preparedStatement.setInt(3, item.getIdCategory());
//            preparedStatement.setBigDecimal(4, item.getPrice());
//            preparedStatement.setInt(5, item.getQuantity());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return true;
    }

    @Override
    public boolean insertObjects(List<Item> itemEntities) {
        return true;
    }

    @Override
    public List<Item> selectObjects() {
//        List<Item> items = new ArrayList<>();
//        Connection connection = connectionHolder.getConnection();
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SELECT_FROM_ITEM);
//            while (resultSet.next()) {
//                Item item = new Item();
//                item.setId(resultSet.getInt("id_item"));
//                item.setIdCategory(resultSet.getInt("id_category"));
//                item.setPhoto(resultSet.getString("photo"));
//                item.setName(resultSet.getString("name"));
//                item.setPrice(resultSet.getBigDecimal("price"));
//                item.setQuantity(resultSet.getInt("quantity"));
//                items.add(item);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            connectionHolder.putConnection(connection);
//        }
//        return items;
        return null;
    }

    @Override
    public Item selectObject(int id) {
//        Item item = null;
//        Connection connection = connectionHolder.getConnection();
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(SELECT_FROM_ITEM_WHERE_ID_ITEM);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                item = new Item();
//                item.setId(resultSet.getInt("id_item"));
//                item.setIdCategory(resultSet.getInt("id_category"));
//                item.setPhoto(resultSet.getString("photo"));
//                item.setName(resultSet.getString("name"));
//                item.setPrice(resultSet.getBigDecimal("price"));
//                item.setQuantity(resultSet.getInt("quantity"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            connectionHolder.putConnection(connection);
//        }
//        return item;
        return null;
    }

    @Override
    public Item update(Item item) {
//        Connection connection = connectionHolder.getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(UPDATE_ITEM);
//            preparedStatement.setInt(1, item.getIdCategory());
//            preparedStatement.setString(2, item.getPhoto());
//            preparedStatement.setString(3, item.getName());
//            preparedStatement.setBigDecimal(4, item.getPrice());
//            preparedStatement.setInt(5, item.getQuantity());
//            preparedStatement.setInt(6, item.getId());
//            if (preparedStatement.executeUpdate() > 0) {
//                return item;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            connectionHolder.putConnection(connection);
//        }
        return null;
    }

    @Override
    public boolean delete(int id) {
//        Connection connection = connectionHolder.getConnection();
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(DELETE_FROM_ITEM_WHERE_ID_ITEM);
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//            if (preparedStatement.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            connectionHolder.putConnection(connection);
//        }
        return false;
    }
}
