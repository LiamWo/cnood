package com.cnood.admin.config.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.cnood.admin.service.system.*;
import jakarta.annotation.Resource;

import java.util.List;

/**
 * @author StpInterfaceImpl
 * @Date 2023/6/30
 * @Description
 */
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private SysUserService userService;
    @Override
    public List<String> getPermissionList(Object loginId, String s) {
        return userService.getPermissions((Long) loginId);
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
        return userService.getRoles((Long) loginId);
    }
}
