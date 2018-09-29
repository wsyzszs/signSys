package com.qfedu.sign.service;

import com.qfedu.sign.pojo.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    boolean register(User user);

    boolean login(String username, String password, HttpSession session);

    void logout(HttpSession session);

    boolean modify(User user,HttpSession session);

    String recover(String username,String email,HttpSession session);
}
