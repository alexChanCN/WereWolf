package com.cs.wechat.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by cs on 2017/7/24.
 */
@Entity
@Data
public class Room implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String picUrl;
    private Integer seatCount;
    //private Float price;
    private String profile;
    private Integer type;           //1:整租房 2：散客房间

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Price> prices;


}
