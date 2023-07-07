package com.cnood.admin.controller.system;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import cn.hutool.core.convert.ConverterRegistry;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cnood.admin.entity.system.SysUser;
import com.cnood.admin.service.system.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author SysUserController
 * @Date 2023/6/30
 * @Description
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Resource
    private SysUserService userService;

    @GetMapping("/")
    public SaResult getAll(@RequestParam int pageNo, @RequestParam int pageSize){
        Page<SysUser> page = userService.page(new Page<SysUser>(pageNo,pageSize));
        if(page == null){
            return SaResult.error("未检索到数据");
        }
        return SaResult.data(page);
    }

    @GetMapping("/get")
    public SaResult getUser(@RequestParam Long id){
        SysUser user = userService.getById(id);
        if(user == null){
            return SaResult.error("未检索到数据");
        }
        return SaResult.data(user);
    }

    @PostMapping("/create")
    public SaResult createUser(@RequestBody SysUser user){
        boolean b = userService.save(user);
        if(!b){
            return SaResult.error("添加失败");
        }
        return SaResult.ok("添加成功");
    }

    @PutMapping("/update")
    public SaResult updateUser(@RequestBody SysUser user){
        boolean b = userService.updateById(user);
        if(!b){
            return SaResult.error("修改失败");
        }
        return SaResult.ok("修改成功");
    }

    @DeleteMapping("/delete")
    public SaResult deleteUser(@RequestBody Long id){
        boolean b = userService.removeById(id);
        if(!b){
            return SaResult.error("删除失败");
        }
        return SaResult.ok("删除成功");
    }

}
