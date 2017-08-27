package com.github.binarywang.demo.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Created by cs on 2017/8/10.
 */
@Data
@AllArgsConstructor
public class RoomRequest {
    private Date date;
    private Integer roomId;
    private Integer phase;
}
