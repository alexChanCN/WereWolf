package com.cs.wechat.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
@Data
public class Member implements Serializable{
    //自动生成
    @Id
    @GeneratedValue
    private Integer id;
    private Integer awardCount;    //默认值1
    //用户输入
    private String phoneNo;         //电话
    private String idCard;         //身份证
    private String name;            //真实姓名
    //微信公众号获取
    private String openId;
    private String nickName;
    private String headImgUrl;
    private Date createTime;

}
