package com.cnood.admin.service.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author UploadService
 * @Date 2023/7/6
 * @Description
 */
@Service
public class UploadService {
    /**
     * MultipartFile SpringMVC 提供的文件上传接受的类
     * 底层自动和HttpRequest 中的request.getInputStream()融合，从而达到文件上传的效果
     * 文件上传的底层原理就是 request.getInputStream()
     * @param multipartFile
     * @param filename
     * @return
     */
    public String uploadImg(MultipartFile multipartFile,String dir) throws IOException {
        // 制定上传文件目录
        File targetFile = new File("E:/tmp/upload");
        if(!targetFile.exists())targetFile.mkdirs();
        multipartFile.transferTo(targetFile);

        return "ok";
    }
}
