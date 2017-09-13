package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.domain.entity.Question;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/9.
 */
@RestController
@RequestMapping("/admin/question")
@Api(description = "答题管理模块")
public class AdminQuestionController extends BaseController<Question,Integer>{

}
