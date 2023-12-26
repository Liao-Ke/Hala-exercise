package com.itheima.controller;

import com.itheima.domain.Store;
import com.itheima.service.StoreService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class StoreController {
    @Autowired
    private StoreService storeService;
    @RequestMapping("/getStore")
    public Result getStore(){
        try {
            List<Store> stores = storeService.getStore();
            if (stores!=null){
                return new Result(true,"获取成功", stores);
            }
            return new Result(false,"获取失败");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }

    }
}
