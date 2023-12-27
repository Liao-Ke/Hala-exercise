package com.itheima.domain;

import java.util.List;

public class Menu {
    private String storeName;
    private List<Food> foodMenu;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Food> getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(List<Food> foodMenu) {
        this.foodMenu = foodMenu;
    }
}
