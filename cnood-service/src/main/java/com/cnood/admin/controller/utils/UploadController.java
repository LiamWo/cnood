package com.cnood.admin.controller.utils;

import cn.dev33.satoken.util.SaResult;
import com.cnood.admin.service.utils.UploadService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author UploadController
 * @Date 2023/7/6
 * @Description
 */
@RestController
@RequestMapping("/tools")
public class UploadController {
    @Resource
    private UploadService uploadService;

    @GetMapping("/upload")
    @ResponseBody
    public SaResult upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        if(multipartFile.isEmpty()){
            return SaResult.error("No upload file");
        }
        // 用户指定上传文件夹
        String dir = request.getParameter("dir");
        return SaResult.ok(uploadService.uploadImg(multipartFile,dir));
    }

}
