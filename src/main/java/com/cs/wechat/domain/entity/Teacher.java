package com.cs.wechat.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by cs on 2017/9/1.
 */
@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String phoneNo;
    private String imgUrl;
    private String profile;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)      //级联删除
    @JsonIgnore     //防止循环获取不到数据
    private List<Comment> comments;
}
