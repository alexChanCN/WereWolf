package com.cs.wechat.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
@Data
public class Question implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String answer;

}
