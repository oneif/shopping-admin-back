package com.admin.controller;

import com.admin.pojo.AdminUser;
import com.admin.pojo.Result;
import com.admin.service.AdminUserService;
import com.admin.utils.JwtUtil;
import com.admin.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{4,16}$") String username, @Pattern(regexp = "^\\S{4,16}$") String password) {
        // 查询用户名
        AdminUser loginUser = adminUserService.findByUserName(username);
        if (loginUser == null) {
            // 注册
            adminUserService.register(username, password);
            return Result.success("注册成功");
        } else {
            return Result.error("用户名已存在");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{4,16}$") String username, @Pattern(regexp = "^\\S{4,16}$") String password) {
        // 查询用户名
        AdminUser loginAdminUser = adminUserService.findByUserName(username);
        // 判断用户是否存在
        if (loginAdminUser == null) return Result.error("用户名错误");
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginAdminUser.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginAdminUser.getId());
            claims.put("username", loginAdminUser.getUsername());
            String token = JwtUtil.getToken(claims);

            return Result.success("登录成功", token);
        }
        return Result.error("密码错误");
    }
}
