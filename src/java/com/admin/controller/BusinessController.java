// 商家相关接口
package com.admin.controller;

import com.admin.pojo.BusinessUser;
import com.admin.pojo.Result;
import com.admin.service.BusinessUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BusinessController {

    @Autowired
    BusinessUserService businessUserService;

    @PostMapping("/business")
    public Result<List<BusinessUser>> business(@RequestParam("action") String action, String businessId, String status) {
        switch (action) {
            case "list":
                List<BusinessUser> businessUsers = businessUserService.selectAll();
                return Result.success("成功", businessUsers);
            case "update":
                businessUserService.updateStatusById(businessId, status);
                return Result.success("更新成功");
        }
        return null;
    }
}
