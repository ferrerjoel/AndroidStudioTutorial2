package com.example.tasca2

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
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
    private lateinit var tv : TextView
    private var count : Int = 0
    private val rnd = Random()
    private val TAG : String = "STATE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
        tv.text = count.toString()

        showState(object{}.javaClass.enclosingMethod.name)
    }

    /**
     * Saves values to use when rotating the screen
     */
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putInt("count", count)
        savedInstanceState.putFloat("size", tv.textSize)
        savedInstanceState.putInt("visibility", tv.visibility)
        savedInstanceState.putInt("textColor", tv.currentTextColor)
        val background : Drawable = findViewById<View>(android.R.id.content).rootView.background
        if (background is ColorDrawable){
            savedInstanceState.putInt("bgColor", background.color)
        } else {
            savedInstanceState.putInt("bgColor", 0)
        }
        // etc.
        super.onSaveInstanceState(savedInstanceState)
    }

    /**
     * Restores the values saved when rotating
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count")
        tv.text = count.toString()
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, savedInstanceState.getFloat("size"))
        tv.visibility = savedInstanceState.getInt("visibility")
        tv.setTextColor(savedInstanceState.getInt("textColor"))
        findViewById<View>(android.R.id.content).rootView.setBackgroundColor(savedInstanceState.getInt("bgColor"))
    }

    override fun onRestart() {
        super.onRestart()
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

    /**
     * Prints a message to the log and shows a toasts with a string passed by
     */
    private fun showState(currentState : String){
        Log.d(TAG, "Current state: $currentState")
        Toast.makeText(this, "Current state: $currentState", Toast.LENGTH_SHORT).show()
    }

    /**
     * Adds +1 to the count value
     */
    fun add(view : View){
        count++
        tv.text = count.toString()
    }

    /**
     * Subtract -1 to the count value
     */
    fun subtract(view : View){
        count--
        tv.text = count.toString()
    }

    /**
     * Augments the size of the text view
     */
    fun augment(view : View){
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, tv.textSize + 10)
    }

    /**
     * Decreases the size of the text view
     */
    fun decrease(view : View){
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, tv.textSize - 10)
    }

    /**
     * Hides the text view
     */
    fun hide(view : View){
        tv.visibility = View.INVISIBLE
    }

    /**
     * Shows the text view
     */
    fun show(view : View){
        tv.visibility = View.VISIBLE
    }

    /**
     * Changes the text color of the text view to a random color
     */
    fun textColor(view : View){
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        tv.setTextColor(color)
    }

    /**
     * Changes the background color to a random color of the root view
     */
    fun backgroundColor(view : View){
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        findViewById<View>(android.R.id.content).rootView.setBackgroundColor(color)
    }

}