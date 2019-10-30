package com.iot.services;


import com.iot.DAO.implementation.AirbnbWalletDaoImpl;
import com.iot.models.AirbnbWalletEntity;

import java.sql.SQLException;
import java.util.List;

public class AirbnbWalletService {

    private AirbnbWalletDaoImpl airbnbWalletDao = new AirbnbWalletDaoImpl();

    public AirbnbWalletService() {
    }

    public AirbnbWalletEntity findById(Integer id) throws SQLException {
        return airbnbWalletDao.findById(id);
    }

    public int create(AirbnbWalletEntity entity) throws SQLException  {
        return airbnbWalletDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return airbnbWalletDao.delete(id);
    }

    public int update(AirbnbWalletEntity entity) throws SQLException  {
        return airbnbWalletDao.update(entity);
    }

    public List<AirbnbWalletEntity> findAll() throws SQLException {
        return airbnbWalletDao.findAll();
    }



}
