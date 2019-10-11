package com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.styleTwo;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.luffy.generaldialoglib.R;
import com.luffy.generaldialoglib.base.DialogBaseAdapter;
import com.luffy.generaldialoglib.model.popupWindow.SingleSelectBean;
import com.luffy.generaldialoglib.popupWindow.callback.PopStyleTwoExpand;

import java.util.List;

/**
 * Created by lvlufei on 2018/8/2
 *
 * @desc 单选样式二-适配器
 */
public class SingleSelectStyleTwoAdapter extends DialogBaseAdapter<SingleSelectBean, BaseViewHolder> implements PopStyleTwoExpand {

    //文本字体大小
    private int txtSize;
    //文本默认颜色
    private int txtDefaultColor;
    //文本选中颜色
    private int txtSelectedColor;
    //选中背景
    private int selectedBg;

    public SingleSelectStyleTwoAdapter(@Nullable List<SingleSelectBean> data) {
        super(data);
    }

    @Override
    protected BaseViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return super.createBaseViewHolder(parent, R.layout.item_single_select_style_two_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, SingleSelectBean item) {
        /*名称*/
        ((TextView) helper.getView(R.id.txt_name)).setText(item.getName());
        if (txtSize != 0) {
            ((TextView) helper.getView(R.id.txt_name)).setTextSize(TypedValue.COMPLEX_UNIT_SP, txtSize);
        }
        /*是否选中*/
        if (item.isSelected()) {
            /*选中文本颜色*/
            if (txtSelectedColor != 0) {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, txtSelectedColor));
            } else {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, R.color.dialog_color_6299FF));
            }
            /*选中背景*/
            if (selectedBg != 0) {
                helper.getView(R.id.txt_name).setBackgroundResource(selectedBg);
            } else {
                helper.getView(R.id.txt_name).setBackgroundResource(R.drawable.popup_drawable_normal_radius_ture_stroke_true_select_true_default_selector);
            }
        } else {
            /*默认文本颜色*/
            if (txtDefaultColor != 0) {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, txtDefaultColor));
            } else {
                ((TextView) helper.getView(R.id.txt_name)).setTextColor(ContextCompat.getColor(mContext, R.color.dialog_color_3D464D));
            }
            /*默认背景*/
            helper.getView(R.id.txt_name).setBackgroundResource(R.drawable.popup_drawable_normal_radius_ture_stroke_true_select_false_default_selector);
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
    public void setSelectedBg(int selectedBg) {
        this.selectedBg = selectedBg;
    }
}
