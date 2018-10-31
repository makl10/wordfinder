package com.klocke.wordfinder.database.service.impl;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import com.klocke.wordfinder.singleton.SingletonFactory;
import org.hibernate.Session;

import java.io.Serializable;

public class DefaultWordGridService implements WordGridService
{
    @Override
    public WordGrid retriveWordGridById(int id)
    {

        WordGrid wordGrid = null;
        try
        {
            Session session = SingletonFactory.getInstance().getSessionFactory().getCurrentSession();

            session.beginTransaction();

            wordGrid = session.get(WordGrid.class, id);

            session.getTransaction().commit();
        }
        finally
        {
            SingletonFactory.getInstance().getSessionFactory().close();
        }

        return wordGrid;
    }

    @Override
    public int saveWordGrid(WordGrid grid)
    {
        try
        {
            Session session = SingletonFactory.getInstance().getSessionFactory().getCurrentSession();
            session.beginTransaction();

            session.save(grid);

            session.getTransaction().commit();
        }
        finally
        {
            SingletonFactory.getInstance().getSessionFactory().close();
        }

        return grid.getId();
    }
}
