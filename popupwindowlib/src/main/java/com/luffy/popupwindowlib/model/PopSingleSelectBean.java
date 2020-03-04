package com.luffy.popupwindowlib.model;

import java.io.Serializable;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式一-实体类
 */
public class PopSingleSelectBean implements Serializable {
    private boolean isSelected;
    private String id;
    private String name;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
