package com.github.binarywang.demo.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by cs on 2017/8/25.
 */
@Data
@AllArgsConstructor
public class RoomStatus {
    private Integer no;
    private Integer current;
    private Integer total;
}
