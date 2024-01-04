package com.itheima.controller;


import com.itheima.domain.Food;
import com.itheima.domain.Menu;
import com.itheima.domain.Store;
import com.itheima.service.FoodService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping("/getFoodMenu")
    public Result getFoodMenu(int storeID) {
        try {
            Menu foodMenu = foodService.getFoodMenu(storeID);

                return new Result(true, "获取成功", foodMenu);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/deleteFoodByID")
    public Result deleteFoodByID(int foodID) {
        try {
            int count = foodService.deleteFoodByID(foodID);
            if (count > 0) {
                return new Result(true, "删除成功");
            }
            return new Result(false, "删除失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/updateFood")
    public Result updateFood(Food food,MultipartFile imageFile, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/") + "files/";
        String fileName = UUID.randomUUID() + ".jpg";
        if (!imageFile.isEmpty() && imageFile!=null) {
            String fileType = imageFile.getContentType();
            if (!fileType.equals("image/jpeg") && !fileType.equals("image/png")) return new Result(false, "请上传图片");
            try {
                imageFile.transferTo(new File(path+fileName));
                food.setImageUrl("image/"+fileName);
            } catch (IOException e) {
//                throw new RuntimeException(e);
                return new Result(false, "系统错误", e);

            }
        }
        try {
            int count = foodService.updateFood(food);
            if (count > 0) {
                return new Result(true, "更新成功");
            }
            return new Result(false, "更新失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/getFoodByID")
    public Result getFoodByID(int foodID) {
        try {
            Food food = foodService.getFoodByID(foodID);

                return new Result(true, "获取成功", food);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/addFood")
    public Result addFood(Food food, MultipartFile imageFile, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/") + "files/";
        String fileType = imageFile.getContentType();
        String fileName = UUID.randomUUID() + ".jpg";
        if (!fileType.equals("image/jpeg") && !fileType.equals("image/png")) return new Result(false, "请上传图片");
        if (!imageFile.isEmpty()) {
            try {
                imageFile.transferTo(new File(path+fileName));
                food.setImageUrl("image/"+fileName);
            } catch (IOException e) {
//                throw new RuntimeException(e);
                return new Result(false, "系统错误", e);

            }
        }
        try {
            int count = foodService.addFood(food);
            if (count == 1) {
                return new Result(true, "添加成功");
            }
            return new Result(false, "添加失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }
}
