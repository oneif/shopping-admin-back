package com.admin.service;

import com.admin.pojo.AdminUser;

public interface AdminUserService {
    // 根据用户名查询用户
    AdminUser findByUserName(String username);

    // 注册方法
    void register(String username, String password);
}
