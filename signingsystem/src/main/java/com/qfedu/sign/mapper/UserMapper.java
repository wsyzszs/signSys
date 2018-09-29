package com.qfedu.sign.mapper;

import com.qfedu.sign.pojo.User;

public interface UserMapper {

    int insert(User record);

    User selectByUsername(String username);

    int updateByPrimaryKey(User record);

}