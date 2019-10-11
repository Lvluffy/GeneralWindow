package com.luffy.generaldialoglib.model.popupWindow;


import com.luffy.generaldialoglib.model.base.DialogBaseBean;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式一-实体类
 */
public class SingleSelectBean extends DialogBaseBean {
    private String id;
    private String name;

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
