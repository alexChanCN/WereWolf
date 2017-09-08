package com.cs.wechat.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
