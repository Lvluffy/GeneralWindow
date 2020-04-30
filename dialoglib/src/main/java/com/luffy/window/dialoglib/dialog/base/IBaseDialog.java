package com.luffy.window.dialoglib.dialog.base;

/**
 * Created by lvlufei on 2019/3/26
 *
 * @desc
 */
public interface IBaseDialog {

    /**
     * 绑定View
     *
     * @return
     */
    int bindView();

    /**
     * 初始化
     */
    void init();

    /**
     * 添加动画
     *
     * @return
     */
    int addAnimation();

    /**
     * 设置位置
     *
     * @return
     */
    int gravityType();
}
