package com.iot.DAO.implementation;

import com.iot.DAO.AirbnbWalletDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.AirbnbWalletEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirbnbWalletDaoImpl implements AirbnbWalletDAO {


    @Override
    public List<AirbnbWalletEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<AirbnbWalletEntity>) session.createQuery("FROM models.AirbnbWalletEntity").list();
        }
        return entities;
    }

    @Override
    public AirbnbWalletEntity findById(Integer id) throws SQLException {
        AirbnbWalletEntity entity = new AirbnbWalletEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (AirbnbWalletEntity) session.get(AirbnbWalletEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(AirbnbWalletEntity entity) throws SQLException {
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
    public int update(AirbnbWalletEntity entity) throws SQLException {
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
            AirbnbWalletEntity entity;
            entity = (AirbnbWalletEntity) session.load(AirbnbWalletEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
