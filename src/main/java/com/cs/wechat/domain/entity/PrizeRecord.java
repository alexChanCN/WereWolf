package com.cs.wechat.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
public class PrizeRecord implements Serializable{
    @Id
    @GeneratedValue
    Integer id;
    Date createTime;
    @ManyToOne
    Member member;
    //String openId;
    @ManyToOne
    Prize prize;

    Integer status;    //1:已经领取   0:未领取
    Date updateTime;

}
