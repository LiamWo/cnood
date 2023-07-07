package com.cnood.admin.controller.system;

import cn.dev33.satoken.util.SaResult;
import com.cnood.admin.entity.system.SysNotice;
import com.cnood.admin.service.system.SysNoticeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author NoticeController
 * @Date 2023/7/3
 * @Description
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private SysNoticeService noticeService;

    @GetMapping("/")
    public SaResult getNotice(){
        List<SysNotice> list = noticeService.list();
        if(list == null){
            return SaResult.error("未检索到公告");
        }
        return SaResult.data(list);
    }

    @GetMapping("/get")
    public SaResult getNotice(@RequestParam Long id){
        SysNotice notice = noticeService.getById(id);
        if(notice == null){
            return SaResult.error("未检索到数据");
        }
        return SaResult.data(notice);
    }

    @PostMapping("/create")
    public SaResult createNotice(@RequestBody SysNotice notice){
        boolean b = noticeService.save(notice);
        if(!b){
            return SaResult.error("添加失败");
        }
        return SaResult.ok("添加成功");
    }

    @PutMapping("/update")
    public SaResult updateNotice(@RequestBody SysNotice notice){
        boolean b = noticeService.updateById(notice);
        if(!b){
            return SaResult.error("修改失败");
        }
        return SaResult.ok("修改成功");
    }

    @DeleteMapping("/delete")
    public SaResult deleteNotice(@RequestParam Long id){
        boolean b = noticeService.removeById(id);
        if(!b){
            return SaResult.error("删除失败");
        }
        return SaResult.ok("删除成功");
    }
}
