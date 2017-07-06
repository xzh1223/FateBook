package com.example.zhenghangxia.fatebook.bean;

/**
 * Created by zhenghangxia on 17-7-5.
 */

public class PlanBean {

    private int type;
    private int id;
    private String time;
    private String content;
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
