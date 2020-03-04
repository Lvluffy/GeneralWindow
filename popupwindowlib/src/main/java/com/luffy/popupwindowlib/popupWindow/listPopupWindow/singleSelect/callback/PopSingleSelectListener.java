package com.luffy.popupwindowlib.popupWindow.listPopupWindow.singleSelect.callback;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式一-回调监听
 */
public interface PopSingleSelectListener {
    /**
     * 子项点击
     *
     * @param adapter
     * @param view
     * @param position
     */
    void onItemChildClick(BaseQuickAdapter adapter, View view, int position);
}
