package com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.styleOne;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.luffy.generaldialoglib.R;
import com.luffy.generaldialoglib.base.DialogBaseAdapter;
import com.luffy.generaldialoglib.model.popupWindow.SingleSelectBean;
import com.luffy.generaldialoglib.popupWindow.callback.PopStyleOneExpand;
import com.luffy.generaldialoglib.utils.IconColourUtils;

import java.util.List;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式一-适配器
 */
public class SingleSelectStyleOneAdapter extends DialogBaseAdapter<SingleSelectBean, BaseViewHolder> implements PopStyleOneExpand {

    //文本字体大小
    private int txtSize;
    //文本默认颜色
    private int txtDefaultColor;
    //文本选中颜色
    private int txtSelectedColor;
    //选中图标颜色
    private int selectedIconColor;
    //分割线margin
    private int left;
    private int top;
    private int right;
    private int bottom;

    public SingleSelectStyleOneAdapter(@Nullable List<SingleSelectBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return super.createBaseViewHolder(parent, R.layout.item_single_select_style_one_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, SingleSelectBean item) {
        /*名称*/
        ((TextView) helper.getView(R.id.txt_name)).setText(item.getName());
        if (txtSize != 0) {
            ((TextView) helper.getView(R.id.txt_name)).setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
        }
        /*是否选中*/
        if (selectedIconColor != 0) {
            IconColourUtils.getInstance().setImageViewColor((ImageView) helper.getView(R.id.img_selected), selectedIconColor);
        }
        if (item.isSelected()) {
            helper.getView(R.id.img_selected).setVisibility(View.VISIBLE);
            if (txtSelectedColor != 0) {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, txtSelectedColor));
            } else {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, R.color.dialog_color_6299FF));
            }
        } else {
            helper.getView(R.id.img_selected).setVisibility(View.GONE);
            if (txtDefaultColor != 0) {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, txtDefaultColor));
            } else {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, R.color.dialog_color_3D464D));
            }
        }
        /*分割线*/
        if (getItemPosition(item) == mData.size() - 1) {
            helper.getView(R.id.divider).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.divider).setVisibility(View.VISIBLE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(helper.getView(R.id.divider).getLayoutParams());
            layoutParams.setMargins(left, top, right, bottom);
            helper.getView(R.id.divider).setLayoutParams(layoutParams);
        }
        /*子项点击事件*/
        helper.addOnClickListener(R.id.item_base_layout);
    }

    @Override
    public void setTxtSize(int txtSize) {
        this.txtSize = txtSize;
    }

    @Override
    public void setTxtDefaultColor(int txtDefaultColor) {
        this.txtDefaultColor = txtDefaultColor;
    }

    @Override
    public void setTxtSelectedColor(int txtSelectedColor) {
        this.txtSelectedColor = txtSelectedColor;
    }

    @Override
    public void setSelectedIconColor(int selectedIconColor) {
        this.selectedIconColor = selectedIconColor;
    }

    @Override
    public void setDividerMargin(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
}
