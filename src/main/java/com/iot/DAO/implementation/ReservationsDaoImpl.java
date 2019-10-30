package com.iot.DAO.implementation;

import com.iot.DAO.ReservationsDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.ReservationsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationsDaoImpl implements ReservationsDAO {


    @Override
    public List<ReservationsEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<ReservationsEntity>) session.createQuery("FROM models.ReservationsEntity").list();
        }
        return entities;
    }

    @Override
    public ReservationsEntity findById(Integer id) throws SQLException {
        ReservationsEntity entity = new ReservationsEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (ReservationsEntity) session.get(ReservationsEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(ReservationsEntity entity) throws SQLException {
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
    public int update(ReservationsEntity entity) throws SQLException {
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
            ReservationsEntity entity;
            entity = (ReservationsEntity) session.load(ReservationsEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
