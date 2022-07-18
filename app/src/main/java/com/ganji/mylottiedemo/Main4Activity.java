package com.ganji.mylottiedemo;

import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.ViewDragHelper;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieRelativePointValueCallback;

public class Main4Activity extends AppCompatActivity {


    Float totalDx = 0f;
    Float totalDy = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        InterceptingFrameLayout frame = (InterceptingFrameLayout) findViewById(R.id.containerView);
        BackgroundColorView targetView = (BackgroundColorView) findViewById(R.id.targetView);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animationView);

        LottieRelativePointValueCallback largeValueCallback = new LottieRelativePointValueCallback(new PointF(0f, 0f));
        lottieAnimationView.addValueCallback(new KeyPath("First"), LottieProperty.TRANSFORM_POSITION, largeValueCallback);

        LottieRelativePointValueCallback mediumValueCallback = new LottieRelativePointValueCallback(new PointF(0f, 0f));
        lottieAnimationView.addValueCallback(new KeyPath("Fourth"), LottieProperty.TRANSFORM_POSITION, mediumValueCallback);

        LottieRelativePointValueCallback smallValueCallback = new LottieRelativePointValueCallback(new PointF(0f, 0f));
        lottieAnimationView.addValueCallback(new KeyPath("Seventh"), LottieProperty.TRANSFORM_POSITION, smallValueCallback);



        ViewDragHelper viewDragHelper = ViewDragHelper.create(frame, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
                return (child == targetView);
            }

            @Override
            public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
                return  top;
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                return left;
            }

            @Override
            public void onViewPositionChanged(@NonNull View changedView, int left, int top, int dx, int dy) {
                Log.e("123", "onViewPositionChanged: dx："+ left + " " + top + " " + dx + " " +dy );
                totalDx += dx;
                totalDy += dy;
                smallValueCallback.setValue(getPoint(totalDx, totalDy, 1.2f));
                mediumValueCallback.setValue(getPoint(totalDx, totalDy, 1f));
                largeValueCallback.setValue(getPoint(totalDx, totalDy, 0.75f));
            }
        });
        frame.setViewDragHelper(viewDragHelper);

        


    }




    private PointF getPoint(Float dx, Float dy, Float factor){
        return new PointF(dx * factor, dy * factor);
    }



}