package com.luffy.generaldialoglib.popupWindow.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

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
    protected void init(Context context) {
        this.mContext = context;
        if (addLayout() == 0) {
            return;
        }
        this.mView = LayoutInflater.from(mContext).inflate(addLayout(), null);
        /*添加视图*/
        this.setContentView(mView);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        /*设置窗体的宽和高*/
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        /*必须设置BackgroundDrawable后setOutsideTouchable(true)才会有效*/
        this.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
        /*设置允许在外点击消失*/
        this.setOutsideTouchable(false);
        /*初始化控件*/
        initView();
        /*处理事件*/
        handlerEvent();
    }

    @Override
    public void showAsDropDown(View anchor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h;
            if (Build.BRAND.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HONOR")) {
                h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom - 40 + getNavigationBarHeightIfRoom(mContext);
            } else {
                h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            }
            setHeight(h);
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


    /**
     * 获取虚拟按键的高度
     * 1. 全面屏下
     * 1.1 开启全面屏开关-返回0
     * 1.2 关闭全面屏开关-执行非全面屏下处理方式
     * 2. 非全面屏下
     * 2.1 没有虚拟键-返回0
     * 2.1 虚拟键隐藏-返回0
     * 2.2 虚拟键存在且未隐藏-返回虚拟键实际高度
     */
    public static int getNavigationBarHeightIfRoom(Context context) {
        if (navigationGestureEnabled(context)) {
            return 0;
        }
        return getCurrentNavigationBarHeight(((Activity) context));
    }

    /**
     * 全面屏（是否开启全面屏开关 0 关闭  1 开启）
     *
     * @param context
     * @return
     */
    public static boolean navigationGestureEnabled(Context context) {
        int val = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val = Settings.Global.getInt(context.getContentResolver(), getDeviceInfo(), 0);
        }
        return val != 0;
    }


    /**
     * 获取设备信息（目前支持几大主流的全面屏手机，亲测华为、小米、oppo、魅族、vivo都可以）
     *
     * @return
     */
    public static String getDeviceInfo() {
        String brand = Build.BRAND;
        if (TextUtils.isEmpty(brand)) return "navigationbar_is_min";

        if (brand.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        } else if (brand.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        } else if (brand.equalsIgnoreCase("VIVO")) {
            return "navigation_gesture_on";
        } else if (brand.equalsIgnoreCase("OPPO")) {
            return "navigation_gesture_on";
        } else {
            return "navigationbar_is_min";
        }
    }

    /**
     * 非全面屏下 虚拟键实际高度(隐藏后高度为0)
     *
     * @param activity
     * @return
     */
    public static int getCurrentNavigationBarHeight(Activity activity) {
        if (isNavigationBarShown(activity)) {
            return getNavigationBarHeight(activity);
        } else {
            return 0;
        }
    }

    /**
     * 非全面屏下 虚拟按键是否打开
     *
     * @param activity
     * @return
     */
    public static boolean isNavigationBarShown(Activity activity) {
        //虚拟键的view,为空或者不可见时是隐藏状态
        View view = activity.findViewById(android.R.id.navigationBarBackground);
        if (view == null) {
            return false;
        }
        int visible = view.getVisibility();
        if (visible == View.GONE || visible == View.INVISIBLE) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 非全面屏下 虚拟键高度(无论是否隐藏)
     *
     * @param context
     * @return
     */
    public static int getNavigationBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
