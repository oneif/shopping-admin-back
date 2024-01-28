package com.admin.controller;

import com.admin.pojo.ProductType;
import com.admin.pojo.Result;
import com.admin.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/type")
    public Result productType(@RequestParam("action") String action, ProductType productType) {
        switch (action) {
            case "add" -> {
                ProductType productTypeName = productTypeService.selectByName(productType.getName());
                if (productTypeName == null) {
                    productTypeService.addProductType(productType);
                    return Result.success("添加成功");
                } else return Result.error("分类名称已存在");
            }
            case "delete" -> {
                productTypeService.deleteProductTypeById(String.valueOf(productType.getId()));
                return Result.success("删除成功");
            }
            case "update" -> {
                productTypeService.updateProductType(productType);
                return Result.success("更新成功");
            }
            case "search" -> {
                List<ProductType> search = productTypeService.search(productType.getName());
                return Result.success("成功", search);
            }
            case "selectAll" -> {
                List<ProductType> productTypes = productTypeService.selectAllProductType();
                return Result.success("成功", productTypes);
            }
        }
        return null;
    }
}


