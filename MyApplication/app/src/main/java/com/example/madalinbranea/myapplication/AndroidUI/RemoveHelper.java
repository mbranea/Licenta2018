package com.example.madalinbranea.myapplication.AndroidUI;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

public class RemoveHelper {

    static void removeAllChildViews(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof ViewGroup) {
                if (child instanceof AdapterView) {
                    viewGroup.removeView(child);
                    return;
                }
                removeAllChildViews(((ViewGroup) child));
            } else {
                viewGroup.removeView(child);
            }
        }
    }
}
