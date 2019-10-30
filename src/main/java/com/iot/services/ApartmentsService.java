package com.iot.services;

import com.iot.DAO.implementation.ApartmentsDaoImpl;
import com.iot.models.ApartmentsEntity;

import java.sql.SQLException;
import java.util.List;

public class ApartmentsService {

    private ApartmentsDaoImpl apartmentsDao = new ApartmentsDaoImpl();

    public ApartmentsService() {
    }

    public ApartmentsEntity findById(Integer id) throws SQLException {
        return apartmentsDao.findById(id);
    }

    public int create(ApartmentsEntity entity) throws SQLException  {
        return apartmentsDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return apartmentsDao.delete(id);
    }

    public int update(ApartmentsEntity entity) throws SQLException  {
        return apartmentsDao.update(entity);
    }

    public List<ApartmentsEntity> findAll() throws SQLException {
        return apartmentsDao.findAll();
    }



}
