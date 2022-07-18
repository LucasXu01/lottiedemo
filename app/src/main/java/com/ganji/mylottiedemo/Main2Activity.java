package com.ganji.mylottiedemo;

import android.os.Bundle;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import com.airbnb.lottie.LottieAnimationView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animationView3);
        AppCompatSeekBar seekbar = (AppCompatSeekBar) findViewById(R.id.seekBar);


        // 随手势进度动画
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {//设置滑动监听
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 正在拖动
                lottieAnimationView.setProgress((float)progress / seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //开始拖动
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //停止拖动
            }
        });




    }
}