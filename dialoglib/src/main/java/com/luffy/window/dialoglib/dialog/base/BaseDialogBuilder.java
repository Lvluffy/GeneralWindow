package com.luffy.window.dialoglib.dialog.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.luffy.dialoglib.R;


/**
 * Created by lvlufei on 2019/3/26
 *
 * @desc 公共的-Dialog
 */
public abstract class BaseDialogBuilder {

    public BaseDialog mDialog;
    public Context mContext;
    public View mView;

    /*点击是否自动消失*/
    private boolean autoDismiss = true;

    public boolean isAutoDismiss() {
        return autoDismiss;
    }

    public BaseDialogBuilder setAutoDismiss(boolean autoDismiss) {
        this.autoDismiss = autoDismiss;
        return this;
    }

    public BaseDialogBuilder(Context context) {
        mContext = context;
        mDialog = new BaseDialog(context);
        mView = LayoutInflater.from(context).inflate(bindView(), null);
        init();
    }

    /**
     * 绑定View
     *
     * @return
     */
    public abstract int bindView();

    /**
     * 初始化
     */
    public abstract void init();

    /**
     * 添加动画
     *
     * @return
     */
    public int addAnimation() {
        //默认：淡入淡出动画
        return R.style.dialog_push_enter_push_exit_anim;
    }

    /**
     * 设置位置
     *
     * @return
     */
    public int gravityType() {
        // 默认：居中
        return Gravity.CENTER;
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

    public BaseDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        mDialog.setOnCancelListener(onCancelListener);
        return this;
    }

    /**
     * 获取显示的状态
     */
    public boolean isShowing() {
        return mDialog.isShowing();
    }

    /**
     * 显示
     *
     * @return
     */
    public void show() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }

    /**
     * 关闭对话框
     */
    public void dismiss() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    /**
     * Created by lvlufei on 2019/3/26
     *
     * @descr BaseDialog
     */
    public class BaseDialog extends Dialog {

        private boolean isFullScreen = false;

        boolean isFullScreen() {
            return isFullScreen;
        }

        public void setFullScreen(boolean fullScreen) {
            isFullScreen = fullScreen;
        }

        private BaseDialog(Context context) {
            super(context);
        }

        private BaseDialog(Context context, int style) {
            super(context, style);
        }

        public void show() {
            try {
                if (getContext() instanceof Activity) {
                    Activity activity = (Activity) getContext();
                    if (activity.isFinishing()) {
                        return;
                    }
                }
                super.show();
                //添加View
                getWindow().setContentView(mView);
                //设置属性
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                if (isFullScreen()) {
                    lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                } else {
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                }
                getWindow().setAttributes(lp);
                //设置位置
                getWindow().setGravity(gravityType());
                getWindow().setBackgroundDrawable(null);
                //设置动画
                getWindow().setWindowAnimations(addAnimation());
                //Android AlertDialog去掉系统黑色背景
                getWindow().setBackgroundDrawableResource(Color.TRANSPARENT);
                //不加这句，软键盘弹不出来
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
