package com.cnood.admin.controller.system;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.cnood.admin.entity.system.SysMenu;
import com.cnood.admin.service.system.SysMenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SysMenuController
 * @Date 2023/6/30
 * @Description
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {
    @Resource
    private SysMenuService menuService;

    @GetMapping("/")
    public SaResult getList() {
        return SaResult.data(menuService.list());
    }

    @GetMapping("/tree")
    public SaResult getTree() {
        List<SysMenu> menuList = menuService.list();

        //配置类
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setIdKey("id");
        treeNodeConfig.setParentIdKey("parentId");
        //构建树形
        List<Tree<Long>> trees = TreeUtil.build(menuList,0L,treeNodeConfig,((object, treeNode) -> {
            treeNode.setId(object.getId());
            treeNode.setParentId(object.getParentId());
            treeNode.putExtra("name",object.getName());
            treeNode.putExtra("sort",object.getSort());
        }));
        return SaResult.data(trees);
    }

    @GetMapping("/get/{id}")
    public SaResult getById(@PathVariable Long id) {
        return SaResult.data(menuService.getById(id));
    }

    @PostMapping("/create")
    public SaResult create(@RequestBody SysMenu menu){
        if(menu.getId() != null && menu.getName() != null && menu.getPath() != null){
            return SaResult.data(menuService.save(menu));
        }
        return SaResult.error();
    }

    @PutMapping("/update")
    public SaResult update(@RequestBody SysMenu menu){
        if(menuService.updateById(menu)){
            return SaResult.ok();
        }
        return SaResult.error();
    }

    @DeleteMapping("/delete")
    public SaResult delete(@RequestParam Long menuId){
        if(menuService.removeById(menuId)){
            return SaResult.ok();
        }
        return SaResult.error();
    }
}
