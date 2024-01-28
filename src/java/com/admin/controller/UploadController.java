package com.admin.controller;

import com.admin.pojo.Result;
import com.admin.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/admin")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file) throws Exception {
        String url = "http://localhost:8080/admin/";
        String fileName = uploadService.uploadImage(file);
        return Result.success("上传成功", url + fileName);
    }
}
