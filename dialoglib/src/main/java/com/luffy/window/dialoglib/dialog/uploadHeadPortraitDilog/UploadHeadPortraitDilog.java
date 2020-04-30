package com.luffy.window.dialoglib.dialog.uploadHeadPortraitDilog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.luffy.dialoglib.R;
import com.luffy.window.dialoglib.dialog.base.BaseDialogBuilder;

/**
 * Created by lvlufei on 2018/7/26
 *
 * @desc 上传头像Dilog
 */
public class UploadHeadPortraitDilog extends BaseDialogBuilder {

    public UploadHeadPortraitDilog(Context mContext) {
        super(mContext);
    }

    @Override
    public int bindView() {
        return R.layout.dialog_upload_head_portrait_layout;
    }

    @Override
    public int gravityType() {
        return Gravity.BOTTOM;
    }

    @Override
    public void init() {
        //点击屏幕不消失
        mDialog.setCanceledOnTouchOutside(false);
        //点击物理返回键不消失
        mDialog.setCancelable(false);
    }

    /**
     * 相机
     *
     * @param listener
     * @return
     */
    public UploadHeadPortraitDilog setCameraButton(final DialogInterface.OnClickListener listener) {
        TextView view = mView.findViewById(R.id.txt_camera);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 相册
     *
     * @param listener
     * @return
     */
    public UploadHeadPortraitDilog setPhotoAlbumButton(final DialogInterface.OnClickListener listener) {
        TextView view = mView.findViewById(R.id.txt_photo_album);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 取消
     *
     * @param listener
     * @return
     */
    public UploadHeadPortraitDilog setCancelButton(final DialogInterface.OnClickListener listener) {
        TextView view = mView.findViewById(R.id.txt_cancel);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

}
