package com.ganji.mylottiedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.ViewDragHelper;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieRelativePointValueCallback;

public class Main6Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animationView);
        Button bt_replace_img = (Button) findViewById(R.id.bt_replace_img);

        lottieAnimationView.setAnimation("data.json");


        bt_replace_img.setOnClickListener(v->{
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.img_gj_yx);
            lottieAnimationView.updateBitmap("image_1", bitmap);
        });

    }





}