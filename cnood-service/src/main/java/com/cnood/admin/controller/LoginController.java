package com.cnood.admin.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cnood.admin.entity.system.SysUser;
import com.cnood.admin.entity.user.UserWork;
import com.cnood.admin.service.system.SysUserService;
import com.cnood.admin.service.user.UserWorkService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LoginController
 * @Date 2023/6/30
 * @Description
 */
@RestController
@RequestMapping("/auth")
public class LoginController {
    @Resource
    private SysUserService userService;
    @Resource
    private UserWorkService userWorkService;

    @SaIgnore
    @PostMapping("/login")
    public SaResult login(@RequestBody SysUser loginUser){
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<>();
        query.eq(SysUser::getUsername, loginUser.getUsername());
        SysUser queryUser = userService.getOne(query);
        /*用户名是否存在*/
       if(queryUser!=null){
           if(queryUser.getPassword().equals(password)){
               System.out.println("密码正确");
               StpUtil.login(queryUser.getId());
               return SaResult.data(StpUtil.getTokenInfo());
           }
       }
        return SaResult.error("用户名或密码验证错误");
    }

    @SaCheckLogin
    @GetMapping("/logout")
    public SaResult logout(){
        StpUtil.logout();
        return SaResult.ok();
    }

    /*返回角色信息、权限信息、用户信息*/
    @SaCheckLogin
    @GetMapping("/userInfo")
    public SaResult getUserInfo(){
        Object userId = StpUtil.getLoginId();
        Long loginId = Long.valueOf(String.valueOf(userId));
        System.out.println((Long) loginId);

        List<String> roles = userService.getRoles(loginId);
        if(roles == null){
           return SaResult.error("用户基础角色为空");
        }
        List<String> permissions = userService.getPermissions(loginId);
        if(permissions.size() == 0){
            return SaResult.error("用户基础权限为空");
        }
        UserWork userWorkInfo = userWorkService.getById(loginId);
        if(userWorkInfo == null){
            return SaResult.error("用户未添加个人信息");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("roles",roles);
        map.put("permissions",permissions);
        map.put("username",userWorkInfo.getName());
        map.put("avatar",userWorkInfo.getAvatar());
        return SaResult.data(map);
    }

}
