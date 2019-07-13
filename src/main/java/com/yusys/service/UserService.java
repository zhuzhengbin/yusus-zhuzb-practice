package com.yusys.service;

import com.yusys.domain.User;
import com.yusys.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务层
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     */
    public void queryAllUsers(){
        userMapper.queryAllUsers();
    }

    /**
     * 插入用户信息
     * @param user
     */
    public void saveUser(User user){
        userMapper.saveUser(user);
    }
}
