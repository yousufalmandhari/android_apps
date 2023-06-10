package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var result = ""
    var op = ""

    fun eqBtn(view: View) {
        if (op != ""){
            when(op){
                "*"->{
                    result = (result.toDouble() * tvNum.text.toString().toDouble()).toString()
                }
                "/"->{
                    result = (result.toDouble() / tvNum.text.toString().toDouble()).toString()
                }
                "+"->{
                    result = (result.toDouble() + tvNum.text.toString().toDouble()).toString()
                }
                "-"->{
                    result = (result.toDouble() - tvNum.text.toString().toDouble()).toString()
                }
                "%"->{
                    result = (result.toDouble() % tvNum.text.toString().toDouble()).toString()
                }
            }
        }
        else{
            result = tvNum.text.toString()
        }

        tvNum.text = result
        op = ""
        txv = ""
    }

    /*
     * Get the numbers from the buttons that clicked and show them for the user
     */
    var txv = ""
    fun numBtn(view: View) {
        var btnSelected = view as Button


        when(btnSelected.id){
            btn0.id->{
                txv += "0"
            }
            btn1.id->{
                txv += "1"
            }
            btn2.id->{
                txv += "2"
            }
            btn3.id->{
                txv += "3"
            }
            btn4.id->{
                txv += "4"
            }
            btn5.id->{
                txv += "5"
            }
            btn6.id->{
                txv += "6"
            }
            btn7.id->{
                txv += "7"
            }
            btn8.id->{
                txv += "8"
            }
            btn9.id->{
                txv += "9"
            }
            flipBtn.id->{
                var dd :Double = txv.toDouble()
                dd = dd * (-1)
                txv = dd.toString()
            }
            dotBtn.id->{
                txv += "."
            }
        }

        tvNum.text = txv
    }

    /*
     * Safe the operation and do the previous operation if is there
     */
    fun opBtn(view: View) {
        if(op != ""){
            if (result != ""){
                when(op){
                    "*"->{
                        result = (result.toDouble() * tvNum.text.toString().toDouble()).toString()
                    }
                    "/"->{
                        result = (result.toDouble() / tvNum.text.toString().toDouble()).toString()
                    }
                    "+"->{
                        result = (result.toDouble() + tvNum.text.toString().toDouble()).toString()
                    }
                    "-"->{
                        result = (result.toDouble() - tvNum.text.toString().toDouble()).toString()
                    }
                    "%"->{
                        result = (result.toDouble() % tvNum.text.toString().toDouble()).toString()
                    }
                }
            }

        }
        else{
            result = tvNum.text.toString()
        }

        var btnSelected = view as Button
        when(btnSelected.id){
            bbBtn.id->{
                op = "%"
            }
            mulBtn.id->{
                op = "*"
            }
            diBtn.id->{
                op = "/"
            }
            plusBtn.id->{
                op = "+"
            }
            minBtn.id->{
                op = "-"
            }
        }

        txv = ""
        tvNum.text = txv
    }

    /*
     * Delete every thing from the history
     */
    fun ACBtn(view: View) {
        result = ""
        op = ""
        txv = ""
        tvNum.text = ""
    }
}