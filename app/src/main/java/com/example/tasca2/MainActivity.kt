package com.example.tasca2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tv : TextView
    var count : Int = 0
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
        tv.textSize = tv.textSize++
    }

    fun decrease(view : View){
        tv.textSize = tv.textSize--
    }

    fun hide(view : View){

    }

    fun show(view : View){

    }

    fun textColor(view : View){

    }

    fun backgroundColor(view : View){

    }

}