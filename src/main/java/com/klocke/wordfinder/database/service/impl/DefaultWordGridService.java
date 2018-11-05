package com.klocke.wordfinder.database.service.impl;

import com.klocke.wordfinder.database.data.WordGrid;
import com.klocke.wordfinder.database.service.WordGridService;
import com.klocke.wordfinder.singleton.SingletonFactory;
import org.hibernate.Session;

import java.util.List;

public class DefaultWordGridService implements WordGridService
{
    @Override
    public WordGrid retriveWordGridById(int id)
    {
        Session session = SingletonFactory.getInstance().getSessionFactory().getCurrentSession();

        session.beginTransaction();

        WordGrid wordGrid = session.get(WordGrid.class, id);

        session.getTransaction().commit();

        return wordGrid;
    }

    @Override
    public int saveWordGrid(WordGrid grid)
    {

        Session session = SingletonFactory.getInstance().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(grid);

        session.getTransaction().commit();

        return grid.getId();
    }

    @Override
    public List<WordGrid> getAllWordGrids()
    {
        Session session = SingletonFactory.getInstance().getSessionFactory().getCurrentSession();

        session.beginTransaction();

        List<WordGrid> allWordGrids = session.createQuery("from WordGrid").getResultList();

        session.getTransaction().commit();


        return allWordGrids;
    }
}
