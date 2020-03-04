package com.luffy.popupwindowlib.popupWindow.listPopupWindow.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by lvlufei on 2018/1/1
 *
 * @desc 公用的Adapter
 * 包括：来自于BaseQuickAdapter的再次封装
 */
public abstract class PopBaseAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {

    public PopBaseAdapter(@LayoutRes int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public PopBaseAdapter(@Nullable List<T> data) {
        super(data);
    }

    public PopBaseAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected K createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return super.createBaseViewHolder(parent, layoutResId);
    }

    @Override
    protected K createBaseViewHolder(View view) {
        return super.createBaseViewHolder(view);
    }

    @Override
    protected K onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateDefViewHolder(parent, viewType);
    }

    public int getItemPosition(T item) {
        return item != null && this.mData != null && !this.mData.isEmpty() ? this.mData.indexOf(item) : -1;
    }
}
