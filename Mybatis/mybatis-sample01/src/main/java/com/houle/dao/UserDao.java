package com.houle.dao;

import com.houle.pojo.User;

import java.util.List;

public interface UserDao {
    List<User> selectUser(int id);
}
