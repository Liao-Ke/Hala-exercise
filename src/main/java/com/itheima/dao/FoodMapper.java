package com.itheima.dao;


import com.itheima.domain.Food;
import com.itheima.domain.Menu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


public interface FoodMapper {
    Menu getFoodMenu(int storeID);

    int deleteFoodMenuByStoreID(int storeID);

    int deleteFoodByID(int foodID);

    int updateFood(Food food);
    @Select("SELECT * FROM food WHERE food_id=#{food_id}")
    @Results(id = "foodMap", value = {
            //id字段默认为false，表示不是主键
            //column表示数据库表字段，property表示实体类属性名。
            @Result(id = true, column = "food_id", property = "id"),
            @Result(column = "store_id", property = "storeID"),
            @Result(column = "food_title", property = "title"),
            @Result(column = "food_des", property = "description"),
            @Result(column = "food_imgurl", property = "imageUrl"),
            @Result(column = "food_price", property = "price")
    })
    Food getFoodByID(int foodID);
}
