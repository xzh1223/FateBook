package com.example.zhenghangxia.fatebook.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by zhenghangxia on 17-7-5.
 *
 *  规划实体类
 *
 */

public class PlanBean extends DataSupport {

    // 类型
    private String type;
    // ID
    private int id;
    // 时间
    private String time;
    // 内容
    private String content;
    // 星级
    private float star = 0;
    // 备注
    private String remark;
    // 总结反思
    private String think;

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getThink() {
        return think;
    }

    public void setThink(String think) {
        this.think = think;
    }
}
