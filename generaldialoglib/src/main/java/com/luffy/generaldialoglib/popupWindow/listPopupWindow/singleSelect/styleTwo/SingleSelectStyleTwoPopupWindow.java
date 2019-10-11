package com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.styleTwo;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luffy.generaldialoglib.R;
import com.luffy.generaldialoglib.callback.SingleSelectListener;
import com.luffy.generaldialoglib.model.popupWindow.SingleSelectBean;
import com.luffy.generaldialoglib.popupWindow.base.BasePopupWindow;
import com.luffy.generaldialoglib.popupWindow.callback.PopStyleTwoExpand;
import com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemDecoration;
import com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemNum;

import java.util.List;

import static com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemNum.ItemFive;
import static com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemNum.ItemFour;
import static com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemNum.ItemThree;
import static com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemNum.ItemTwo;


/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式二
 */
public class SingleSelectStyleTwoPopupWindow extends BasePopupWindow implements PopStyleTwoExpand {

    /*根布局*/
    public LinearLayout mLinearLayout;
    /*RecyclerView*/
    public RecyclerView mRecyclerView;
    /*适配器*/
    public SingleSelectStyleTwoAdapter adapter;
    /*回调监听*/
    public SingleSelectListener singleSelectListener;
    /*数量类型*/
    public ItemNum itemNum;

    public SingleSelectStyleTwoPopupWindow(Context context, ItemNum itemNum) {
        super(context);
        this.itemNum = itemNum;
        initAdapter();
        initRecycleView();
    }

    @Override
    protected int addLayout() {
        return R.layout.single_recycleview_layout;
    }

    @Override
    protected void initView() {
        mLinearLayout = mView.findViewById(R.id.ll_layout);
        mRecyclerView = mView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void handlerEvent() {
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
            adapter = new SingleSelectStyleTwoAdapter(null);
        }
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                dismiss();
                if (singleSelectListener != null) {
                    singleSelectListener.onItemChildClick(adapter, view, position);
                }
            }
        });
    }

    public void initRecycleView() {
        switch (itemNum) {
            case ItemOne:
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
                break;
            case ItemTwo:
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                mRecyclerView.addItemDecoration(new ItemDecoration(ItemTwo, mContext.getResources().getDimensionPixelSize(R.dimen.x10)));
                break;
            case ItemThree:
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                mRecyclerView.addItemDecoration(new ItemDecoration(ItemThree, mContext.getResources().getDimensionPixelSize(R.dimen.x10)));
                break;
            case ItemFour:
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
                mRecyclerView.addItemDecoration(new ItemDecoration(ItemFour, mContext.getResources().getDimensionPixelSize(R.dimen.x10)));
                break;
            case ItemFive:
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 5));
                mRecyclerView.addItemDecoration(new ItemDecoration(ItemFive, mContext.getResources().getDimensionPixelSize(R.dimen.x10)));
                break;
            default:
                mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
                mRecyclerView.addItemDecoration(new ItemDecoration(ItemTwo, mContext.getResources().getDimensionPixelSize(R.dimen.x10)));
                break;
        }
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    public void setData(List<SingleSelectBean> data) {
        if (adapter != null) {
            adapter.setNewData(data);
        }
    }

    public void setSingleSelectListener(SingleSelectListener singleSelectListener) {
        this.singleSelectListener = singleSelectListener;
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
    public void setSelectedBg(int selectedBg) {
        adapter.setSelectedBg(selectedBg);
    }
}
