package com.admin.service.impl;

import com.admin.mapper.AdminUserMapper;
import com.admin.pojo.AdminUser;
import com.admin.service.AdminUserService;
import com.admin.utils.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser findByUserName(String username) {
        QueryWrapper<AdminUser> qw = new QueryWrapper<>();
        return adminUserMapper.selectOne(qw.eq("username", username));
    }

    @Override
    public void register(String username, String password) {
        String md5String = Md5Util.getMD5String(password);
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPassword(md5String);
        adminUserMapper.insert(adminUser);
    }
}

