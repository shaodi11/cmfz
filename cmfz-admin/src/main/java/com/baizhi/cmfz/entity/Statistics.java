package com.baizhi.cmfz.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by 邵迪 on 2018/7/9.
 */
@Component
public class Statistics implements Serializable {

    private String name;
    private Integer value;

    public Statistics() {
    }

    public Statistics(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
