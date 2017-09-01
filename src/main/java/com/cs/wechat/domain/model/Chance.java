package com.cs.wechat.domain.model;

import lombok.Data;

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
public class Chance implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String openId;
    private Date time;
    private Integer reason;      //0、抽奖	1、签到 2、答题 3、转发（待定？）
    private Integer count;         //+1/-1

}
