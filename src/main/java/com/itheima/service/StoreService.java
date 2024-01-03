package com.itheima.service;

import com.github.pagehelper.Page;
import com.itheima.domain.Store;
import entity.PageResult;

import java.util.List;

public interface StoreService {
    PageResult getStore(Integer pageNum,Integer pageSize);

    List<Store> getStoreByUserId(int userID);

    int deleteStoreByID(int storeID);

    int updateStore(Store store);

    Store getStoreById(int storeID);

    int addStore(Store store);

}
