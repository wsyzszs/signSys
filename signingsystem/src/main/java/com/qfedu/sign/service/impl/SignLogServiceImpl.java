package com.qfedu.sign.service.impl;

import com.qfedu.sign.mapper.SignLogMapper;
import com.qfedu.sign.mapper.UserMapper;
import com.qfedu.sign.pojo.SignLog;
import com.qfedu.sign.pojo.User;
import com.qfedu.sign.service.SignLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class SignLogServiceImpl implements SignLogService {

    @Autowired
    private SignLogMapper mapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SignLog> showLogByUid(Integer uid) {
        return mapper.selectByUid(uid);
    }

    @Override
    public boolean signIn(Integer uid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getFlag()>0){
            return false;
        }
        if (mapper.insert(uid) > 0){
            int hours = new Date().getHours();
            int minutes = new Date().getMinutes();
            int id = mapper.selectIdByUid(uid);
            String stat = "迟到";
            if (hours == 9 && minutes > 5) {
                mapper.updateStatById(id,stat);
            }else if (hours > 9) {
                mapper.updateStatById(id,stat);
            }

            user.setFlag(1);
            userMapper.updateByPrimaryKey(user);
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }

    @Override
    public boolean signOut(Integer uid,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null || user.getFlag()>1){
            return false;
        }
        int hours = new Date().getHours();
        int id = mapper.selectIdByUid(uid);
        String stat = "早退";
        if (hours < 21) {
            mapper.updateStatById(id,stat);
        }

        user.setFlag(2);
        userMapper.updateByPrimaryKey(user);
        session.setAttribute("user",user);
        return mapper.updateSignoutById(id) > 0;
    }
}
