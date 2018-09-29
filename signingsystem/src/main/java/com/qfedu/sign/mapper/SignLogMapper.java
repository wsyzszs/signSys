package com.qfedu.sign.mapper;

import com.qfedu.sign.pojo.SignLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignLogMapper {

    //签到
    int insert(Integer uid);

    //查询当前用户最后一次的签到记录id
    int selectIdByUid(Integer uid);

    //签退
    int updateSignoutById(Integer id);

    //签到状态记录
    int updateStatById(@Param("id") Integer id, @Param("stat") String stat);

    //签到信息展示
    List<SignLog> selectByUid(Integer uid);

}