package com.yusys.service;

import com.yusys.domain.User;
import com.yusys.repository.mapper.UserMapper;
import com.yusys.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * 服务层
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 存储用户数据
     * @param user
     * @return
     */
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    public byte[] readPhoto(String id){
//        byte[] photoBytes = IOUtils.blobToBytes(userMapper.readPhoto(id));
        byte[] photoBytes = userMapper.readPhoto(id).getPhoto();
        return photoBytes;
    }

    /**
     * 新增用户数据
     * @param user
     * @return
     */
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }


    /**
     * 获取用户详细数据
     * @param id
     * @return
     */
    public User getUserDetailById(String id) {
        return userMapper.getUserDetailById(id);
    }

}
