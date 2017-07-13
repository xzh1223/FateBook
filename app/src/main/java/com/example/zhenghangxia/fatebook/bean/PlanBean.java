package com.example.zhenghangxia.fatebook.bean;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *  规划实体类
 *
 */

public class PlanBean {

    // 类型
    private int type;
    // ID
    private int id;
    // 时间
    private String time;
    // 内容
    private String content;
    // 星级
    private float star;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
