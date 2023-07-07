package com.cnood.admin.service.impl.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cnood.admin.entity.system.*;
import com.cnood.admin.mapper.system.*;
import com.cnood.admin.service.system.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Leah
 * @since 2023-07-03
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserRoleMapper userRoleMapper;
    @Resource
    private SysRoleMapper roleMapper;
    @Resource
    private SysRoleMenuMapper roleMenuMapper;
    @Resource
    private SysMenuMapper menuMapper;

    public List<SysRole> getUserRolesById(Long loginId){
        /*通过用户ID获取角色ID集合*/
        List<SysUserRole> userRoleIds = userRoleMapper.selectList(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId,loginId).select(SysUserRole::getRoelId));
        List<SysRole> roleIds = new ArrayList<>();
        /*返回角色列表*/
        for(SysUserRole roleId : userRoleIds){
            roleIds.add(roleMapper.selectOne(new LambdaQueryWrapper<SysRole>().eq(SysRole::getId,roleId)));
        }
        return roleIds;
    }

    @Override
    public List<String> getPermissions(Long loginId) {
        List<SysRole> roleIds = getUserRolesById(loginId);
        /*通过角色ID获取菜单ID集合*/
        List<SysRoleMenu> roleMenuIds = new ArrayList<>();
        for(SysRole roleMenuId : roleIds){
            roleMenuIds.add(roleMenuMapper.selectOne(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getId,roleMenuId).select(SysRoleMenu::getId)));
        }
        List<String> permissions = new ArrayList<>();
        /*通过菜单ID查找菜单名称*/
        for(SysRoleMenu roleMenuId : roleMenuIds) {
            permissions.add(String.valueOf(menuMapper.selectOne(new LambdaQueryWrapper<SysMenu>().eq(SysMenu::getId,roleMenuId).select(SysMenu::getPermission))));
        }
        return permissions;
    }

    @Override
    public List<String> getRoles(Long loginId) {
        List<SysRole> roleIds = getUserRolesById(loginId);
        List<String> roles = new ArrayList<>();
        LambdaQueryWrapper<SysRole> query = new LambdaQueryWrapper<>();
        for(SysRole roleId : roleIds){
            roles.add(String.valueOf(roleMapper.selectOne(new LambdaQueryWrapper<SysRole>().eq(SysRole::getId,roleId).select(SysRole::getCode))));
        }
        return roles;
    }
}
