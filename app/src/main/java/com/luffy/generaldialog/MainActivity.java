package com.luffy.generaldialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luffy.window.dialoglib.dialog.commonDialog.DialogBuilder;
import com.luffy.window.dialoglib.dialog.loadingDialog.LoadingDialog;
import com.luffy.window.dialoglib.dialog.uploadHeadPortraitDilog.UploadHeadPortraitDilog;
import com.luffy.window.popupwindowlib.model.PopSingleSelectBean;
import com.luffy.window.popupwindowlib.popupWindow.listPopupWindow.singleSelect.callback.PopSingleSelectListener;
import com.luffy.window.popupwindowlib.popupWindow.listPopupWindow.singleSelect.item.PopItemNum;
import com.luffy.window.popupwindowlib.popupWindow.listPopupWindow.singleSelect.styleOne.SingleSelectStyleOnePopupWindow;
import com.luffy.window.popupwindowlib.popupWindow.listPopupWindow.singleSelect.styleTwo.SingleSelectStyleTwoPopupWindow;
import com.luffy.window.toastlib.ToastBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_toast)
    TextView tvToast;

    SingleSelectStyleOnePopupWindow singleSelectStyleOnePopupWindow;
    SingleSelectStyleTwoPopupWindow singleSelectStyleTwoPopupWindow;
    String[] strings = new String[]{"足球", "排球", "篮球", "羽毛球", "乒乓球", "手球", "高尔夫球", "赛跑"};
    List<PopSingleSelectBean> popSingleSelectBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        for (int i = 0; i < strings.length; i++) {
            PopSingleSelectBean popSingleSelectBean = new PopSingleSelectBean();
            popSingleSelectBean.setName(strings[i]);
            if (i == 0) {
                popSingleSelectBean.setSelected(true);
            } else {
                popSingleSelectBean.setSelected(false);
            }
            popSingleSelectBeanList.add(popSingleSelectBean);
        }
    }

    @OnClick({R.id.tv_toast,
            R.id.tv_dialog,
            R.id.tv_loading_dialog,
            R.id.tv_upload_dialog,
            R.id.tv_popupWindowCheckListOne,
            R.id.tv_popupWindowCheckListTwo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_toast:
                new ToastBuilder(MainActivity.this).setTitle("MainActivity").setPicture(R.drawable.toast_test_icon).show();
                break;
            case R.id.tv_dialog:
                new DialogBuilder(MainActivity.this)
                        .setTitle("提示")
                        .setTitleGravity(Gravity.CENTER)
                        .setContent("我是内容")
                        .setContentGravity(Gravity.CENTER)
                        .setContentLineSpacing(getResources().getDimension(R.dimen.y5))
                        .setDivider(true)
                        .setSimpleCancelButtonBG(R.drawable.dialog_drawable_normal_btn_left_selector, R.color.color_666666)
                        .setSimpleCancelButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        })
                        .setSimpleConfirmButtonBG(R.drawable.dialog_drawable_normal_btn_right_selector, R.color.colorPrimary)
                        .setSimpleConfirmButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();
                break;
            case R.id.tv_loading_dialog:
                new LoadingDialog(MainActivity.this).show();
                break;
            case R.id.tv_upload_dialog:
                new UploadHeadPortraitDilog(MainActivity.this)
                        .setCameraButton(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPhotoAlbumButton(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setCancelButton(new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                break;
            case R.id.tv_popupWindowCheckListOne:
                if (singleSelectStyleOnePopupWindow == null) {
                    singleSelectStyleOnePopupWindow = new SingleSelectStyleOnePopupWindow(MainActivity.this);
                    singleSelectStyleOnePopupWindow.setRecyclerViewHeight(500);
                    singleSelectStyleOnePopupWindow.setTxtSize(16);
                    singleSelectStyleOnePopupWindow.setTxtDefaultColor(R.color.color_3D464D);
                    singleSelectStyleOnePopupWindow.setTxtSelectedColor(R.color.color_FF0000);
                    singleSelectStyleOnePopupWindow.setSelectedIconColor(R.color.color_FF0000);
                    singleSelectStyleOnePopupWindow.setDividerMargin(dp2px(this, 15), 0, 0, 0);
                    singleSelectStyleOnePopupWindow.setPopSingleSelectListener(new PopSingleSelectListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            for (int i = 0; i < popSingleSelectBeanList.size(); i++) {
                                if (i == position) {
                                    popSingleSelectBeanList.get(i).setSelected(true);
                                } else {
                                    popSingleSelectBeanList.get(i).setSelected(false);
                                }
                            }
                            new ToastBuilder(MainActivity.this).setTitle(popSingleSelectBeanList.get(position).getName()).show();
                        }
                    });
                }
                if (singleSelectStyleOnePopupWindow.isShowing()) {
                    singleSelectStyleOnePopupWindow.dismiss();
                } else {
                    singleSelectStyleOnePopupWindow.setData(popSingleSelectBeanList);
                    singleSelectStyleOnePopupWindow.showAsDropDown(tvToast);
                }
                break;
            case R.id.tv_popupWindowCheckListTwo:
                if (singleSelectStyleTwoPopupWindow == null) {
                    singleSelectStyleTwoPopupWindow = new SingleSelectStyleTwoPopupWindow(MainActivity.this, PopItemNum.ItemThree);
                    singleSelectStyleTwoPopupWindow.setTxtSize(16);
                    singleSelectStyleTwoPopupWindow.setTxtDefaultColor(R.color.pop_color_3D464D);
                    singleSelectStyleTwoPopupWindow.setTxtSelectedColor(R.color.color_FF0000);
                    singleSelectStyleTwoPopupWindow.setSelectedBg(R.drawable.popup_drawable_normal_radius_ture_stroke_true_select_true_red_selector);
                    singleSelectStyleTwoPopupWindow.setPopSingleSelectListener(new PopSingleSelectListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            for (int i = 0; i < popSingleSelectBeanList.size(); i++) {
                                if (i == position) {
                                    popSingleSelectBeanList.get(i).setSelected(true);
                                } else {
                                    popSingleSelectBeanList.get(i).setSelected(false);
                                }
                            }
                            new ToastBuilder(MainActivity.this).setTitle(popSingleSelectBeanList.get(position).getName()).show();
                        }
                    });
                }
                if (singleSelectStyleTwoPopupWindow.isShowing()) {
                    singleSelectStyleTwoPopupWindow.dismiss();
                } else {
                    singleSelectStyleTwoPopupWindow.setData(popSingleSelectBeanList);
                    singleSelectStyleTwoPopupWindow.showAsDropDown(tvToast);
                }
                break;
        }
    }

    /**
     * dp转px
     *
     * @param context
     * @param dpVal
     * @return
     */
    public int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpVal,
                context.getResources().getDisplayMetrics());
    }
}
