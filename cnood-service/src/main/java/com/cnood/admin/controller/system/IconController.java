package com.cnood.admin.controller.system;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cnood.admin.entity.system.SysIcon;
import com.cnood.admin.service.system.SysIconService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author IconController
 * @Date 2023/7/4
 * @Description
 */
@RestController
@RequestMapping("/icon")
public class IconController {
    @Resource
    private SysIconService iconService;

    @GetMapping("/")
    public SaResult getIcon(@RequestParam int pageNo, @RequestParam int pageSize){
        System.out.println("pageNo = " + pageNo);
        System.out.println("pageSize = " + pageSize);
        Page<SysIcon> page = iconService.page(new Page<SysIcon>(pageNo,pageSize),new LambdaQueryWrapper<SysIcon>().select(SysIcon::getIcon));
        if(page == null){
            return SaResult.error("未检索到数据");
        }
        return SaResult.data(page);
    }
}
