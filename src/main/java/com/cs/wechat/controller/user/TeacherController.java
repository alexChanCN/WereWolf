package com.cs.wechat.controller.user;

import com.cs.wechat.domain.model.Teacher;
import com.cs.wechat.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/user/teacher")
@Api(description = "教练模块" )
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    @ApiOperation(value="获取教练信息", notes="根据教练Id，获取教练信息")
    public Teacher getById(@PathVariable Integer id){
        return teacherService.get(id);
    }

    @GetMapping
    @ApiOperation(value="获取所有教练信息", notes="获取所有教练信息")
    public List<Teacher> getAll(){
        return teacherService.listAll();
    }
}
