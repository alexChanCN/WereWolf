package com.cs.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by cs on 2017/8/10.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomRequest {
    private String date;
    private Integer phase;
    private Integer type;
}
