package com.ganji.mylottiedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ganji.mylottiedemo.R
import com.ganji.mylottiedemo.InterceptingFrameLayout
import com.ganji.mylottiedemo.BackgroundColorView
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.value.LottieRelativePointValueCallback
import android.graphics.PointF
import android.util.Log
import android.view.View
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.LottieProperty
import androidx.customview.widget.ViewDragHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class Main5Activity : AppCompatActivity() {
    var totalDxSmall = 0f
    var totalDySmall = 0f
    var totalDxMedium = 0f
    var totalDyMedium = 0f
    var totalDxLarge = 0f
    var totalDyLarge = 0f
    var plus = true
    private lateinit var largeValueCallback : LottieRelativePointValueCallback
    private lateinit var mediumValueCallback : LottieRelativePointValueCallback
    private lateinit var smallValueCallback : LottieRelativePointValueCallback
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        val frame = findViewById<View>(R.id.containerView) as InterceptingFrameLayout
        val lottieAnimationView = findViewById<View>(R.id.animationView) as LottieAnimationView

        //
        largeValueCallback = LottieRelativePointValueCallback(PointF(0f, 0f))
        lottieAnimationView.addValueCallback(
            KeyPath("First"),
            LottieProperty.TRANSFORM_POSITION,
            largeValueCallback
        )
        mediumValueCallback = LottieRelativePointValueCallback(PointF(0f, 0f))
        lottieAnimationView.addValueCallback(
            KeyPath("Fourth"),
            LottieProperty.TRANSFORM_POSITION,
            mediumValueCallback
        )
        smallValueCallback = LottieRelativePointValueCallback(PointF(0f, 0f))
        lottieAnimationView.addValueCallback(
            KeyPath("Seventh"),
            LottieProperty.TRANSFORM_POSITION,
            smallValueCallback
        )


        // 利用flow发送间隔操作，以展示效果动画
        val scope = CoroutineScope(SupervisorJob())
        val flow = flow{
            //创建数据流
            (0..2000).forEach {
                println("emit $it")
                kotlinx.coroutines.delay(10)
                emit(it)
            }
        }
        scope.launch{
            flow.collect {
                var temp = it%25
                if (it%25 == 0){
                    plus = !plus
                }
                updateAni(temp.toFloat(), temp.toFloat(),plus)
            }
        }

    }

    // 更新动画属性值
    fun updateAni(dx: Float, dy: Float, plus:Boolean){
        if (plus){
            totalDxSmall += dx.toFloat()
            totalDySmall += dy.toFloat()
            totalDxMedium -= dx.toFloat()
            totalDyMedium -= dy.toFloat()
            totalDxLarge  -= dx.toFloat()
            totalDyLarge += dy.toFloat()
        }else{
            totalDxSmall -= dx.toFloat()
            totalDySmall -= dy.toFloat()
            totalDxMedium += dx.toFloat()
            totalDyMedium += dy.toFloat()
            totalDxLarge  += dx.toFloat()
            totalDyLarge += dy.toFloat()
        }

        smallValueCallback.setValue(getPoint(totalDxSmall, totalDySmall, 1.2f))
        mediumValueCallback.setValue(getPoint(totalDxMedium, totalDyMedium, 1f))
        largeValueCallback.setValue(getPoint(totalDxLarge, totalDyLarge, 0.75f))
    }
    private fun getPoint(dx: Float, dy: Float, factor: Float): PointF {
        return PointF(dx * factor, dy * factor)
    }
}