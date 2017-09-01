package com.cs.wechat.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cs on 2017/9/1.
 */
@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String phoneNo;
    private String imgUrl;
    private String profile;
}
