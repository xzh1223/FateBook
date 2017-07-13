package com.example.zhenghangxia.fatebook.bean;

/**
 * Created by zhenghangxia on 17-7-12.
 *
 *  新闻实体类
 *
 */

public class NewsBean {

    // ID
    private int id;
    // 标题
    private String title;
    // 内容
    private String content;
    // 图片
    private int imgSrc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }
}
