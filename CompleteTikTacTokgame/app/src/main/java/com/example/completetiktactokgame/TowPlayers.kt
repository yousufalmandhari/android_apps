package com.example.completetiktactokgame

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tow_players.*
import java.util.*
import kotlin.collections.ArrayList

class TowPlayers : AppCompatActivity() {

    var value :Int = 0

    // to check if someone wins
    var makeThemUnable: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tow_players)

        // hide the top
        supportActionBar!!.hide()

        var key :Intent = getIntent()
        value = key.getIntExtra("key", 1)
    }


    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun btnClicked(view :View){
        var btnSelected = view as Button

        if (btnSelected.id == btn1.id){
            whenClick(btn1, 1)
        }
        else if (btnSelected.id == btn2.id){
            whenClick(btn2, 2)
        }
        else if (btnSelected.id == btn3.id){
            whenClick(btn3, 3)
        }
        else if (btnSelected.id == btn4.id){
            whenClick(btn4, 4)
        }
        else if (btnSelected.id == btn5.id){
            whenClick(btn5, 5)
        }
        else if (btnSelected.id == btn6.id){
            whenClick(btn6, 6)
        }
        else if (btnSelected.id == btn7.id){
            whenClick(btn7, 7)
        }
        else if (btnSelected.id == btn8.id){
            whenClick(btn8, 8)
        }
        else if (btnSelected.id == btn9.id){
            whenClick(btn9, 9)
        }
    }

    fun whenClick(btn :Button, num :Int){
        if (value == 1) {
            if (activePlayer == 1) {
                player1.add(num)
                btn.isEnabled = false
                btn.text = "x"
                btn.setBackgroundColor(Color.BLACK)
                btn.setTextColor(Color.WHITE)
                checkWinner()
                activePlayer = 2
            } else if (activePlayer == 2) {
                player2.add(num)
                btn.isEnabled = false
                btn.text = "o"
                btn.setBackgroundColor(Color.WHITE)
                btn.setTextColor(Color.BLACK)
                checkWinner()
                activePlayer = 1
            }
        }
        else if (value == 2){
            player1.add(num)
            btn.isEnabled = false
            btn.text = "x"
            btn.setBackgroundColor(Color.BLACK)
            btn.setTextColor(Color.WHITE)
            checkWinner()
//            activePlayer = 2
            if (!makeThemUnable) {
                player2Randonly()
            }
        }
    }

    fun checkWinner(){
        makeThemUnable = false
        var howWins = ""

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            makeThemUnable = true
            howWins = "x"
        }
        else if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            makeThemUnable = true
            howWins = "x"
        }
        else if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            makeThemUnable = true
            howWins = "x"
        }

        else if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            makeThemUnable = true
            howWins = "x"
        }
        else if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            makeThemUnable = true
            howWins = "x"
        }
        else if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            makeThemUnable = true
            howWins = "x"
        }

        else if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            makeThemUnable = true
            howWins = "x"
        }
        else if (player1.contains(3) && player1.contains(5) && player1.contains(7)){
            makeThemUnable = true
            howWins = "x"
        }


        // for player2
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            makeThemUnable = true
            howWins = "y"
        }
        else if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            makeThemUnable = true
            howWins = "y"
        }
        else if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            makeThemUnable = true
            howWins = "y"
        }

        else if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            makeThemUnable = true
            howWins = "y"
        }
        else if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            makeThemUnable = true
            howWins = "y"
        }
        else if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            makeThemUnable = true
            howWins = "y"
        }

        else if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            makeThemUnable = true
            howWins = "y"
        }
        else if (player2.contains(3) && player2.contains(5) && player2.contains(7)){
            makeThemUnable = true
            howWins = "y"
        }

        if (makeThemUnable){
            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false
            btn5.isEnabled = false
            btn6.isEnabled = false
            btn7.isEnabled = false
            btn8.isEnabled = false
            btn9.isEnabled = false
        }

        if(howWins == "y"){
            Toast.makeText(this, "Player2 wins ", Toast.LENGTH_LONG).show()
        }
        else if(howWins == "x"){
            Toast.makeText(this, "Player1 wins ", Toast.LENGTH_LONG).show()
        }
    }

    fun restartBtn(view: View) {
        activePlayer = 1
        player1.clear()
        player2.clear()

        btn1.setBackgroundColor(Color.GRAY)
        btn1.text = ""
        btn1.isEnabled = true

        btn2.setBackgroundColor(Color.GRAY)
        btn2.text = ""
        btn2.isEnabled = true

        btn3.setBackgroundColor(Color.GRAY)
        btn3.text = ""
        btn3.isEnabled = true

        btn4.setBackgroundColor(Color.GRAY)
        btn4.text = ""
        btn4.isEnabled = true

        btn5.setBackgroundColor(Color.GRAY)
        btn5.text = ""
        btn5.isEnabled = true

        btn6.setBackgroundColor(Color.GRAY)
        btn6.text = ""
        btn6.isEnabled = true

        btn7.setBackgroundColor(Color.GRAY)
        btn7.text = ""
        btn7.isEnabled = true

        btn8.setBackgroundColor(Color.GRAY)
        btn8.text = ""
        btn8.isEnabled = true

        btn9.setBackgroundColor(Color.GRAY)
        btn9.text = ""
        btn9.isEnabled = true
    }

    fun player2Randonly(){
        var random = ArrayList<Int>()

        for (i in 1 .. 9){
            if(!(player1.contains(i) || player2.contains(i))){
                random.add(i)
            }
        }

        // pick randomly from random array
        val r = Random()
        val randIndex = r.nextInt(random.size )
        val num = random[randIndex]

        player2.add(num)

        when(num){
            1->{
                btn1.isEnabled = false
                btn1.text = "o"
                btn1.setBackgroundColor(Color.WHITE)
                btn1.setTextColor(Color.BLACK)
            }

            2->{
                btn2.isEnabled = false
                btn2.text = "o"
                btn2.setBackgroundColor(Color.WHITE)
                btn2.setTextColor(Color.BLACK)
            }

            3->{
                btn3.isEnabled = false
                btn3.text = "o"
                btn3.setBackgroundColor(Color.WHITE)
                btn3.setTextColor(Color.BLACK)
            }

            4->{
                btn4.isEnabled = false
                btn4.text = "o"
                btn4.setBackgroundColor(Color.WHITE)
                btn4.setTextColor(Color.BLACK)
            }

            5->{
                btn5.isEnabled = false
                btn5.text = "o"
                btn5.setBackgroundColor(Color.WHITE)
                btn5.setTextColor(Color.BLACK)
            }

            6->{
                btn6.isEnabled = false
                btn6.text = "o"
                btn6.setBackgroundColor(Color.WHITE)
                btn6.setTextColor(Color.BLACK)
            }

            7->{
                btn7.isEnabled = false
                btn7.text = "o"
                btn7.setBackgroundColor(Color.WHITE)
                btn7.setTextColor(Color.BLACK)
            }

            8->{
                btn8.isEnabled = false
                btn8.text = "o"
                btn8.setBackgroundColor(Color.WHITE)
                btn8.setTextColor(Color.BLACK)
            }

            9->{
                btn9.isEnabled = false
                btn9.text = "o"
                btn9.setBackgroundColor(Color.WHITE)
                btn9.setTextColor(Color.BLACK)
            }
        }

        checkWinner()
    }
}