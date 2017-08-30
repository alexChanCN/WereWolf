package com.github.binarywang.demo.wechat.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by cs on 2017/8/1.
 */
@Entity
public class Teacher implements Serializable{
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String phoneNo;
    private String imgUrl;
    private String profile;

    /*
     * cascade：为级联操作，里面有级联保存，级联删除等，all为所有
     * fetch：加载类型，有lazy和eager二种，
     *   eager为急加载，意为立即加载，在类加载时就加载，lazy为慢加载，第一次调用的时候再加载，由于数据量太大，onetomany一般为lazy
     * mappedBy：这个为ManyToOne中的对象名，这个不要变哦
     * Set<role>：这个类型有两种，一种为list另一种为set
     *
     *
     */
    @OneToMany(cascade= CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="teacher")
    private List<Comment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
