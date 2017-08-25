package com.github.binarywang.demo.wechat.utils;

import com.github.binarywang.demo.wechat.domain.dto.OptionInfo;
import com.github.binarywang.demo.wechat.domain.dto.QuestionInfo;
import com.github.binarywang.demo.wechat.domain.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cs on 2017/8/25.
 */
public class QuestionUtils {
    private static List<OptionInfo> options = new ArrayList<OptionInfo>();
    private static QuestionInfo questionInfo = new QuestionInfo();

    public static QuestionInfo toOption(Question question){
        questionInfo.setId(question.getId());
        questionInfo.setTitle(question.getTitle());
        questionInfo.setAnswer(question.getAnswer());
        options.add(new OptionInfo(question.getOption_A(),"A"));
        options.add(new OptionInfo(question.getOption_B(),"B"));
        options.add(new OptionInfo(question.getOption_C(),"C"));
        options.add(new OptionInfo(question.getOption_D(),"D"));
        questionInfo.setOptionInfos(options);
        return questionInfo;
    }
}
