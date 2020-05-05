package com.luffy.window.popupwindowlib.popupWindow.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.luffy.window.popupwindowlib.utils.DeviceBrandUtils;

/**
 * Created by lvlufei on 2017/1/1
 *
 * @desc 公用的-PopupWindow
 */
public abstract class BasePopupWindow extends PopupWindow implements View.OnClickListener {
    public Context mContext;
    public View mView;

    public BasePopupWindow(Context context) {
        super(context);
        init(context);
    }

    public BasePopupWindow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BasePopupWindow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        this.mContext = context;
        if (addLayout() == 0) {
            return;
        }
        this.mView = LayoutInflater.from(mContext).inflate(addLayout(), null);
        /*添加视图*/
        this.setContentView(mView);
        /*设置窗体的宽和高*/
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        /*必须设置BackgroundDrawable后setOutsideTouchable(true)才会有效*/
        this.setBackgroundDrawable(new BitmapDrawable());
        /*设置允许在外点击消失*/
        this.setOutsideTouchable(false);
        /*监听系统返回键*/
        this.setFocusable(true);
        this.mView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
                    dismiss();
                }
                return false;
            }
        });
        /*初始化控件*/
        initView();
        /*处理事件*/
        handlerEvent();
    }

    @Override
    public void showAsDropDown(View anchor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (DeviceBrandUtils.getInstance().getOSType() == DeviceBrandUtils.OSType.Huawei) {
                int[] a = new int[2];
                anchor.getLocationInWindow(a);
                showAtLocation(((Activity) mContext).getWindow().getDecorView(), Gravity.NO_GRAVITY, 0, a[1] + anchor.getHeight());
            } else {
                Rect rect = new Rect();
                anchor.getGlobalVisibleRect(rect);
                int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                setHeight(h);
            }
        }
        super.showAsDropDown(anchor);
    }

    /**
     * 添加布局文件
     *
     * @return
     */
    protected abstract int addLayout();

    /**
     * 初始化界面
     */
    protected abstract void initView();

    /**
     * 处理事件
     */
    protected abstract void handlerEvent();

}
