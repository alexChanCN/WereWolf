package com.cs.wechat.controller.admin;

import com.cs.wechat.domain.model.Teacher;
import com.cs.wechat.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/teacher")
@Api(description = "教练管理模块" )
public class AdminTeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/page")
    @ApiOperation(value="分页获取教练信息", notes="分页获取教练信息")
    public Page<Teacher> findByPage(@RequestHeader("Authorization")String authorization,@RequestParam Integer start, @RequestParam Integer size){
        return teacherService.findByPage(start, size);
    }

    @GetMapping()
    @ApiOperation(value="获取所有教练信息", notes="获取所有教练信息")
    public List<Teacher> findAll(@RequestHeader("Authorization")String authorization){
        return teacherService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="根据id，获取该教练信息", notes="根据id，获取该教练信息")
    public Teacher getOne(@RequestHeader("Authorization")String authorization,@PathVariable Integer id){
        return teacherService.get(id);
    }

    @PostMapping
    @ApiOperation(value="添加", notes="根据Teacher,添加教练信息")
    public String add(@RequestHeader("Authorization")String authorization,@RequestBody Teacher teacher){
        teacherService.save(teacher);
        return "success";
    }

    @PutMapping
    @ApiOperation(value="修改", notes="根据Teacher,修改教练信息")
    public String update(@RequestHeader("Authorization")String authorization,@RequestBody Teacher teacher){
        teacherService.update(teacher);
        return "success";
    }


    @DeleteMapping
    @ApiOperation(value="删除", notes="根据id,删除教练信息")
    public String delete(@RequestHeader("Authorization")String authorization,@PathVariable Integer id){
        teacherService.delete(id);
        return "success";
    }
}
