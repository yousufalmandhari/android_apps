package com.example.completetiktactokgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hide the top
        supportActionBar!!.hide()
    }

    fun doActoin(view: View) {
        var btnSelected = view as Button

        when(btnSelected.id){
            tow_players.id ->{
                // go to TowPlayers activity
                val i = Intent(this, TowPlayers::class.java)
                i.putExtra("key", 1)
                startActivity(i)
            }

            playDeviceBtn.id ->{
                val i = Intent(this, TowPlayers::class.java)
                i.putExtra("key", 2)
                startActivity(i)
            }
        }

    }
}