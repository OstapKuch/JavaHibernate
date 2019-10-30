package com.iot.DAO.implementation;

import com.iot.DAO.ApartmentsHasReservationsDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.ApartmentsHasReservationsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentsHasReservationsDaoImpl implements ApartmentsHasReservationsDAO {


    @Override
    public List<ApartmentsHasReservationsEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<ApartmentsHasReservationsEntity>) session.createQuery("FROM models.ApartmentsHasReservationsEntity").list();
        }
        return entities;
    }

    @Override
    public ApartmentsHasReservationsEntity findById(Integer id) throws SQLException {
        ApartmentsHasReservationsEntity entity = new ApartmentsHasReservationsEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (ApartmentsHasReservationsEntity) session.get(ApartmentsHasReservationsEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(ApartmentsHasReservationsEntity entity) throws SQLException {
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
    public int update(ApartmentsHasReservationsEntity entity) throws SQLException {
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
            ApartmentsHasReservationsEntity entity;
            entity = (ApartmentsHasReservationsEntity) session.load(ApartmentsHasReservationsEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
