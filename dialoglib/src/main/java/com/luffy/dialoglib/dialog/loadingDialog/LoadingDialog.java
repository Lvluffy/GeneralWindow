package com.luffy.dialoglib.dialog.loadingDialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.luffy.dialoglib.R;
import com.luffy.dialoglib.dialog.base.BaseDialogBuilder;

/**
 * Created by lvlufei on 2018/7/26
 *
 * @desc 加载Dialog
 */
public class LoadingDialog extends BaseDialogBuilder {

    public LoadingDialog(Context mContext) {
        super(mContext);
    }

    @Override
    public int bindView() {
        return R.layout.dialog_loading_layout;
    }

    @Override
    public void init() {
        //点击屏幕不消失
        mDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public int addAnimation() {
        return R.style.dialog_push_enter_push_exit_anim;
    }

    /**
     * 设置文字
     *
     * @param mString
     * @return
     */
    public LoadingDialog setText(String mString) {
        TextView mTextView = mView.findViewById(R.id.base_loading_txt);
        mTextView.setVisibility(View.VISIBLE);
        mTextView.setText(mString);
        return this;
    }
}