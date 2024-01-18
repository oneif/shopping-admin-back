package com.admin.service;

import com.admin.pojo.BusinessUser;

import java.util.List;

public interface BusinessUserService {

    // 查询所有商户信息
    List<BusinessUser> selectAll();

    // 根据id更改审核状态
    String updateStatusById(Long id);
}
