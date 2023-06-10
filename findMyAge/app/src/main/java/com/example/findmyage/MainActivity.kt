package com.example.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnGetAge(view: View) {
        val age :Int?= edGetAge.text.toString().toInt()
        val year:Int = Calendar.getInstance().get(Calendar.YEAR)

        if (age != null){
            txtAge.text = "Your age now is " + (year - age).toString()
        }
        else{
            txtAge.text = "You have to enter age in the age lable to calculate"
        }
    }
}