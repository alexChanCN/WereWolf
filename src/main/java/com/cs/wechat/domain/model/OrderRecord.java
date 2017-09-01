package com.cs.wechat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
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

    private Integer type;            //1:付钱          //0:未付钱

    @Temporal(TemporalType.DATE)
    private Date date;
    private Integer phase;
    private Integer number;
    private String clerkName;
    private Integer status;

}
