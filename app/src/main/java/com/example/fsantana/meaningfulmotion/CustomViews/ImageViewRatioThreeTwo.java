package com.example.fsantana.meaningfulmotion.CustomViews;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by fsantana on 12/01/16.
 */
public class ImageViewRatioThreeTwo extends ImageView {
    public ImageViewRatioThreeTwo(Context context) {
        super(context);
    }

    public ImageViewRatioThreeTwo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewRatioThreeTwo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ImageViewRatioThreeTwo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int threeTwo = MeasureSpec.getSize(widthMeasureSpec) * 2 / 3;
        int threeTwoSpec = MeasureSpec.makeMeasureSpec(threeTwo, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, threeTwoSpec);
    }

}
