package com.github.binarywang.demo.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by cs on 2017/8/8.
 */
@Data
@AllArgsConstructor
public class ReserveInfo {
    private Integer roomId;
    private Integer seatId;
    private Integer phase;

    private String openId;
}
