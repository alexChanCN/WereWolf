package com.cs.wechat.domain.dto;

import lombok.Data;

/**
 * Created by cs on 2017/8/11.
 */
@Data
public class RegisterInfo {
    private String openId;

    private String phoneNo;         //电话号码
    private String idCard;          //身份证
    private String name;            //真实姓名
}
