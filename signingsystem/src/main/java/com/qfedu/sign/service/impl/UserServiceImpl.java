package com.qfedu.sign.service.impl;

import com.qfedu.sign.mapper.UserMapper;
import com.qfedu.sign.pojo.User;
import com.qfedu.sign.service.UserService;
import com.qfedu.sign.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public boolean register(User user) {
        return mapper.insert(user)>0;
    }

    @Override
    public boolean login(String username, String password, HttpSession session) {
        User user = mapper.selectByUsername(username);
        if (user != null){
            if (Objects.equals(user.getPassword(),password)){
                session.setAttribute("user",user);
                return true;
            }
        }
        return false;
    }


    @Override
    public void logout(HttpSession session) {
       session.removeAttribute("user");
       session.invalidate();
    }


    @Override
    public boolean modify(User user, HttpSession session) {
        User user1 = (User) session.getAttribute("user");
        if (user1 == null){
            return false;
        }
        user.setId(user1.getId());
        if (mapper.updateByPrimaryKey(user)>0){
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }

    @Override
    public String recover(String username, String email,HttpSession session) {
        User user = mapper.selectByUsername(username);
        if (user != null && user.getEmail().equals(email)){
            session.invalidate();
            return user.getPassword();
        }
        return null;
    }
}
