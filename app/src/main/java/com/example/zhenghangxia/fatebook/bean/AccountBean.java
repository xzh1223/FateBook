package com.example.zhenghangxia.fatebook.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by zhenghangxia on 17-7-12.
 *
 *  记账实体类
 *
 */

public class AccountBean extends DataSupport{

    // ID
    private int id;
    // 年
    private int year;
    // 月
    private int month;
    // 日
    private int day;
    // 类型(支出/收入)
    private String type;
    // 内容(购物/早餐/通信)
    private String typeContent;
    // 数额
    private String number;
    // 图标
    private int imgSrc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

}
