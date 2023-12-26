package com.itheima.service;

import com.itheima.domain.Food;

import java.util.List;

public interface FoodService {
    List<Food> getFoodMenu(int storeID);
}
