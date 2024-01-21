package com.admin.service;

import com.admin.pojo.BusinessUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface BusinessUserService {

    // 查询所有商户信息
    Page<BusinessUser> selectAll(Long page, Long size);

    // 根据id更改审核状态
    void updateStatusById(String ids, String status);
}
