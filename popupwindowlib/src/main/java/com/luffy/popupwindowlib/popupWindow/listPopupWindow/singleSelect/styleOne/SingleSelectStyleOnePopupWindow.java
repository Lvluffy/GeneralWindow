package com.luffy.popupwindowlib.popupWindow.listPopupWindow.singleSelect.styleOne;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luffy.popupwindowlib.R;
import com.luffy.popupwindowlib.model.PopSingleSelectBean;
import com.luffy.popupwindowlib.popupWindow.base.BasePopupWindow;
import com.luffy.popupwindowlib.popupWindow.listPopupWindow.singleSelect.callback.PopSingleSelectListener;
import com.luffy.popupwindowlib.popupWindow.listPopupWindow.singleSelect.callback.PopStyleOneExpand;

import java.util.List;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式一
 */
public class SingleSelectStyleOnePopupWindow extends BasePopupWindow implements PopStyleOneExpand {

    /*根布局*/
    public LinearLayout mLinearLayout;
    /*RecyclerView*/
    public RecyclerView mRecyclerView;
    /*适配器*/
    public SingleSelectStyleOneAdapter adapter;
    /*回调监听*/
    public PopSingleSelectListener popSingleSelectListener;

    public SingleSelectStyleOnePopupWindow(Context context) {
        super(context);
    }

    @Override
    protected int addLayout() {
        return R.layout.single_recycleview_layout;
    }

    @Override
    protected void initView() {
        mRecyclerView = mView.findViewById(R.id.recyclerView);
        initAdapter();
        initRecycleView();
    }

    @Override
    protected void handlerEvent() {
        mLinearLayout = mView.findViewById(R.id.ll_layout);
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    public void initAdapter() {
        if (adapter == null) {
            adapter = new SingleSelectStyleOneAdapter(null);
        }
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                dismiss();
                if (popSingleSelectListener != null) {
                    popSingleSelectListener.onItemChildClick(adapter, view, position);
                }
            }
        });
    }

    public void initRecycleView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    public void setData(List<PopSingleSelectBean> data) {
        if (adapter != null) {
            adapter.setNewData(data);
        }
    }

    public void setPopSingleSelectListener(PopSingleSelectListener popSingleSelectListener) {
        this.popSingleSelectListener = popSingleSelectListener;
    }

    public void setRecyclerViewHeight(int height) {
        mRecyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height));
    }

    @Override
    public void setTxtSize(int txtSize) {
        adapter.setTxtSize(txtSize);
    }

    @Override
    public void setTxtDefaultColor(int txtDefaultColor) {
        adapter.setTxtDefaultColor(txtDefaultColor);
    }

    @Override
    public void setTxtSelectedColor(int txtSelectedColor) {
        adapter.setTxtSelectedColor(txtSelectedColor);
    }

    @Override
    public void setSelectedIconColor(int selectedIconColor) {
        adapter.setSelectedIconColor(selectedIconColor);
    }

    @Override
    public void setDividerMargin(int left, int top, int right, int bottom) {
        adapter.setDividerMargin(left, top, right, bottom);
    }
}
