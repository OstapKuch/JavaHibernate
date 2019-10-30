package com.iot.services;


import com.iot.DAO.implementation.BuyersDaoImpl;
import com.iot.models.BuyersEntity;

import java.sql.SQLException;
import java.util.List;

public class BuyersService {

    private BuyersDaoImpl buyersDao = new BuyersDaoImpl();

    public BuyersService() {
    }

    public BuyersEntity findById(Integer id) throws SQLException {
        return buyersDao.findById(id);
    }

    public int create(BuyersEntity entity) throws SQLException  {
        return buyersDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return buyersDao.delete(id);
    }

    public int update(BuyersEntity entity) throws SQLException  {
        return buyersDao.update(entity);
    }

    public List<BuyersEntity> findAll() throws SQLException {
        return buyersDao.findAll();
    }



}
