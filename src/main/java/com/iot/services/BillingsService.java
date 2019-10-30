package com.iot.services;



import com.iot.DAO.implementation.BillingsDaoImpl;
import com.iot.models.BillingsEntity;

import java.sql.SQLException;
import java.util.List;

public class BillingsService {

    private BillingsDaoImpl billingsDao = new BillingsDaoImpl();

    public BillingsService() {
    }

    public BillingsEntity findById(Integer id) throws SQLException {
        return billingsDao.findById(id);
    }

    public int create(BillingsEntity entity) throws SQLException  {
        return billingsDao.create(entity);
    }

    public int  delete(Integer id) throws SQLException  {
        return billingsDao.delete(id);
    }

    public int update(BillingsEntity entity) throws SQLException  {
        return billingsDao.update(entity);
    }

    public List<BillingsEntity> findAll() throws SQLException {
        return billingsDao.findAll();
    }



}
