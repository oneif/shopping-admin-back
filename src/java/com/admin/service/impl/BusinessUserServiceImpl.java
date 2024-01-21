package com.admin.service.impl;

import com.admin.mapper.BusinessUserMapper;
import com.admin.pojo.BusinessUser;
import com.admin.service.BusinessUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    @Autowired
    private BusinessUserMapper businessUserMapper;

    @Override
    public Page<BusinessUser> selectAll(Long page, Long size) {
        Page<BusinessUser> businessUserPage = new Page<>(page, size);
        QueryWrapper<BusinessUser> qw = new QueryWrapper<>();
        qw.select("id", "username", "telephone", "email", "user_pic", "introduction", "status");
        return businessUserMapper.selectPage(businessUserPage, qw);
    }

    @Override
    public void updateStatusById(String idStr, String status) {
        String[] ids = idStr.split(",");
        BusinessUser businessUser = new BusinessUser();
        for (String id : ids) {
            businessUser.setId(Long.valueOf(id));
            businessUser.setStatus(status);
            businessUserMapper.updateById(businessUser);
        }
    }
}

