package com.itheima.service;

import com.itheima.domain.Store;

import java.util.List;

public interface StoreService {
    List<Store> getStore();

    List<Store> getStoreByUserId(int userID);

    int deleteStoreByID(int storeID);
}
