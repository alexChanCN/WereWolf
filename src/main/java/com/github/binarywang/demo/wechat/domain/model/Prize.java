package com.github.binarywang.demo.wechat.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by cs on 2017/8/29.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prize implements Serializable{

    @Id
    @GeneratedValue
    Integer id;
    String prize;
    String name;
}
