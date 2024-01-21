// 商家相关接口
package com.admin.controller;

import com.admin.pojo.BusinessUser;
import com.admin.pojo.PageResult;
import com.admin.pojo.Result;
import com.admin.service.BusinessUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BusinessController {

    @Autowired
    BusinessUserService businessUserService;

    @PostMapping("/business/list")
    public PageResult<List<BusinessUser>> businessList(String page, String size) {
        Page<BusinessUser> businessUsers = businessUserService.selectAll(Long.valueOf(page), Long.valueOf(size));
        Integer total = Math.toIntExact(businessUsers.getTotal());
        Integer pages = Math.toIntExact(businessUsers.getPages());
        return PageResult.success("成功", businessUsers.getRecords(), Integer.parseInt(page), Integer.parseInt(size), total, pages);
    }

    @PostMapping("/business")
    public Result updateBusiness(String businessId, String status) {
        businessUserService.updateStatusById(businessId, status);
        return Result.success("更新成功");
    }
}
