package com.cnood.admin.entity.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import jakarta.annotation.Resource;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author MyMetaObjectHandler
 * @Date 2023/6/13
 * @Description
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Resource
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
