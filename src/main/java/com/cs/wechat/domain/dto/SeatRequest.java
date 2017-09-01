package com.cs.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cs on 2017/8/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequest {
    private String date;
    private Integer roomId;
    private Integer phase;
}
