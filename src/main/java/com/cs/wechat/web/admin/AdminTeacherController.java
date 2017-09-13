package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.domain.entity.Teacher;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;


/**
 * Created by cs on 2017/8/8.
 */
@RestController
@RequestMapping("/admin/teacher")
@Api(description = "教练管理模块" )
public class AdminTeacherController extends BaseController<Teacher,Integer>{

}
