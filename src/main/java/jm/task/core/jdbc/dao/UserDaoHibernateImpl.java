package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory factory = Util.getSessionFactory();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        String sql = """
                CREATE TABLE Users (
                  `id` INT NOT NULL AUTO_INCREMENT,
                  `name` VARCHAR(255) NOT NULL,
                  `lastName` VARCHAR(255) NOT NULL,
                  `age` INT NOT NULL,
                  PRIMARY KEY (`id`));
                """;
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS Users";
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery(sql).addEntity(User.class).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(new User(name, lastName, age));
        tx.commit();
        System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete User " + "where id = " + id).executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<User> users = session.createQuery("from User").getResultList();
        tx.commit();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete User").executeUpdate();
        session.getTransaction().commit();
    }
}
