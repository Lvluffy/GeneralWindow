package com.luffy.generaldialoglib.model.base;

import java.io.Serializable;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 公用的实体类
 */
public class DialogBaseBean implements Serializable {
    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
