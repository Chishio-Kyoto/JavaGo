package com.houle.dao;

import com.houle.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    /**
     * 查询所有用户
     */
    List<User> selectUserAll();

    /**
     * 根据id查询用户
     */
    List<User> selectUser(int id);

    /**
     * 根据姓名和密码精确查找
     */
    User selectUserByNP(Map<String, String> map);

    /**
     * 增加用户
     */
    void addUser(User user);

    /**
     * 删除指定id用户
     */
    void deleteUser(int id);

    /**
     * 更新指定id用户
     */
    void updateUser(User user);
}
