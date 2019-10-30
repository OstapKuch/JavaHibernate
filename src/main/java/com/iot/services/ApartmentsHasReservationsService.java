package com.iot.services;

import com.iot.DAO.implementation.ApartmentsHasReservationsDaoImpl;
import com.iot.models.ApartmentsHasReservationsEntity;

import java.sql.SQLException;
import java.util.List;

public class ApartmentsHasReservationsService {

    private ApartmentsHasReservationsDaoImpl apartmentsHasReservationsDao = new ApartmentsHasReservationsDaoImpl();

    public ApartmentsHasReservationsService() {
    }

    public ApartmentsHasReservationsEntity findById(Integer id) throws SQLException {
        return apartmentsHasReservationsDao.findById(id);
    }

    public int create(ApartmentsHasReservationsEntity entity) throws SQLException  {
        return apartmentsHasReservationsDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return apartmentsHasReservationsDao.delete(id);
    }

    public int update(ApartmentsHasReservationsEntity entity) throws SQLException  {
        return apartmentsHasReservationsDao.update(entity);
    }

    public List<ApartmentsHasReservationsEntity> findAll() throws SQLException {
        return apartmentsHasReservationsDao.findAll();
    }



}
