package com.example.shopapp.UI.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import com.example.shopapp.R

class splash_secren : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_secren)

        /* This code to hide the top bar in the screen */
        @Suppress("DEPRECATION")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }
        else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }


        /* This code to move from splash class to the MainActivity class after 2500 milliSeconds */
        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(Intent(this@splash_secren, DashboardActivity::class.java))
                finish()
            },
            2500
        )
    }
}