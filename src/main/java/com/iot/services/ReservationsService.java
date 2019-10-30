package com.iot.services;



import com.iot.DAO.implementation.ReservationsDaoImpl;
import com.iot.models.ReservationsEntity;

import java.sql.SQLException;
import java.util.List;

public class ReservationsService {

    private ReservationsDaoImpl reservationsDao = new ReservationsDaoImpl();

    public ReservationsService() {
    }

    public ReservationsEntity findById(Integer id) throws SQLException {
        return reservationsDao.findById(id);
    }

    public int create(ReservationsEntity entity) throws SQLException  {
        return reservationsDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return reservationsDao.delete(id);
    }

    public int update(ReservationsEntity entity) throws SQLException  {
        return reservationsDao.update(entity);
    }

    public List<ReservationsEntity> findAll() throws SQLException {
        return reservationsDao.findAll();
    }



}
