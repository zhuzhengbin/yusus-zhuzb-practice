package com.yusys.repository.mapper;

import com.yusys.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 持久层接口
 */
@Component
public interface UserMapper {

    /**
     * 查询所有用户
     */
    List<User> queryAllUsers();

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    void saveUser(User user);
}
