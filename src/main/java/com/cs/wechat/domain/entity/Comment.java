package com.cs.wechat.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
@Data
public class Comment implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private Date time;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    private Member member;

}
