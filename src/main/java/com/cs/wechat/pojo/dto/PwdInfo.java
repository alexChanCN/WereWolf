package com.cs.wechat.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by cs on 2017/8/25.
 */
@Data
@AllArgsConstructor
public class PwdInfo {
    String username;
    String oldPwd;
    String newPwd;
}
