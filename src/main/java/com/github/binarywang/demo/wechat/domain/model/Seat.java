package com.github.binarywang.demo.wechat.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cs on 2017/7/24.
 */
@Entity
@Data
public class Seat implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private Integer seatNo;
    //private Integer seat_price;
    private Integer status;   //1:预定  2:付款  3.确认  0：空位

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

}
