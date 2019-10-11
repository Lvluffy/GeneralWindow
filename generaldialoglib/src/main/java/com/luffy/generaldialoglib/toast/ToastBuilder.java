package com.luffy.generaldialoglib.toast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.luffy.generaldialoglib.R;

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
        mToast.show();
        return this;
    }
}