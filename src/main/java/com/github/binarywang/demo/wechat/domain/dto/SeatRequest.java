package com.github.binarywang.demo.wechat.domain.dto;

import lombok.Data;

/**
 * Created by cs on 2017/8/30.
 */
@Data
public class SeatRequest {
    private String date;
    private Integer roomId;
    private Integer phase;
}
