package com.ganji.mylottiedemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LaunchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        // 简单使用
        findViewById<View>(R.id.bt_0).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main1Activity::class.java
                )
            )
        }

        // 手势进度动画
        findViewById<View>(R.id.bt_1).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main2Activity::class.java
                )
            )
        }
        // 动画
        findViewById<View>(R.id.bt_2).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main2Activity::class.java
                )
            )
        }
        // 高级属性
        findViewById<View>(R.id.bt_3).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main3Activity::class.java
                )
            )
        }
        // 手势
        findViewById<View>(R.id.bt_4).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main4Activity::class.java
                )
            )
        }
        // 手势
        findViewById<View>(R.id.bt_5).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main5Activity::class.java
                )
            )
        }
        // 替换图片
        findViewById<View>(R.id.bt_6).setOnClickListener { v: View? ->
            startActivity(
                Intent(
                    this,
                    Main6Activity::class.java
                )
            )
        }

    }
}