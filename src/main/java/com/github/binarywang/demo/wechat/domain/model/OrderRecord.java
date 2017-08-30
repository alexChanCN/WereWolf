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
public class OrderRecord implements Serializable{

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Room room;

    /*@ManyToOne
    private Seat seat;        //null表示预定整间*/

    @Temporal(TemporalType.DATE)
    private Date date;
    private Integer phase;
    private Integer number;
    private String clerkName;
    private Integer status;

}
