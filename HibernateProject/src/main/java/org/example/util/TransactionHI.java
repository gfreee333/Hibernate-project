package org.example.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TransactionHI {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
