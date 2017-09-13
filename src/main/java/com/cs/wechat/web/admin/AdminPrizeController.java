package com.cs.wechat.web.admin;

import com.cs.wechat.core.BaseController;
import com.cs.wechat.domain.entity.Prize;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cs on 2017/8/10.
 */
@RestController
@RequestMapping("/admin/prize")
@Api(description = "奖品管理模块")
public class AdminPrizeController extends BaseController<Prize,Integer>{

}
