package com.cs.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by cs on 2017/8/8.
 */
@Data
@AllArgsConstructor
public class OrderRequest {
    private String openId;
    private String date;
    private Integer roomId;
    private Integer phase;
    private Integer number;
    private Integer type;            //1:付钱          //0:未付钱


}
