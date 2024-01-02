package com.itheima.dao;


import com.itheima.domain.Store;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StoreMapper {
    @Select("select * from store")
    @Results(id = "storeMap", value = {
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名。
            @Result(id = true, column = "store_id", property = "id"),
            @Result(column = "user_id", property = "userID"),
            @Result(column = "store_title", property = "title"),
            @Result(column = "store_des", property = "description"),
            @Result(column = "store_imgurl", property = "imageUrl")
    })
    List<Store> getStore();


    @Select("select * from store where user_id=#{user_id}")
    @ResultMap(value = "storeMap")
    List<Store> getStoreByUserId(int userID);

    @Select("select * from store where store_id=#{store_id}")
    @ResultMap(value = "storeMap")
    Store getStoreById(int storeID);

    int deleteStoreByID(int storeID);

    int updateStore(Store store);

    int addStore(Store store);
}
