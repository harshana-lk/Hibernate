package lk.ijse.hibernate.util;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
