package com.cs.wechat.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cs on 2017/8/27.
 */
@Entity
@Data
public class AnswerRecord implements Serializable{
    @Id
    @GeneratedValue
    Integer id;
    @Temporal(TemporalType.DATE)
    Date date;
    String openId;
    Integer status;    //1:回答正确  0:回答错误
}
