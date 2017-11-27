package com.gaom.flingbehaviordemo;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class FlingBehavior extends Behavior {
    private boolean a;

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
        if ((velocityY > 0.0f && !this.a) || (velocityY < 0.0f && this.a)) {
            velocityY *= -1.0f;
        }
        if ((target instanceof RecyclerView) && velocityY < 0.0f) {
            RecyclerView recyclerView = (RecyclerView) target;
            if (recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) > 3) {
                consumed = true;
            } else {
                consumed = false;
            }
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        this.a = dy > 0;
    }
}