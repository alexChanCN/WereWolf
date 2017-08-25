package com.github.binarywang.demo.wechat.domain.model;

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
    @Column(name = "award_count")
    private Integer awardCount;    //默认值1
    //用户输入
    @Column(name = "phone_no")
    private String phoneNo;
    @Column(name = "id_card")
    private String idCard;         //身份证
    private String name;            //真实姓名
    //微信公众号获取
    private String openId;
    private String sex;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "head_img_url")
    private String headImgUrl;
    @Column(name = "create_time")
    private Date createTime;

}
