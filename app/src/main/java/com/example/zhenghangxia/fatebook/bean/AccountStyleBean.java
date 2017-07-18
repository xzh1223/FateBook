package com.example.zhenghangxia.fatebook.bean;

/**
 * Created by zhenghangxia on 17-7-18.
 */

public class AccountStyleBean {

    private int styleId;
    private String styleName;

    public AccountStyleBean(int styleId, String styleName) {
        this.styleId = styleId;
        this.styleName = styleName;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
}
