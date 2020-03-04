package com.luffy.dialoglib.dialog.recycleView.item;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lvlufei on 2018/9/3
 *
 * @desc 子项分割线
 */
public class DialogItemDecoration extends RecyclerView.ItemDecoration {

    private DialogItemNum dialogItemNum;//子项数量
    private int space;//间距

    public DialogItemDecoration(DialogItemNum dialogItemNum, int space) {
        this.dialogItemNum = dialogItemNum;
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        switch (dialogItemNum) {
            case ItemThree:
                item(outRect, view, parent, 3);
                break;
            case ItemFour:
                item(outRect, view, parent, 4);
                break;
            case ItemFive:
                item(outRect, view, parent, 5);
                break;
            default:
                item(outRect, view, parent, 2);
                break;
        }
    }

    private void item(Rect outRect, View view, RecyclerView parent, int itemNum) {
        if (itemNum <= 0) {
            return;
        }
        if (parent.getChildLayoutPosition(view) % itemNum == itemNum - 1) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
        } else {
            outRect.left = space;
            outRect.bottom = space;
        }
    }
}
