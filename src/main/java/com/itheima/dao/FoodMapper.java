package com.itheima.dao;

import com.itheima.domain.Food;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FoodMapper {
    @Select("select * from food where store_id=#{store_id}")
    @Results(id = "foodMap",value = {
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名。
            @Result(id = true,column = "food_id",property = "id"),
            @Result(column = "store_id",property = "storeID"),
            @Result(column = "food_title",property = "title"),
            @Result(column = "food_des",property = "description"),
            @Result(column = "food_imgurl",property = "imageUrl")
    })
    List<Food> getFoodMenu(int storeID);
}
