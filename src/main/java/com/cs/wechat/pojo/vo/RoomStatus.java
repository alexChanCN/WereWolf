package com.cs.wechat.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cs on 2017/8/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomStatus {
    private Integer no;
    private Integer current;
    private Integer total;
    private String name;
    private String picUrl;
    private Float price;
    private String profile;
}
