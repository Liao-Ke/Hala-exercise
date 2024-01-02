package com.itheima.service;

import com.itheima.domain.Food;
import com.itheima.domain.Menu;

public interface FoodService {
    Menu getFoodMenu(int storeID);

    int deleteFoodMenuByStoreID(int storeID);

    int deleteFoodByID(int foodID);

    int updateFood(Food food);
}
