package com.itheima.service.impl;

import com.itheima.dao.FoodMapper;
import com.itheima.domain.Food;
import com.itheima.domain.Menu;
import com.itheima.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodMapper foodMapper;

    @Override
    public Menu getFoodMenu(int storeID) {
        return foodMapper.getFoodMenu(storeID);
    }

    @Override
    public int deleteFoodMenuByStoreID(int storeID) {
        return foodMapper.deleteFoodMenuByStoreID(storeID);
    }

    @Override
    public int deleteFoodByID(int foodID) {
        return foodMapper.deleteFoodByID(foodID);
    }

    @Override
    public int updateFood(Food food) {
        return foodMapper.updateFood(food);
    }

    @Override
    public Food getFoodByID(int foodID) {
        return foodMapper.getFoodByID(foodID);
    }

    @Override
    public int addFood(Food food) {
        return foodMapper.addFood(food);
    }


}
