package com.lx.test.model.mybatis;

import java.io.Serializable;

public class User implements Serializable{
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private Float wage;


    public User() {
    }

    public User(Integer id, String name, Integer age, Integer sex, Float wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.wage = wage;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Float getWage() {
        return wage;
    }

    public void setWage(Float wage) {
        this.wage = wage;
    }
}