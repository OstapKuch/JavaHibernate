package com.iot.DAO.implementation;

import com.iot.DAO.SellersDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.SellersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellersDaoImpl implements SellersDAO {


    @Override
    public List<SellersEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<SellersEntity>) session.createQuery("FROM models.SellersEntity").list();
        }
        return entities;
    }

    @Override
    public SellersEntity findById(Integer id) throws SQLException {
        SellersEntity entity = new SellersEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (SellersEntity) session.get(SellersEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(SellersEntity entity) throws SQLException {
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
    public int update(SellersEntity entity) throws SQLException {
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
            SellersEntity entity;
            entity = (SellersEntity) session.load(SellersEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
