package com.iot.DAO.implementation;

import com.iot.DAO.ApartmentsDAO;
import com.iot.utils.HibernateSessionFactoryUtil;
import com.iot.models.ApartmentsEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartmentsDaoImpl implements ApartmentsDAO {


    @Override
    public List<ApartmentsEntity> findAll() throws SQLException {
        List entities = new ArrayList<>();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entities = (List<ApartmentsEntity>) session.createQuery("FROM models.ApartmentsEntity").list();
        }
        return entities;
    }

    @Override
    public ApartmentsEntity findById(Integer id) throws SQLException {
        ApartmentsEntity entity = new ApartmentsEntity();
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            entity = (ApartmentsEntity) session.get(ApartmentsEntity.class, id);
        }
        return entity;
    }

    @Override
    public int create(ApartmentsEntity entity) throws SQLException {
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
    public int update(ApartmentsEntity entity) throws SQLException {
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
            ApartmentsEntity entity;
            entity = (ApartmentsEntity) session.load(ApartmentsEntity.class, id);
            session.delete(entity);
            tx1.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

}
