package com.example.tictactoclocalgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hide the top
        supportActionBar!!.hide()
    }

    /*
     * Functoin works when any button clicked
     */
    fun btn_clicked(view: View) {
        // get button id
        val buSelected = view as Button
        //buSelected.id

        var btn_id = 0
        when(buSelected.id){
            R.id.btn1 -> btn_id = 1
            R.id.btn2 -> btn_id = 2
            R.id.btn3 -> btn_id = 3
            R.id.btn4 -> btn_id = 4
            R.id.btn5 -> btn_id = 5
            R.id.btn6 -> btn_id = 6
            R.id.btn7 -> btn_id = 7
            R.id.btn8 -> btn_id = 8
            R.id.btn9 -> btn_id = 9
        }

        // show text message
        //Toast.makeText(this, "${btn_id}", Toast.LENGTH_SHORT).show()
        // calll play game function
        play_game(btn_id, buSelected)
    }

    var active_player = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    /*
     * This function change the color and the vesibality for the button that clicked
     * check if the game is end
     * have to parameters. One for id and the other for the button
     */
    fun play_game(btn_id :Int, buSelected:Button){

        if(active_player == 1){
            buSelected.text = "x"
            buSelected.setBackgroundResource(R.color.btn_x_background)
            player1.add(btn_id)
            active_player = 2
        }
        else{
            buSelected.text = "o"
            buSelected.setBackgroundResource(R.color.btn_o_background)
            player2.add(btn_id)
            active_player = 1
        }

        buSelected.isEnabled = false

        // call check_winner function to check if the game is over
        check_winner()
    }

    /*
     * check if the game is end
     */
    fun check_winner(){
        // check if any one complete all row
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            // show text message
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            // show text message
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            // show text message
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            // show text message
            Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            // show text message
            Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            // show text message
            Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show()
        }


        // check if any one complete all colomne
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            // show text message
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            // show text message
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            // show text message
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            // show text message
            Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            // show text message
            Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            // show text message
            Toast.makeText(this, "Player2 wins", Toast.LENGTH_SHORT).show()
        }


        // check if any one complete a cros
        else if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
        else if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            Toast.makeText(this, "Player1 wins", Toast.LENGTH_SHORT).show()
        }
    }

    /*
     * This function restart the game
     * make active player is 1
     * delete all the information before
     * make the button on the sitiuation as it was at the beginning
     */
    fun restartBtn(view: View) {
        active_player = 1
        //        var player1 = ArrayList<Int>()
        //        var player2 = ArrayList<Int>()

        for(i in player1){
            if(i == 1){
                btn7.text = ""
                btn7.setBackgroundResource(R.color.btn_first_background)
                btn7.isEnabled = true
            } else if(i == 2){
                btn8.text = ""
                btn8.setBackgroundResource(R.color.btn_first_background)
                btn8.isEnabled = true
            } else if(i == 3){
                btn9.text = ""
                btn9.setBackgroundResource(R.color.btn_first_background)
                btn9.isEnabled = true
            } else if(i == 4){
                btn7.text = ""
                btn7.setBackgroundResource(R.color.btn_first_background)
                btn7.isEnabled = true
            } else if(i == 5){
                btn8.text = ""
                btn8.setBackgroundResource(R.color.btn_first_background)
                btn8.isEnabled = true
            } else if(i == 6){
                btn9.text = ""
                btn9.setBackgroundResource(R.color.btn_first_background)
                btn9.isEnabled = true
            } else if(i == 7){
                btn7.text = ""
                btn7.setBackgroundResource(R.color.btn_first_background)
                btn7.isEnabled = true
            } else if(i == 8){
                btn8.text = ""
                btn8.setBackgroundResource(R.color.btn_first_background)
                btn8.isEnabled = true
            } else if(i == 9){
                btn9.text = ""
                btn9.setBackgroundResource(R.color.btn_first_background)
                btn9.isEnabled = true
            }
        }


        // player 2
        for(i in player2){
            if(i == 1){
                btn7.text = ""
                btn7.setBackgroundResource(R.color.btn_first_background)
                btn7.isEnabled = true
            } else if(i == 2){
                btn8.text = ""
                btn8.setBackgroundResource(R.color.btn_first_background)
                btn8.isEnabled = true
            } else if(i == 3){
                btn9.text = ""
                btn9.setBackgroundResource(R.color.btn_first_background)
                btn9.isEnabled = true
            } else if(i == 4){
                btn7.text = ""
                btn7.setBackgroundResource(R.color.btn_first_background)
                btn7.isEnabled = true
            } else if(i == 5){
                btn8.text = ""
                btn8.setBackgroundResource(R.color.btn_first_background)
                btn8.isEnabled = true
            } else if(i == 6){
                btn9.text = ""
                btn9.setBackgroundResource(R.color.btn_first_background)
                btn9.isEnabled = true
            } else if(i == 7){
                btn7.text = ""
                btn7.setBackgroundResource(R.color.btn_first_background)
                btn7.isEnabled = true
            } else if(i == 8){
                btn8.text = ""
                btn8.setBackgroundResource(R.color.btn_first_background)
                btn8.isEnabled = true
            } else if(i == 9){
                btn9.text = ""
                btn9.setBackgroundResource(R.color.btn_first_background)
                btn9.isEnabled = true
            }
        }

        // remove all elements
        player1.clear()
        player2.clear()
    }

}