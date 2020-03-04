package com.luffy.dialoglib.model;

import java.io.Serializable;

/**
 * Created by lvlufei on 2018/10/9
 *
 * @desc Dialog选择-实体类
 */
public class DialogSelectBean implements Serializable {
    private boolean isSelected;
    private String name;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
