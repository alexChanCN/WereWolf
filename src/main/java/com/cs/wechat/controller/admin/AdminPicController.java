package com.cs.wechat.controller.admin;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by cs on 2017/9/6.
 */
@RestController
@RequestMapping("/user/pic")
public class AdminPicController {

    //文件上传相关代码
    @PostMapping
    @ResponseBody
    public String upload(@RequestParam("test") MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        //String filePath = "E://test//";
        String filePath = "/data/pics/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "123.206.218.163:8080/RecordFile/" + fileName;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

}
