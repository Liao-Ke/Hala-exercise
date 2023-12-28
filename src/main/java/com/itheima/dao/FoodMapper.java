package com.itheima.dao;


import com.itheima.domain.Menu;


public interface FoodMapper {
    Menu getFoodMenu(int storeID);

    int deleteFoodMenuByStoreID(int storeID);
}
