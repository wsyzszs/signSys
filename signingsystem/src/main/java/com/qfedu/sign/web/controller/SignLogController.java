package com.qfedu.sign.web.controller;

import com.qfedu.sign.pojo.SignLog;
import com.qfedu.sign.pojo.User;
import com.qfedu.sign.service.SignLogService;
import com.qfedu.sign.vo.Result;
import com.qfedu.sign.vo.TableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class SignLogController {

    @Autowired
    private SignLogService Service;

    @RequestMapping("/signIn.do")
    public Result signIn(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user != null && Service.signIn(user.getId(),session)){
            return Result.setOK().setMsg("签到成功！");
        }
        return Result.setError().setMsg("网络异常，请稍后再试！");
    }

    @RequestMapping("/signOut.do")
    public Result signOut(HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user == null){
            return Result.setError().setMsg("请先登陆！");
        }
        if (Service.signOut(user.getId(),session)){
            return Result.setOK().setMsg("签退成功！");
        }
        return Result.setError().setMsg("网络异常，请稍后再试！");
    }

    @RequestMapping("/showLogByUid.do")
    public TableVo showLogByUid(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<SignLog> logs = Service.showLogByUid(user.getId());
        if (logs == null){
            return TableVo.setError().setMsg("签到记录为空！！");
        }
        return TableVo.setOK(logs,logs.size());
    }
}
