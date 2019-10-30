package com.iot.services;




import com.iot.DAO.implementation.SellersDaoImpl;
import com.iot.models.SellersEntity;

import java.sql.SQLException;
import java.util.List;

public class SellersService {

    private SellersDaoImpl sellersDao = new SellersDaoImpl();

    public SellersService() {
    }

    public SellersEntity findById(Integer id) throws SQLException {
        return sellersDao.findById(id);
    }

    public int create(SellersEntity entity) throws SQLException  {
        return sellersDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return sellersDao.delete(id);
    }

    public int update(SellersEntity entity) throws SQLException  {
        return sellersDao.update(entity);
    }

    public List<SellersEntity> findAll() throws SQLException {
        return sellersDao.findAll();
    }



}
