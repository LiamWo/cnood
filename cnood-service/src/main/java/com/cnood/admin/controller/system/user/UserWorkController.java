package com.cnood.admin.controller.system.user;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cnood.admin.entity.user.UserWork;
import com.cnood.admin.service.user.UserWorkService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author UserWorkController
 * @Date 2023/7/5
 * @Description
 */
@RestController
@RequestMapping("/work")
public class UserWorkController {
    @Resource
    private UserWorkService userWorkService;

    @GetMapping("/")
    public SaResult getUserWork(@RequestParam int pageNo,@RequestParam int pageSize){
        return SaResult.data(userWorkService.page(new Page<UserWork>(pageNo,pageSize)));
    }

    @GetMapping("/get")
    public SaResult getUserWork(@RequestParam Long id){
        return SaResult.data(userWorkService.getById(id));
    }

    @PostMapping("/create")
    public SaResult createUserWork(@RequestBody UserWork userWork){
        return SaResult.data(userWorkService.save(userWork));
    }

    @PutMapping("/update")
    public SaResult updateUserWork(@RequestBody UserWork userWork){
        return SaResult.data(userWorkService.updateById(userWork));
    }

    @DeleteMapping("/delete")
    public SaResult deleteUserWork(@RequestParam Long id){
        System.out.println("id = " + id);
        return SaResult.data(userWorkService.removeById(id));
    }
}
