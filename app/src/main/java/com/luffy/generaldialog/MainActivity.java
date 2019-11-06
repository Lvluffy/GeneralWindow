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
import com.luffy.generaldialoglib.callback.SingleSelectListener;
import com.luffy.generaldialoglib.dialog.commonDialog.DialogBuilder;
import com.luffy.generaldialoglib.dialog.loadingDialog.LoadingDialog;
import com.luffy.generaldialoglib.dialog.uploadHeadPortraitDilog.UploadHeadPortraitDilog;
import com.luffy.generaldialoglib.model.popupWindow.SingleSelectBean;
import com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item.ItemNum;
import com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.styleOne.SingleSelectStyleOnePopupWindow;
import com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.styleTwo.SingleSelectStyleTwoPopupWindow;
import com.luffy.generaldialoglib.toast.ToastBuilder;

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
    List<SingleSelectBean> singleSelectBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);
        for (int i = 0; i < strings.length; i++) {
            SingleSelectBean singleSelectBean = new SingleSelectBean();
            singleSelectBean.setName(strings[i]);
            if (i == 0) {
                singleSelectBean.setSelected(true);
            } else {
                singleSelectBean.setSelected(false);
            }
            singleSelectBeanList.add(singleSelectBean);
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
                new ToastBuilder(MainActivity.this).setTitle("MainActivity").setPicture(R.drawable.dialog_select_yes).show();
                break;
            case R.id.tv_dialog:
                new DialogBuilder(MainActivity.this)
                        .setTitle("提示")
                        .setTitleGravity(Gravity.CENTER)
                        .setContent("我是内容")
                        .setContentGravity(Gravity.CENTER)
                        .setContentLineSpacing(getResources().getDimension(R.dimen.y5))
                        .setDivider(true)
                        .setSimpleCancelButtonBG(R.drawable.dialog_drawable_normal_btn_left_selector, R.color.dialog_color_666666)
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
                    singleSelectStyleOnePopupWindow.setTxtDefaultColor(R.color.dialog_color_3D464D);
                    singleSelectStyleOnePopupWindow.setTxtSelectedColor(R.color.dialog_red);
                    singleSelectStyleOnePopupWindow.setSelectedIconColor(R.color.dialog_red);
                    singleSelectStyleOnePopupWindow.setDividerMargin(dp2px(this, 15), 0, 0, 0);
                    singleSelectStyleOnePopupWindow.setSingleSelectListener(new SingleSelectListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            for (int i = 0; i < singleSelectBeanList.size(); i++) {
                                if (i == position) {
                                    singleSelectBeanList.get(i).setSelected(true);
                                } else {
                                    singleSelectBeanList.get(i).setSelected(false);
                                }
                            }
                            new ToastBuilder(MainActivity.this).setTitle(singleSelectBeanList.get(position).getName()).show();
                        }
                    });
                }
                if (singleSelectStyleOnePopupWindow.isShowing()) {
                    singleSelectStyleOnePopupWindow.dismiss();
                } else {
                    singleSelectStyleOnePopupWindow.setData(singleSelectBeanList);
                    singleSelectStyleOnePopupWindow.showAsDropDown(tvToast);
                }
                break;
            case R.id.tv_popupWindowCheckListTwo:
                if (singleSelectStyleTwoPopupWindow == null) {
                    singleSelectStyleTwoPopupWindow = new SingleSelectStyleTwoPopupWindow(MainActivity.this, ItemNum.ItemThree);
                    singleSelectStyleTwoPopupWindow.setTxtSize(16);
                    singleSelectStyleTwoPopupWindow.setTxtDefaultColor(R.color.dialog_color_3D464D);
                    singleSelectStyleTwoPopupWindow.setTxtSelectedColor(R.color.dialog_red);
                    singleSelectStyleTwoPopupWindow.setSelectedBg(R.drawable.popup_drawable_normal_radius_ture_stroke_true_select_true_red_selector);
                    singleSelectStyleTwoPopupWindow.setSingleSelectListener(new SingleSelectListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            for (int i = 0; i < singleSelectBeanList.size(); i++) {
                                if (i == position) {
                                    singleSelectBeanList.get(i).setSelected(true);
                                } else {
                                    singleSelectBeanList.get(i).setSelected(false);
                                }
                            }
                            new ToastBuilder(MainActivity.this).setTitle(singleSelectBeanList.get(position).getName()).show();
                        }
                    });
                }
                if (singleSelectStyleTwoPopupWindow.isShowing()) {
                    singleSelectStyleTwoPopupWindow.dismiss();
                } else {
                    singleSelectStyleTwoPopupWindow.setData(singleSelectBeanList);
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
