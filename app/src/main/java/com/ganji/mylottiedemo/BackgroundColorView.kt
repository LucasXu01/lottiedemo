package com.ganji.mylottiedemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat

class BackgroundColorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleInt: Int = 0
) : View(context, attrs, defStyleInt) {

    private val paint = Paint().apply {
        isAntiAlias = true
    }


    @SuppressLint("MissingSuperCall")
    override fun draw(canvas: Canvas) {
        if (background !is ColorDrawable) return

        val cx = canvas.width / 2f
        val cy = canvas.height / 2f
        val r = cx.coerceAtMost(cy)
        if (getColor() == Color.WHITE) {
            paint.strokeWidth = 1f
            paint.style = Paint.Style.STROKE
            paint.color = ContextCompat.getColor(context, R.color.purple_500)
        } else {
            paint.color = getColor()
            paint.style = Paint.Style.FILL
        }
        canvas.drawCircle(cx, cy, r - paint.strokeWidth, paint)
    }

    @ColorInt
    fun getColor() = (background as ColorDrawable).color
}