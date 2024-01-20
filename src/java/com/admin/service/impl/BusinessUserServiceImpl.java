package com.admin.service.impl;

import com.admin.mapper.BusinessUserMapper;
import com.admin.pojo.BusinessUser;
import com.admin.service.BusinessUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessUserServiceImpl implements BusinessUserService {

    @Autowired
    private BusinessUserMapper businessUserMapper;

    @Override
    public List<BusinessUser> selectAll() {
        QueryWrapper<BusinessUser> qw = new QueryWrapper<>();
        return businessUserMapper.selectList(qw.select("id", "username", "telephone", "email", "user_pic", "introduction", "status"));
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

