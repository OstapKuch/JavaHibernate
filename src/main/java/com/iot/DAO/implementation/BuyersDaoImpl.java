package com.iot.DAO.implementation;

import com.iot.DAO.BuyersDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.BuyersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuyersDaoImpl implements BuyersDAO {


    @Override
    public List<BuyersEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<BuyersEntity>) session.createQuery("FROM models.BuyersEntity").list();
        }
        return entities;
    }

    @Override
    public BuyersEntity findById(Integer id) throws SQLException {
        BuyersEntity entity = new BuyersEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (BuyersEntity) session.get(BuyersEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(BuyersEntity entity) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int update(BuyersEntity entity) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;

        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            BuyersEntity entity;
            entity = (BuyersEntity) session.load(BuyersEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
