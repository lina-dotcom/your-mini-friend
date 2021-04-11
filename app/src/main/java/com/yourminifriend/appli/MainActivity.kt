package com.yourminifriend.appli

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yourminifriend.appli.R
import com.yourminifriend.appli.SwipeLeft
import com.yourminifriend.appli.SwipeRight

class MainActivity : AppCompatActivity() {
    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(touchEvent: MotionEvent): Boolean {
        when (touchEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = touchEvent.x
                y1 = touchEvent.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = touchEvent.x
                y2 = touchEvent.y
                if (x1 < x2) {
                    val i = Intent(this@MainActivity, SwipeLeft::class.java)
                    startActivity(i)
                } else if (x1 > x2) {
                    val i = Intent(this@MainActivity, SwipeRight::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }
}

