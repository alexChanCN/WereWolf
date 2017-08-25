package com.github.binarywang.demo.wechat.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
@Data
public class OrderInfo implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Member member;
    /*private String openId;
    private String phoneNo;*/

    @ManyToOne
    private Room room;
    @ManyToOne
    private Seat seat;        //null表示预定整间

    @Temporal(TemporalType.DATE)
    private Date date;
    private Integer phase;
    private String clerkName;
    private Integer status;

}
