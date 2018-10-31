package com.klocke.wordfinder.singleton;

import com.klocke.wordfinder.database.data.WordGrid;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonFactory
{
    private static SingletonFactory instance;

    private SessionFactory sessionFactory;

    private SingletonFactory(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(WordGrid.class)
                .buildSessionFactory();

        this.sessionFactory = factory;
    }

    public static SingletonFactory getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonFactory();
        }

        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
