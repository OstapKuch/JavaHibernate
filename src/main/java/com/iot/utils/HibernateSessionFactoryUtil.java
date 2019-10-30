package com.iot.utils;

import com.iot.models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(AirbnbWalletEntity.class);
                configuration.addAnnotatedClass(ApartmentsEntity.class);
                configuration.addAnnotatedClass(ApartmentsHasReservationsEntity.class);
                configuration.addAnnotatedClass(BillingsEntity.class);
                configuration.addAnnotatedClass(BuyersEntity.class);
                configuration.addAnnotatedClass(ReservationsEntity.class);
                configuration.addAnnotatedClass(SellersEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception" + e);
            }
        }
        return sessionFactory;
    }
}
