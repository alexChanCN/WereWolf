package com.cs.wechat.domain.model;

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
    private Float price;
    private String profile;
    private Integer type;           //1:整租房 2：散客房间



}
