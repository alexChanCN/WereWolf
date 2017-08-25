package com.github.binarywang.demo.wechat.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cs on 2017/8/11.
 */
@Entity
@Data
public class Prize implements Serializable{
    @Id
    @GeneratedValue
    Integer id;
    Date createTime;
    @ManyToOne
    Member member;
    //String openId;
    Integer prizeId;
    Integer status;    //1:已经领取   0:未领取
    Date updateTime;

}
