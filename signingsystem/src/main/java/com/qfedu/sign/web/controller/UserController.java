package com.qfedu.sign.web.controller;

import com.qfedu.sign.pojo.User;
import com.qfedu.sign.service.UserService;
import com.qfedu.sign.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/recover.do")
    public Result recover(String username,String email,HttpSession session){
        if (username == null || email == null){
            return Result.setError().setMsg("用户信息不完整，找回密码失败！");
        }
        String password = service.recover(username, email,session);
        if (password == null){
            return Result.setError().setMsg("验证用户名/邮箱错误，找回密码失败！");
        }
        return Result.setOK().setData(password);
    }

    @RequestMapping("/register.do")
    public Result register(User user){
        System.out.println(user);
        if (user == null || user.getUsername() == null || user.getPassword() == null || user.getEmail() == null){
            return Result.setError().setMsg("注册信息不完整！");
        }
        if (service.register(user)){
            return Result.setOK();
        }
        return Result.setError().setMsg("服务器异常，请稍后再试！");
    }

    @RequestMapping("/login.do")
    public Result login(String username, String password, HttpSession session){
        if (username == null || password == null){
            return Result.setError().setMsg("用户名/密码不完整！");
        }
        if (service.login(username, password, session)){
            return Result.setOK();
        }
        return Result.setError().setMsg("用户名/密码不正确！");
    }

    @RequestMapping("/logout.do")
    public void logout(HttpSession session){
        service.logout(session);
    }

    @RequestMapping("/modify.do")
    public Result modify(User user,HttpSession session){
        if (user != null && user.getId() != null){
            if (service.modify(user,session)){
                return Result.setOK();
            }
        }
        return Result.setError().setMsg("信息更改失败！");
    }
}
