package com.admin.pojo;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
// lombok 在编译阶段 为实体类自动添加getter setter toString方法
// pom 文件中引入依赖 在实体类上添加注解
public class AdminUser {
    private Long id;//主键ID
    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;//创建时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;//更新时间
}
