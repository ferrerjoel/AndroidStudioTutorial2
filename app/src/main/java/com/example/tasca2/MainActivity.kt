package com.example.tasca2

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
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
    //Saves the count value before rotating the phone
    override fun onSaveInstanceState(savedInstanceState: Bundle) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("count", count)
        savedInstanceState.putFloat("size", tv.textSize)
        savedInstanceState.putInt("visibility", tv.visibility)
        savedInstanceState.putInt("textColor", tv.currentTextColor)
        savedInstanceState.putInt("bgColor", )
        // etc.
        super.onSaveInstanceState(savedInstanceState)
    }
    //Restores the count value after rotating the phone
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        tv.text = count.toString()
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, savedInstanceState.getFloat("size"))
        tv.visibility = savedInstanceState.getInt("visibility")
        tv.setTextColor(savedInstanceState.getInt("textColor"))
        findViewById<View>(android.R.id.content).rootView.setBackgroundColor(savedInstanceState.getInt("bgColor"))
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        showState(object{}.javaClass.enclosingMethod.name)
    }

    override fun onStart() {
        super.onStart()
        showState(object{}.javaClass.enclosingMethod.name)
    }

    override fun onResume() {
        super.onResume()
        showState(object{}.javaClass.enclosingMethod.name)
    }

    override fun onPause() {
        super.onPause()
        showState(object{}.javaClass.enclosingMethod.name)
    }

    override fun onStop() {
        super.onStop()
        showState(object{}.javaClass.enclosingMethod.name)
    }

    override fun onDestroy() {
        super.onDestroy()
        showState(object{}.javaClass.enclosingMethod.name)
    }

    private fun showState(currentState : String){
        Log.d(TAG, "Current state: $currentState")
        Toast.makeText(this, "Current state: $currentState", Toast.LENGTH_SHORT).show()
    }

    fun add(view : View){
        count++
        tv.text = count.toString()
    }
    fun subtract(view : View){
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
        findViewById<View>(android.R.id.content).rootView.setBackgroundColor(color)
    }

}