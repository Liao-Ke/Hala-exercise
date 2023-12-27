package com.itheima.controller;


import com.itheima.domain.Menu;
import com.itheima.service.FoodService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping("/getFoodMenu")
    public Result getFoodMenu(int storeID) {
        try {
            Menu foodMenu = foodService.getFoodMenu(storeID);
            if(foodMenu!=null) {
                return  new Result(true,"获取成功", foodMenu);
            }
            return new Result(false,"获取失败");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }
}
