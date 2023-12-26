package com.itheima.service.impl;

import com.itheima.dao.FoodMapper;
import com.itheima.domain.Food;
import com.itheima.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceimpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoodMenu(int storeID) {
        return foodMapper.getFoodMenu(storeID);
    }
}
