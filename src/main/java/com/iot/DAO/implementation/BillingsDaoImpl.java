package com.iot.DAO.implementation;

import com.iot.DAO.BillingsDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.BillingsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingsDaoImpl implements BillingsDAO {


    @Override
    public List<BillingsEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<BillingsEntity>) session.createQuery("FROM models.BillingsEntity").list();
        }
        return entities;
    }

    @Override
    public BillingsEntity findById(Integer id) throws SQLException {
        BillingsEntity entity = new BillingsEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (BillingsEntity) session.get(BillingsEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(BillingsEntity entity) throws SQLException {
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
    public int update(BillingsEntity entity) throws SQLException {
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
            BillingsEntity entity;
            entity = (BillingsEntity) session.load(BillingsEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
