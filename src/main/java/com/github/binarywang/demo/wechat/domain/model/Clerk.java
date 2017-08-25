package com.github.binarywang.demo.wechat.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
@Data
public class Clerk {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String phone;
    private Date create_time;

}
