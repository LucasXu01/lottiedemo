package com.ganji.mylottiedemo;

import android.animation.Animator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;

public class Main1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animationView3);

        lottieAnimationView.setAnimationFromUrl("http://qiniu.yanfriends.com/LottieLogo.json.zip");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();


        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        lottieAnimationView.addAnimatorPauseListener(new Animator.AnimatorPauseListener() {
            @Override
            public void onAnimationPause(Animator animator) {

            }

            @Override
            public void onAnimationResume(Animator animator) {

            }
        });


        //监听json文件加载完成
        lottieAnimationView.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(LottieComposition composition) {
                //此时渲染了动画第一帧


            }
        });


    }
}