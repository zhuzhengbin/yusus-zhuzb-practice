package com.yusys.repository.mapper;

import com.yusys.domain.User;
import org.springframework.stereotype.Component;

/**
 * 持久层接口
 */
@Component
public interface UserMapper {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    void saveUser(User user);
    /**
     * 根据ID查找用户的图片
     * @param id
     * @return
     */
    User readPhoto(String id);

    /**
     * 新增用户
     * @param user
     */
    boolean addUser(User user);

    /**
     * 获取用户详细信息
     * @param id
     */
    User getUserDetailById(String id);


}
