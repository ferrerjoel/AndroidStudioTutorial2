package com.example.tasca2

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var tv : TextView
    var count : Int = 0
    val rnd = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
    }

    fun add(view : View){
        count++
        tv.text = count.toString()
    }
    fun substract(view : View){
        count--
        tv.text = count.toString()
    }

    fun augment(view : View){
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, tv.textSize + 10)
    }

    fun decrease(view : View){
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, tv.textSize - 10)
    }

    fun hide(view : View){
        tv.visibility = View.INVISIBLE
    }

    fun show(view : View){
        tv.visibility = View.VISIBLE
    }

    fun textColor(view : View){
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        tv.setTextColor(color)
    }

    fun backgroundColor(view : View){
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        tv.setBackgroundColor(color)
    }

}