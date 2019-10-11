package com.luffy.generaldialoglib.popupWindow.listPopupWindow.singleSelect.item;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lvlufei on 2018/9/3
 *
 * @desc 子项分割线
 */
public class ItemDecoration extends RecyclerView.ItemDecoration {

    private ItemNum itemNum;//子项数量
    private int space;//间距

    public ItemDecoration(ItemNum itemNum, int space) {
        this.itemNum = itemNum;
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        switch (itemNum) {
            case ItemTwo:
                itemTwo(outRect, view, parent);
                break;
            case ItemThree:
                itemThree(outRect, view, parent);
                break;
            case ItemFour:
                itemFour(outRect, view, parent);
                break;
            case ItemFive:
                itemFive(outRect, view, parent);
                break;
            default:
                itemTwo(outRect, view, parent);
                break;
        }
    }

    private void itemTwo(Rect outRect, View view, RecyclerView parent) {
        if (parent.getChildLayoutPosition(view) % 2 == 0) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 2 == 1) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
        }
    }

    private void itemThree(Rect outRect, View view, RecyclerView parent) {
        if (parent.getChildLayoutPosition(view) % 3 == 0) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 3 == 1) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 3 == 2) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
        }
    }

    private void itemFour(Rect outRect, View view, RecyclerView parent) {
        if (parent.getChildLayoutPosition(view) % 4 == 0) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 4 == 1) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 4 == 2) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 4 == 3) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
        }
    }

    private void itemFive(Rect outRect, View view, RecyclerView parent) {
        if (parent.getChildLayoutPosition(view) % 5 == 0) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 5 == 1) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 5 == 2) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 5 == 3) {
            outRect.left = space;
            outRect.bottom = space;
        } else if (parent.getChildLayoutPosition(view) % 5 == 4) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
        }
    }
}
