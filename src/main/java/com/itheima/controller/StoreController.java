package com.itheima.controller;

import com.itheima.domain.Menu;
import com.itheima.domain.Store;
import com.itheima.service.FoodService;
import com.itheima.service.StoreService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private FoodService foodService;

    @RequestMapping("/getStore")
    public Result getStore() {
        try {
            List<Store> stores = storeService.getStore();
            if (stores != null) {
                return new Result(true, "获取成功", stores);
            }
            return new Result(false, "获取失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/getStoreByUserID")
    public Result getStoreByUserId(int userID) {
        try {
            List<Store> stores = storeService.getStoreByUserId(userID);
            if (stores != null) {
                return new Result(true, "获取成功", stores);
            }
            return new Result(false, "获取失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/deleteStoreByID")
    public Result deleteStoreByID(int storeID) {
        try {
            Menu foodMenu = foodService.getFoodMenu(storeID);
            if (foodMenu != null) {
                foodService.deleteFoodMenuByStoreID(storeID);
            }

            int count = storeService.deleteStoreByID(storeID);
            if (count > 0) {
                return new Result(true, "删除成功");
            }
            return new Result(false, "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/updateStore")
    public Result updateStore(Store store){
        try {
            int count = storeService.updateStore(store);
            if (count > 0) {
                return new Result(true, "更新成功");
            }
            return new Result(false, "更新失败");
        }catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }
}
