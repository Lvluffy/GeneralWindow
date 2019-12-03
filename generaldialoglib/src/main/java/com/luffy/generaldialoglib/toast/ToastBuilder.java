package com.luffy.generaldialoglib.toast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationManagerCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luffy.generaldialoglib.R;
import com.luffy.generaldialoglib.utils.OSUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lvlufei on 2017/1/1
 *
 * @desc Toast工具类
 */
public class ToastBuilder {
    /*长时间*/
    public static final int LENGTH_LONG = 3500;
    /*短时间*/
    public static final int LENGTH_SHORT = 2000;

    /*上下文对象*/
    Context mContext;
    /*Toast对象*/
    Toast mToast;
    /*布局View*/
    View mView;

    /*显示时间~默认短时间*/
    public int showTime = LENGTH_SHORT;
    /*位置比重~默认底部*/
    public int gravity = Gravity.CENTER;

    private Handler mHandler = new Handler();
    private Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        }
    };

    public ToastBuilder(Context mContext) {
        this.mContext = mContext;
        mHandler.removeCallbacks(r);
        if (mToast == null) {
            mToast = new Toast(this.mContext);
        }
        if (mView == null) {
            mView = LayoutInflater.from(this.mContext).inflate(R.layout.toast_layout, null);
        }
    }

    /**
     * 设置标题
     *
     * @param title
     * @return
     */
    public ToastBuilder setTitle(String title) {
        TextView textView = (TextView) mView.findViewById(R.id.txt_toast_title);
        textView.setText(title);
        textView.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置标题
     *
     * @param title
     * @return
     */
    public ToastBuilder setTitle(int title) {
        TextView textView = (TextView) mView.findViewById(R.id.txt_toast_title);
        textView.setText(title);
        textView.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置图片
     *
     * @param bitmap
     * @return
     */
    public ToastBuilder setPicture(Bitmap bitmap) {
        ImageView imageView = (ImageView) mView.findViewById(R.id.img_toast_picture);
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置图片
     *
     * @param resourceID
     * @return
     */
    public ToastBuilder setPicture(int resourceID) {
        ImageView imageView = (ImageView) mView.findViewById(R.id.img_toast_picture);
        imageView.setImageResource(resourceID);
        imageView.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置图片
     *
     * @param drawable
     * @return
     */
    public ToastBuilder setPicture(Drawable drawable) {
        ImageView imageView = (ImageView) mView.findViewById(R.id.img_toast_picture);
        imageView.setImageDrawable(drawable);
        imageView.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置背景
     *
     * @param resource
     * @return
     */
    public ToastBuilder setBackgroundResource(int resource) {
        LinearLayout linearLayout = (LinearLayout) mView.findViewById(R.id.layout_toast);
        linearLayout.setBackgroundResource(resource);
        linearLayout.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置背景
     *
     * @param background
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public ToastBuilder setBackground(Drawable background) {
        LinearLayout linearLayout = (LinearLayout) mView.findViewById(R.id.layout_toast);
        linearLayout.setBackground(background);
        linearLayout.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置背景
     *
     * @param color
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public ToastBuilder setBackgroundColor(int color) {
        LinearLayout linearLayout = (LinearLayout) mView.findViewById(R.id.layout_toast);
        linearLayout.setBackgroundColor(color);
        linearLayout.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置显示时间(自定义)
     *
     * @param showTime
     */
    public ToastBuilder setShowTime(int showTime) {
        this.showTime = showTime;
        return this;
    }

    /**
     * 设置显示时间~长
     */
    public ToastBuilder setShowTimeLong() {
        this.showTime = LENGTH_LONG;
        return this;
    }

    /**
     * 设置显示时间~短
     */
    public ToastBuilder setShowTimeShort() {
        this.showTime = LENGTH_SHORT;
        return this;
    }

    /**
     * 设置位置比重
     *
     * @param gravity
     */
    public ToastBuilder setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * 显示
     *
     * @return
     */
    public ToastBuilder show() {
        mHandler.postDelayed(r, showTime);
        if (gravity == Gravity.CENTER) {
            mToast.setGravity(gravity, 0, 0);
        } else if (gravity == Gravity.BOTTOM) {
            mToast.setGravity(gravity, 0, 200);
        } else {
            mToast.setGravity(gravity, 0, 0);
        }
        mToast.setView(mView);
        // 判断通知是否打开
        if (NotificationManagerCompat.from(mContext).areNotificationsEnabled()) {
            mToast.show();
        } else {
            if (OSUtils.getInstance().getOSType().equals(OSUtils.OSType.Huawei) ||
                    OSUtils.getInstance().getOSType().equals(OSUtils.OSType.Sanxing) ||
                    OSUtils.getInstance().getOSType().equals(OSUtils.OSType.Meizu)) {
                showSystemToast(mToast);
            } else {
                mToast.show();
            }
        }
        return this;
    }

    /**
     * 显示系统Toast（处理部分手机通知权限关闭无法打出Toast；例如：华为、三星、魅族）
     *
     * @param toast
     */
    private void showSystemToast(Toast toast) {
        try {
            Method getServiceMethod = Toast.class.getDeclaredMethod("getService");
            getServiceMethod.setAccessible(true);
            final Object iNotificationManager = getServiceMethod.invoke(null);
            Class iNotificationManagerCls = Class.forName("android.app.INotificationManager");
            Object iNotificationManagerProxy = Proxy.newProxyInstance(toast.getClass().getClassLoader(), new Class[]{iNotificationManagerCls}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 强制使用系统Toast
                    // 华为p20 pro上为enqueueToastEx
                    if ("enqueueToast".equals(method.getName()) || "enqueueToastEx".equals(method.getName())) {
                        args[0] = "android";
                    }
                    return method.invoke(iNotificationManager, args);
                }
            });
            Field sServiceFiled = Toast.class.getDeclaredField("sService");
            sServiceFiled.setAccessible(true);
            sServiceFiled.set(null, iNotificationManagerProxy);
            toast.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}