package com.cs.wechat.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by cs on 2017/9/12.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer phase;
    private Float workday;
    private Float weekend;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
