package com.cs.wechat.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by cs on 2017/8/25.
 */
@Data
public class QuestionInfo {
    private Integer id;
    private String title;
    private List<OptionInfo> optionInfos;
    private String answer;
}
