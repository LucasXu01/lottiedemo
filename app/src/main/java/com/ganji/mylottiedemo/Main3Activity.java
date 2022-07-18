package com.ganji.mylottiedemo;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.animationView3);



        //   ------------------------ 高级属性 - 文本/字体代理 -------------------------------
        lottieAnimationView.setFontAssetDelegate(new FontAssetDelegate(){
            @Override
            public Typeface fetchFont(String fontFamily) {
                Typeface typeface = Typeface.createFromAsset(getAssets(), "MyTypeFace.ttf");
                return typeface;
            }
        });

        TextDelegate textDelegate = new TextDelegate(lottieAnimationView);
        textDelegate.setText("Search_", "职位搜索");
        lottieAnimationView.setTextDelegate(textDelegate);
         // -----------------------------   over     -------------------------------------------

        //   ------------------------ 高级属性 - LottieProperty.COLOR 变色 -------------------------------
        KeyPath colorProperty = new KeyPath("Shape Layer 1", "Rectangle 1", "Fill 1");
        lottieAnimationView.addValueCallback(colorProperty, LottieProperty.COLOR, new SimpleLottieValueCallback<Integer>() {
            @Override
            public Integer getValue(LottieFrameInfo<Integer> frameInfo) {
                return 0xFFEE82EE;
            }
        });




    }
}