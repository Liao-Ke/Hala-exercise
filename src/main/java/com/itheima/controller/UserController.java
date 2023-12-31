package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户登录和注销Controller
 */
@Controller
@ResponseBody
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {
    @RequestMapping("/toMainPage")
    public String toMainPage() {
        return "main";
    }

    //注入userService
    @Autowired
    private UserService userService;

    /*
   用户登录
    */
    @RequestMapping("/login")
    public Result login(User user, HttpServletRequest request) {
//        try {
//            User u=userService.login(user);
//            /*
//            用户账号和密码是否查询出用户信息
//                是：将用户信息存入Session，并跳转到后台首页
//                否：Request域中添加提示信息，并转发到登录页面
//             */
//            if(u!=null){
//                request.getSession().setAttribute("USER_SESSION",u);
//                 return "redirect:/admin/main.jsp";
//            }
//            request.setAttribute("msg","用户名或密码错误");
//            return  "forward:/admin/login.jsp";
//        }catch(Exception e){
//            e.printStackTrace();
//            request.setAttribute("msg","系统错误");
//            return  "forward:/admin/login.jsp";
//        }
        try {
            User u = userService.login(user);
            if (u != null) {
                Map<String, String> uData = new HashMap<>();

                uData.put("userID", String.valueOf(u.getId()));
                uData.put("userRole", u.getRole());

                return new Result(true, "登录成功", uData);
            }
            return new Result(false, "登录失败");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统错误", e);
        }


    }

    /*
    注销登录
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        try {
            HttpSession session = request.getSession();
            //销毁Session
            session.invalidate();
            return "forward:/admin/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "系统错误");
            return "forward:/admin/login.jsp";
        }
    }
}
