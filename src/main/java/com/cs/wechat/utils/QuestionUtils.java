package com.cs.wechat.utils;

import com.cs.wechat.pojo.vo.OptionInfo;
import com.cs.wechat.pojo.vo.QuestionInfo;
import com.cs.wechat.domain.entity.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cs on 2017/8/25.
 */
public class QuestionUtils {

    public static QuestionInfo toOption(Question question){
        List<OptionInfo> options = new ArrayList<OptionInfo>();
        QuestionInfo questionInfo = new QuestionInfo();
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
