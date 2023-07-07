package com.cnood.admin.controller.system;


import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.cnood.admin.entity.system.SysDept;
import com.cnood.admin.service.system.SysDeptService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Leah
 * @since 2023-06-19
 */
@RestController
@RequestMapping("/sys-dept")
public class SysDeptAction {


    @Resource
    private SysDeptService sysDeptService;

    @GetMapping("/")
    public SaResult getList(){
        List<SysDept> list = sysDeptService.list();
        if(list == null){
            return SaResult.error("未检索到部门信息");
        }
        return SaResult.data(list);
    }

    @GetMapping(value = "/tree")
    public SaResult list() {
        //获取所有菜单数据
        List<SysDept> deptList = sysDeptService.list();
        if(deptList == null){
            return SaResult.error("未检索到部门信息");
        }
        //配置类
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setIdKey("id");
        treeNodeConfig.setParentIdKey("parentId");
        //构建树形
        List<Tree<Long>> trees = TreeUtil.build(deptList,0L,treeNodeConfig,((object, treeNode) -> {
            treeNode.setId(object.getId());
            treeNode.setParentId(object.getParentId());
            treeNode.putExtra("name",object.getName());
            treeNode.putExtra("sort",object.getSort());
        }));

        return SaResult.data(trees);
    }

    @GetMapping(value = "/{id}")
    public SaResult getById(@PathVariable("id") Long id) {
        return SaResult.data(sysDeptService.getById(id));
    }

    @PostMapping(value = "/create")
    public SaResult create(@RequestBody SysDept params) {
         if(sysDeptService.save(params) ){
	return SaResult.ok("新增成功！");
        }
        return SaResult.error("创建失败！");
    }

    @PostMapping(value = "/delete")
    public SaResult delete(@RequestParam Long id) {
         if(sysDeptService.removeById(id)){
	return SaResult.ok("删除成功！");
        }
        return SaResult.error("删除失败！");
    }

    @PostMapping(value = "/update")
    public SaResult update(@RequestBody SysDept params) {
        if(sysDeptService.updateById(params)){
	return SaResult.ok("更新成功！");
        }
        return SaResult.error("更新失败！");
    }
}
