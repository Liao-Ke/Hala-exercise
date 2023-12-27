package com.itheima.service.impl;

import com.itheima.dao.FoodMapper;
import com.itheima.domain.Menu;
import com.itheima.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Menu getFoodMenu(int storeID) {
        return foodMapper.getFoodMenu(storeID);
    }
}
