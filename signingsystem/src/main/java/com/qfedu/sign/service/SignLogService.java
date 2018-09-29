package com.qfedu.sign.service;

import com.qfedu.sign.pojo.SignLog;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SignLogService {

    //签到信息展示
    List<SignLog> showLogByUid(Integer uid);

    //签到
    boolean signIn(Integer uid, HttpSession session);

    //签退
    boolean signOut(Integer uid,HttpSession session);

}
