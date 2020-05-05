package com.luffy.window.dialoglib.dialog.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.luffy.dialoglib.R;


/**
 * Created by lvlufei on 2019/3/26
 *
 * @desc 公共的-Dialog
 */
public abstract class BaseDialogBuilder implements IBaseDialog {

    public final BaseAlertDialog mDialog;
    public final Context mContext;
    public final View mView;

    /*点击是否自动消失*/
    private boolean autoDismiss = true;

    public boolean isAutoDismiss() {
        return autoDismiss;
    }

    public BaseDialogBuilder setAutoDismiss(boolean autoDismiss) {
        this.autoDismiss = autoDismiss;
        return this;
    }

    public BaseDialogBuilder(Context mContext) {
        this.mContext = mContext;
        mDialog = new BaseAlertDialog(mContext);
        mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    mDialog.dismiss();
                }
                return false;
            }
        });
        mView = LayoutInflater.from(mContext).inflate(bindView(), null);
        init();
    }

    @Override
    public int addAnimation() {
        //默认：淡入淡出动画
        return R.style.dialog_push_enter_push_exit_anim;
    }

    @Override
    public int gravityType() {
        // 默认：居中
        return Gravity.CENTER;
    }

    /**
     * 内部类
     */
    public class BaseAlertDialog extends AlertDialog {

        private boolean isFullScreen = false;

        boolean isFullScreen() {
            return isFullScreen;
        }

        public void setFullScreen(boolean fullScreen) {
            isFullScreen = fullScreen;
        }

        private BaseAlertDialog(Context context) {
            super(context);
        }

        private BaseAlertDialog(Context context, int style) {
            super(context, style);
        }

        /**
         * 显示到中部
         */
        public void show() {
            try {
                if (getContext() instanceof Activity) {
                    if (((Activity) getContext()).isFinishing()) {
                        return;
                    }
                }
                super.show();
                getWindow().setContentView(mView);
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                if (isFullScreen()) {
                    lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                } else {
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                }
                getWindow().setAttributes(lp);
                getWindow().setGravity(gravityType());
                getWindow().setBackgroundDrawable(null);
                //设置动画
                getWindow().setWindowAnimations(addAnimation());
                //Android AlertDialog去掉系统黑色背景
                getWindow().setBackgroundDrawableResource(R.color.dialog_transparent);
                //不加这句，软键盘弹不出来
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 设置能否点击物理返回键消失
     *
     * @param cancelable
     * @return
     */
    public BaseDialogBuilder setCancelable(boolean cancelable) {
        mDialog.setCancelable(cancelable);
        return this;
    }

    /**
     * 设置能否点击外围消失
     */
    public BaseDialogBuilder setCanceledOnTouchOutside(boolean b) {
        mDialog.setCanceledOnTouchOutside(b);
        return this;
    }

    /**
     * 获取显示的状态
     */
    public boolean isShowing() {
        return mDialog.isShowing();
    }

    public BaseDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        mDialog.setOnCancelListener(onCancelListener);
        return this;
    }

    /**
     * 显示
     *
     * @return
     */
    public BaseDialogBuilder show() {
        mDialog.show();
        return this;
    }

    /**
     * 关闭对话框
     */
    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}
