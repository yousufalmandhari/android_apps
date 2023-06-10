package com.example.moshtrapointscounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_me.*

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        supportActionBar!!.hide()

        aboutMeTxt.text = "ABOUT THE DEVELOPER : \n" +
                "My name is Yousuf Almandhari\n" +
                "Computer science student at Florida teach\n" +
                "4 years experience on making Applications\n\n" +
                "For business contact : \n" +
                "yosif2015.m@gmail.com"
    }
}