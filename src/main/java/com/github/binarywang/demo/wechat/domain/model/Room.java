package com.github.binarywang.demo.wechat.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cs on 2017/7/24.
 */
@Entity
@Data
public class Room implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String picUrl;
    private Integer seatCount;
    private float price;
    private Integer status;         //1：有座位、0：无座位
    private Integer type;           //1:整租房 2：散客房间



}
