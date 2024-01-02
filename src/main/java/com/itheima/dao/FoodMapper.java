package com.itheima.dao;


import com.itheima.domain.Food;
import com.itheima.domain.Menu;


public interface FoodMapper {
    Menu getFoodMenu(int storeID);

    int deleteFoodMenuByStoreID(int storeID);

    int deleteFoodByID(int foodID);

    int updateFood(Food food);
}
