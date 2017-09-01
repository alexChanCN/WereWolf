package com.cs.wechat.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by cs on 2017/8/8.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentInfo {
    private String openId;
    private Integer teacherId;
    //private Date date;
    private String comment;
}
