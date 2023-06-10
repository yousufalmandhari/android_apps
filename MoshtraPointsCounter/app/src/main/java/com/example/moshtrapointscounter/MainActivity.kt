package com.example.moshtrapointscounter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.ads.MobileAds


class MainActivity : AppCompatActivity() {

    var assPoints = ArrayList<Int>()
    var themPoints = ArrayList<Int>()

    /*
     * 1 : just them action
     * 2 : just ass action
     * 3 : both did action
     */
    var actions = ArrayList<Int>()

    private lateinit var listView :ListView
    private lateinit var listView2 :ListView

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        // google ads
        MobileAds.initialize(this)

        // banner
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-6621690273976628/2899512388"

        // load adds
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // Listviews
        listView = findViewById<ListView>(R.id.lvAss)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, assPoints)
        listView.adapter = adapter

        listView2 = findViewById<ListView>(R.id.lvThem)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, themPoints)
        listView2.adapter = adapter2


        // create popup menu
        val popupMenu = PopupMenu(this, popupBtn)
        // add menu items to the menu
        popupMenu.menu.add(Menu.NONE, 0, 0, R.string.move_back)
        popupMenu.menu.add(Menu.NONE, 1, 1, R.string.new_game)

        // when click on item on the menu
        popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            if (item!!.itemId == 0) {
                moveBack()
            } else if (item!!.itemId == 1) {
                // new game
                assPoints.clear()
                themPoints.clear()
                actions.clear()

                tvThem.text = ""
                tvAss.text = ""

                update(1)
                update(2)
            }

            true
        })

        popupBtn.setOnClickListener {
            popupMenu.show()
        }


        // Move to about me layout
        aboutMeBtn.setOnClickListener {
            val i = Intent(this, AboutMe::class.java)
            startActivity(i)
        }

    }


    fun countBtn(view: View) {

        var ass :String?= etAddAss.text.toString()
        var them :String?= etAddThem.text.toString()


        if (ass != ""){
            assPoints.add(ass!!.toInt())
            etAddAss.text = null
//            listView.deferNotifyDataSetChanged()
            update(1)
        }

        if (them != ""){
            themPoints.add(them!!.toInt())
            etAddThem.text = null
//            listView2.deferNotifyDataSetChanged()
            update(2)
        }


        if ((ass != "") && (them != "")){
            actions.add(3)
        }
        else if (ass != ""){
            actions.add(2)
        }
        else if (them != ""){
            actions.add(1)
        }
    }

    fun addOneBtn(view: View) {
        try {
            var btnSelected = view as ImageButton

            when (btnSelected.id) {
                AddOneAss.id -> {
                    tvAss.text = (tvAss.text.toString().toInt() + 1).toString()
                    assPoints.add(1)
                    update(1)
                    actions.add(2)
                }
                addOneThem.id -> {
                    tvThem.text = (tvThem.text.toString().toInt() + 1).toString()
                    themPoints.add(1)
                    update(2)
                    actions.add(1)
                }
            }
        }catch (e: Exception){
            Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
        }
    }

    fun update(who_is: Int){

        var sum = 0
        if (who_is == 1){
            tvAss.text = assPoints.sum().toString()
            listView.deferNotifyDataSetChanged()
        }
        else if (who_is == 2){
            tvThem.text = themPoints.sum().toString()
            listView2.deferNotifyDataSetChanged()
        }
    }

    fun moveBack(){
        if (!actions.isEmpty()) {
            var last = actions.last().toInt()
            actions.removeLast()

            if (last == 1){
                tvThem.text = (tvThem.text.toString().toInt() - themPoints.last()).toString()
                themPoints.removeLast()
                update(2)

            }
            else if (last == 2){
                tvAss.text = (tvAss.text.toString().toInt() - assPoints.last()).toString()
                assPoints.removeLast()
                update(1)
            }
            else if (last == 3){
                tvThem.text = (tvThem.text.toString().toInt() - themPoints.last()).toString()
                themPoints.removeLast()
                update(2)

                tvAss.text = (tvAss.text.toString().toInt() - assPoints.last()).toString()
                assPoints.removeLast()
                update(1)
            }
        }
    }
}