package com.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.admin.pojo.ProductType;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作商品分类相关数据接口
 */
@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType> {

}
