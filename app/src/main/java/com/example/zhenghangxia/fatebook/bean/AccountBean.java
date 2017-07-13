package com.example.zhenghangxia.fatebook.bean;

/**
 * Created by zhenghangxia on 17-7-12.
 *
 *  记账实体类
 *
 */

public class AccountBean {

    // ID
    private int id;
    // 类型代号
    private int type;
    // 类型
    private String typeContent;
    // 数额
    private double number;
    // 图标
    private int imgSrc;
    // 时间
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
