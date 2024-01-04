package com.itheima.controller;

import com.itheima.domain.Menu;
import com.itheima.domain.Store;
import com.itheima.service.FoodService;
import com.itheima.service.StoreService;
import entity.PageResult;
import entity.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class StoreController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private FoodService foodService;

//    @RequestMapping("/testUp")
//    public Result testUp(MultipartFile file, HttpServletRequest request){
//        String path= request.getServletContext().getRealPath("/")+"files/";
//        String fileType=file.getContentType();
//        if(!fileType.equals("image/jpeg") && !fileType.equals("image/png")) return new Result(false,"请上传图片");
//        if(!file.isEmpty()){
//            try {
//                file.transferTo(new File(path+ UUID.randomUUID() +".jpg"));
//            } catch (IOException e) {
////                throw new RuntimeException(e);
//                return new Result(false, "系统错误", e);
//
//            }
//        }
//        return  new Result(true, "获取成功", file.getContentType());
//    }
    @RequestMapping("/getStore")
    public Result getStore(Integer pageNum,Integer pageSize) {
        if(pageNum==null) pageNum=1;

        if (pageSize==null) pageSize=5;
        try {
            PageResult stores = storeService.getStore(pageNum, pageSize);


                return new Result(true, "获取成功", stores);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/getStoreByUserID")
    public Result getStoreByUserId(int userID) {
        try {
            List<Store> stores = storeService.getStoreByUserId(userID);

                return new Result(true, "获取成功", stores);

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
    public Result updateStore(Store store,MultipartFile imageFile, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/") + "files/";
        String fileType = imageFile.getContentType();
        String fileName = UUID.randomUUID() + ".jpg";
        if (!fileType.equals("image/jpeg") && !fileType.equals("image/png")) return new Result(false, "请上传图片");
        if (!imageFile.isEmpty()) {
            try {
                imageFile.transferTo(new File(path+fileName));
                store.setImageUrl("image/"+fileName);
            } catch (IOException e) {
//                throw new RuntimeException(e);
                return new Result(false, "系统错误", e);

            }
        }
        try {
            int count = storeService.updateStore(store);
            if (count > 0) {
                return new Result(true, "更新成功");
            }
            return new Result(false, "更新失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("/getStoreById")
    public Result getStoreById(int storeID) {
        try {
            Store store = storeService.getStoreById(storeID);
            return new Result(true, "获取成功", store);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }
    }

    @RequestMapping("addStore")
    public Result addStore(Store store,MultipartFile imageFile, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/") + "files/";
        String fileType = imageFile.getContentType();
        String fileName = UUID.randomUUID() + ".jpg";
        if (!fileType.equals("image/jpeg") && !fileType.equals("image/png")) return new Result(false, "请上传图片");
        if (!imageFile.isEmpty()) {
            try {
                imageFile.transferTo(new File(path+fileName));
                store.setImageUrl("image/"+fileName);
            } catch (IOException e) {
//                throw new RuntimeException(e);
                return new Result(false, "系统错误", e);

            }
        }
            try {

                int count = storeService.addStore(store);
                if (count == 1) {
                    return new Result(true, "添加成功");
                }
                return new Result(false, "添加失败", count);
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "系统错误", e);
            }

    }
}
