package com.houle.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    // 用户ID
    private Long userId;
    // 用户姓名
    private String name;
    // 用户头像
    private String profileImg;
    // 用户邮箱
    private String email;
    // 用户性别
    private String gender;
    // 用户状态：0:禁止使用本商城, 1:允许使用本商城
    private Integer enableStatus;
    // 用户类别：1、顾客 2、店家 3、超级管理员
    private Integer userType;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date lastEditTime;
}
