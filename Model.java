package com.example.ankita.testapp;

/**
 * Created by Ankita on 4/16/2018.
 */

public class Model {
    private String name;

    public Model(String name, String tel, String sex) {
        this.name = name;
        this.tel = tel;
        this.sex = sex;
    }

    private String tel;
    private String sex;



    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
