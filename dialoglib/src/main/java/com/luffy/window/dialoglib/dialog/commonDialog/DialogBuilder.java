package com.luffy.window.dialoglib.dialog.commonDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.luffy.dialoglib.R;
import com.luffy.window.dialoglib.dialog.base.BaseDialogBuilder;


/**
 * Created by lvlufei on 2018/7/26
 *
 * @desc Dialog
 */
public class DialogBuilder extends BaseDialogBuilder {

    public DialogBuilder(Context mContext) {
        super(mContext);
    }

    @Override
    public int bindView() {
        return R.layout.dialog_common_layout;
    }

    @Override
    public void init() {
        //点击屏幕不消失
        setCanceledOnTouchOutside(false);
        //点击物理返回键不消失
        setCancelable(false);
    }

    /**
     * 设置对话框背景样式
     *
     * @param resid
     * @return
     */
    public DialogBuilder setBgStyle(int resid) {
        LinearLayout layoutDialogBase = mView.findViewById(R.id.layout_dialog_base);
        layoutDialogBase.setBackgroundResource(resid);
        return this;
    }

    /**
     * 设置对话框距离左右的边距
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @return
     */
    public DialogBuilder setMargin(int left, int top, int right, int bottom) {
        LinearLayout layoutDialogBase = mView.findViewById(R.id.layout_dialog_base);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams
                .WRAP_CONTENT);
        layoutParams.setMargins(left, top, right, bottom);
        layoutDialogBase.setLayoutParams(layoutParams);
        return this;
    }


    /*----------顶部图片（begin）----------*/

    /**
     * 设置顶部图片-通过Drawable
     *
     * @param icon
     * @return
     */
    public DialogBuilder setTopIcon(Drawable icon) {
        ImageView view = mView.findViewById(R.id.topIcon);
        view.setImageDrawable(icon);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置顶部图片-通过ID
     *
     * @param iconId
     * @return
     */
    public DialogBuilder setTopIcon(int iconId) {
        ImageView view = mView.findViewById(R.id.topIcon);
        view.setImageResource(iconId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------顶部图片（end）----------*/
    /*----------标题（begin）----------*/

    /**
     * 设置标题--通过ID
     *
     * @param titleId
     * @return
     */
    public DialogBuilder setTitle(int titleId) {
        TextView view = mView.findViewById(R.id.title);
        view.setMovementMethod(new ScrollingMovementMethod());
        view.setText(titleId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置标题--通过文本
     *
     * @param title
     * @return
     */
    public DialogBuilder setTitle(CharSequence title) {
        TextView view = mView.findViewById(R.id.title);
        view.setMovementMethod(new ScrollingMovementMethod());
        view.setText(title);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置标题大小
     *
     * @param titleSize
     * @return
     */
    public DialogBuilder setTitleSize(int titleSize) {
        TextView view = mView.findViewById(R.id.title);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleSize);
        return this;
    }

    /**
     * 设置标题颜色
     *
     * @param titleColor
     * @return
     */
    public DialogBuilder setTitleColor(int titleColor) {
        TextView view = mView.findViewById(R.id.title);
        view.setTextColor(ContextCompat.getColor(mContext, titleColor));
        return this;
    }

    /**
     * 设置框标题位置
     *
     * @param gravity
     * @return
     */
    public DialogBuilder setTitleGravity(int gravity) {
        TextView view = mView.findViewById(R.id.title);
        view.setGravity(gravity);
        return this;
    }

    /**
     * 设置框标题行间距
     *
     * @param lineSpacing
     * @return
     */
    public DialogBuilder setTitleLineSpacing(float lineSpacing) {
        TextView view = mView.findViewById(R.id.title);
        view.setLineSpacing(lineSpacing, 1);
        return this;
    }

    /*----------标题（end）----------*/
    /*----------内容（begin）----------*/

    /**
     * 设置内容--通过ID
     *
     * @param contentId
     * @return
     */
    public DialogBuilder setContent(int contentId) {
        TextView view = mView.findViewById(R.id.content);
        view.setMovementMethod(new ScrollingMovementMethod());
        view.setText(contentId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置内容--通过文本
     *
     * @param content
     * @return
     */
    public DialogBuilder setContent(CharSequence content) {
        TextView view = mView.findViewById(R.id.content);
        view.setMovementMethod(new ScrollingMovementMethod());
        view.setText(content);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置内容大小
     *
     * @param contentSize
     * @return
     */
    public DialogBuilder setContentSize(int contentSize) {
        TextView view = mView.findViewById(R.id.content);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, contentSize);
        return this;
    }

    /**
     * 设置内容颜色
     *
     * @param contentColor
     * @return
     */
    public DialogBuilder setContentColor(int contentColor) {
        TextView view = mView.findViewById(R.id.content);
        view.setTextColor(ContextCompat.getColor(mContext, contentColor));
        return this;
    }

    /**
     * 设置内容位置
     *
     * @param gravity
     * @return
     */
    public DialogBuilder setContentGravity(int gravity) {
        TextView view = mView.findViewById(R.id.content);
        view.setGravity(gravity);
        return this;
    }

    /**
     * 设置内容行间距
     *
     * @param lineSpacing
     * @return
     */
    public DialogBuilder setContentLineSpacing(float lineSpacing) {
        TextView view = mView.findViewById(R.id.content);
        view.setLineSpacing(lineSpacing, 1);
        return this;
    }

    /*----------内容（end）----------*/
    /*----------图片（begin）----------*/

    /**
     * 设置图片--通过Id
     *
     * @param iconId
     * @return
     */
    public DialogBuilder setIcon(int iconId) {
        ImageView view = mView.findViewById(R.id.icon);
        view.setImageResource(iconId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置图片--通过Drawable
     *
     * @param icon
     * @return
     */
    public DialogBuilder setIcon(Drawable icon) {
        ImageView view = mView.findViewById(R.id.icon);
        view.setImageDrawable(icon);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------内容（end）----------*/
    /*----------编辑框（begin）----------*/

    /**
     * 设置编辑框父类背景
     *
     * @param bgId
     * @return
     */
    public DialogBuilder setEditBoxParentBG(int bgId) {
        RelativeLayout view = mView.findViewById(R.id.edit_box_parent);
        view.setBackgroundResource(bgId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框父类背景
     *
     * @param drawable
     * @return
     */
    public DialogBuilder setEditBoxParentBG(Drawable drawable) {
        RelativeLayout view = mView.findViewById(R.id.edit_box_parent);
        view.setBackgroundDrawable(drawable);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框背景
     *
     * @param bgId
     * @return
     */

    public DialogBuilder setEditBoxBg(int bgId) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setBackgroundResource(bgId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框背景
     *
     * @param bg
     * @return
     */
    public DialogBuilder setEditBoxBg(Drawable bg) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setBackgroundDrawable(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框内间距
     *
     * @param padding
     * @return
     */
    public DialogBuilder setEditBoxPadding(int padding) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setPadding(padding, padding, padding, padding);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框内间距
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @return
     */
    public DialogBuilder setEditBoxPadding(int left, int top, int right, int bottom) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setPadding(left, top, right, bottom);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框提示语-通过ID
     *
     * @param hintId
     * @return
     */
    public DialogBuilder setEditBoxHint(int hintId) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setHint(hintId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框提示语-通过文本
     *
     * @param hintId
     * @return
     */
    public DialogBuilder setEditBoxHint(CharSequence hintId) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setHint(hintId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框提示语颜色
     *
     * @param hintColor
     * @return
     */
    public DialogBuilder setEditBoxHintColor(int hintColor) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setTextColor(ContextCompat.getColor(mContext, hintColor));
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置输入长度
     *
     * @param inputLength
     * @return
     */
    public DialogBuilder setEditBoxInputLength(int inputLength) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setFilters(new InputFilter[]{new InputFilter.LengthFilter(inputLength)});
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置输入限制
     * 注意：此方法与setEditBoxInputLength只能用一个
     *
     * @param inputFilters 可增加多个限制
     * @return
     */
    public DialogBuilder setEditBoxContentInputFilter(InputFilter[] inputFilters) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setFilters(inputFilters);
        return this;
    }

    /**
     * 设置编辑框内容颜色
     *
     * @param contentColor
     * @return
     */
    public DialogBuilder setEditBoxContentColor(int contentColor) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setTextColor(ContextCompat.getColor(mContext, contentColor));
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框内容大小
     *
     * @param contentSize
     * @return
     */
    public DialogBuilder setEditBoxContentSize(int contentSize) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, contentSize);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框内容位置
     *
     * @param gravity
     * @return
     */
    public DialogBuilder setEditBoxContentGravity(int gravity) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setGravity(gravity);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框内容布局参数
     *
     * @param layoutParams
     * @return
     */
    public DialogBuilder setEditBoxContentParameter(ViewGroup.LayoutParams layoutParams) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setLayoutParams(layoutParams);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框字数变化监听
     *
     * @param watcher
     * @return
     */
    public DialogBuilder setEditTextChangedListener(TextWatcher watcher) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.addTextChangedListener(watcher);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框密码格式
     *
     * @param inputType
     * @return
     */
    public DialogBuilder setEditBoxInputType(int inputType) {
        EditText view = mView.findViewById(R.id.edit_box_content);
        view.setInputType(inputType);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 获取编辑框内容
     *
     * @return
     */
    public String getEditBoxContent() {
        EditText view = mView.findViewById(R.id.edit_box_content);
        return view.getText().toString();
    }

    /**
     * 设置编辑框计数内容--通过ID
     *
     * @param textId
     * @return
     */
    public DialogBuilder setEditBoxCountText(int textId) {
        TextView view = mView.findViewById(R.id.text_box_count);
        view.setText(textId);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框计数内容--通过文本
     *
     * @param count
     * @return
     */
    public DialogBuilder setEditBoxCountText(CharSequence count) {
        TextView view = mView.findViewById(R.id.text_box_count);
        view.setText(count);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框计数颜色
     *
     * @param colorId
     * @return
     */
    public DialogBuilder setEditBoxCountColor(int colorId) {
        TextView view = mView.findViewById(R.id.text_box_count);
        view.setTextColor(ContextCompat.getColor(mContext, colorId));
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置编辑框计数字体大小
     *
     * @param size
     * @return
     */
    public DialogBuilder setEditBoxCountTextSize(int size) {
        TextView view = mView.findViewById(R.id.text_box_count);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------编辑框（end）----------*/
    /*----------间隙（begin）----------*/

    /**
     * 设置间隙
     *
     * @param isVisible
     * @return
     */
    public DialogBuilder setGaps(boolean isVisible) {
        View gaps = mView.findViewById(R.id.gaps);
        gaps.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        return this;
    }

    /*----------间隙（end）----------*/
    /*----------分割线（begin）----------*/

    /**
     * 设置分割线
     *
     * @param isVisible
     * @return
     */
    public DialogBuilder setDivider(boolean isVisible) {
        View divider = mView.findViewById(R.id.divider);
        divider.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        return this;
    }

    /*----------分割线（end）----------*/
    /*----------普通确定按钮（begin）----------*/

    /**
     * 设置普通按钮--外边距
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @return
     */
    public DialogBuilder setCommonButtonMargin(int left, int top, int right, int bottom) {
        LinearLayout layout = mView.findViewById(R.id.layout_common_btn);
        LinearLayout.LayoutParams mLayoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        mLayoutParams.setMargins(left, top, right, bottom);
        return this;
    }

    /**
     * 设置普通确定按钮--通过ID
     *
     * @param textId
     * @param listener
     * @return
     */
    public DialogBuilder setCommonConfirmButton(int textId, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_common_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.common_sure);
        view.setText(textId);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_POSITIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置普通确定按钮--通过文本
     *
     * @param text
     * @param listener
     * @return
     */
    public DialogBuilder setCommonConfirmButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_common_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.common_sure);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_POSITIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置普通确定按钮背景--通过ID
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setCommonConfirmButtonBG(int bg, int textColor) {
        TextView view = mView.findViewById(R.id.common_sure);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundResource(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置普通确定按钮背景--通过Drawable
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setCommonConfirmButtonBG(Drawable bg, int textColor) {
        TextView view = mView.findViewById(R.id.common_sure);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundDrawable(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------普通确定按钮（end）----------*/
    /*----------普通取消按钮（begin）----------*/

    /**
     * 设置普通取消按钮--通过ID
     *
     * @param textId
     * @param listener
     * @return
     */
    public DialogBuilder setCommonCancelButton(int textId, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_common_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.common_cancel);
        view.setText(textId);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置普通取消按钮--通过文本
     *
     * @param text
     * @param listener
     * @return
     */
    public DialogBuilder setCommonCancelButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_common_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.common_cancel);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置普通取消按钮背景--通过ID
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setCommonCancelButtonBG(int bg, int textColor) {
        TextView view = mView.findViewById(R.id.common_cancel);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundResource(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置普通取消按钮背景--通过Drawable
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setCommonCancelButtonBG(Drawable bg, int textColor) {
        TextView view = mView.findViewById(R.id.common_cancel);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundDrawable(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------普通取消按钮（end）----------*/
    /*----------简单确定按钮（begin）----------*/

    /**
     * 设置简单按钮--外边距
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @return
     */
    public DialogBuilder setSimpleButtonMargin(int left, int top, int right, int bottom) {
        LinearLayout layout = mView.findViewById(R.id.layout_simple_btn);
        LinearLayout.LayoutParams mLayoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        mLayoutParams.setMargins(left, top, right, bottom);
        return this;
    }

    /**
     * 设置简单确定按钮--通过ID
     *
     * @param textId
     * @param listener
     * @return
     */
    public DialogBuilder setSimpleConfirmButton(int textId, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_simple_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.simple_confirm);
        view.setText(textId);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isShowing() && isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_POSITIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置简单确定按钮--通过文本
     *
     * @param text
     * @param listener
     * @return
     */
    public DialogBuilder setSimpleConfirmButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_simple_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.simple_confirm);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_POSITIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置简单确定按钮背景--通过ID
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setSimpleConfirmButtonBG(int bg, int textColor) {
        TextView view = mView.findViewById(R.id.simple_confirm);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundResource(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置简单确定按钮背景--通过Drawable
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setSimpleConfirmButtonBG(Drawable bg, int textColor) {
        TextView view = mView.findViewById(R.id.simple_confirm);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundDrawable(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------简单确定按钮（end）----------*/
    /*----------简单取消按钮（begin）----------*/

    /**
     * 设置简单取消按钮--通过ID
     *
     * @param textId
     * @param listener
     * @return
     */
    public DialogBuilder setSimpleCancelButton(int textId, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_simple_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.simple_cancel);
        view.setText(textId);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置简单取消按钮--通过文字
     *
     * @param text
     * @param listener
     * @return
     */
    public DialogBuilder setSimpleCancelButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        LinearLayout layout = mView.findViewById(R.id.layout_simple_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.simple_cancel);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置简单取消按钮背景--通过ID
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setSimpleCancelButtonBG(int bg, int textColor) {
        TextView view = mView.findViewById(R.id.simple_cancel);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundResource(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置简单取消按钮背景--通过Drawable
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setSimpleCancelButtonBG(Drawable bg, int textColor) {
        TextView view = mView.findViewById(R.id.simple_cancel);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundDrawable(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /*----------简单取消按钮（end）----------*/
    /*----------扩展按钮（begin）----------*/

    /**
     * 设置扩展按钮--通过ID
     *
     * @param textId
     * @param listener
     * @return
     */
    public DialogBuilder setExtendButton(int textId, final DialogInterface.OnClickListener listener) {
        RelativeLayout layout = mView.findViewById(R.id.layout_extend_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.extend);
        view.setText(textId);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置扩展按钮--通过文字
     *
     * @param text
     * @param listener
     * @return
     */
    public DialogBuilder setExtendButton(CharSequence text, final DialogInterface.OnClickListener listener) {
        RelativeLayout layout = mView.findViewById(R.id.layout_extend_btn);
        layout.setVisibility(View.VISIBLE);
        TextView view = mView.findViewById(R.id.extend);
        view.setText(text);
        view.setVisibility(View.VISIBLE);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isAutoDismiss()) {
                    dismiss();
                }
                if (listener != null) {
                    listener.onClick(mDialog, Dialog.BUTTON_NEGATIVE);
                }
            }
        });
        return this;
    }

    /**
     * 设置扩展按钮背景--通过ID
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setExtendButtonBG(int bg, int textColor) {
        TextView view = mView.findViewById(R.id.extend);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundResource(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置扩展按钮背景--通过Drawable
     *
     * @param bg
     * @param textColor
     * @return
     */
    public DialogBuilder setExtendButtonBG(Drawable bg, int textColor) {
        TextView view = mView.findViewById(R.id.extend);
        view.setTextColor(ContextCompat.getColor(mContext, textColor));
        view.setBackgroundDrawable(bg);
        view.setVisibility(View.VISIBLE);
        return this;
    }

    /**
     * 设置扩展按钮参数--通过ID
     *
     * @param layoutParams
     * @return
     */
    public DialogBuilder setExtendButtonLayoutParams(ViewGroup.LayoutParams layoutParams) {
        TextView view = mView.findViewById(R.id.extend);
        view.setLayoutParams(layoutParams);
        return this;
    }

}