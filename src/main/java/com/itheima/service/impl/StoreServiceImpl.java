package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.StoreMapper;
import com.itheima.domain.Store;
import com.itheima.service.StoreService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;


    @Override
    public PageResult getStore(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<Store> page = storeMapper.getStore();
        return new PageResult(page.getTotal(),page.getPages(),page.getPageNum(),page.getResult());
    }

    @Override
    public List<Store> getStoreByUserId(int userID) {
        return storeMapper.getStoreByUserId(userID);
    }

    @Override
    public int deleteStoreByID(int storeID) {
        return storeMapper.deleteStoreByID(storeID);
    }

    @Override
    public int updateStore(Store store) {
        return storeMapper.updateStore(store);
    }

    @Override
    public Store getStoreById(int storeID) {
        return storeMapper.getStoreById(storeID);
    }

    @Override
    public int addStore(Store store) {
        return storeMapper.addStore(store);
    }


}
