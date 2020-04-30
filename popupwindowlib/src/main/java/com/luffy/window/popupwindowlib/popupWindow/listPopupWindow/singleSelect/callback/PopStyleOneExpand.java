package com.luffy.window.popupwindowlib.popupWindow.listPopupWindow.singleSelect.callback;

/**
 * Created by lvlufei on 2019/12/13
 *
 * @name
 * @desc
 */
public interface PopStyleOneExpand {
    /**
     * 设置-文本字体大小
     *
     * @param txtSize
     */
    void setTxtSize(int txtSize);

    /**
     * 设置-文本默认颜色
     *
     * @param txtDefaultColor
     */
    void setTxtDefaultColor(int txtDefaultColor);

    /**
     * 设置-文本选中颜色
     *
     * @param txtSelectedColor
     */
    void setTxtSelectedColor(int txtSelectedColor);

    /**
     * 设置-选中图标颜色
     *
     * @param selectedIconColor
     */
    void setSelectedIconColor(int selectedIconColor);

    /**
     * 设置-分割线margin
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    void setDividerMargin(int left, int top, int right, int bottom);
}
