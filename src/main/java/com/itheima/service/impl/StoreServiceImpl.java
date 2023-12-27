package com.itheima.service.impl;

import com.itheima.dao.StoreMapper;
import com.itheima.domain.Store;
import com.itheima.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public List<Store> getStore() {
        return storeMapper.getStore();
    }
}
