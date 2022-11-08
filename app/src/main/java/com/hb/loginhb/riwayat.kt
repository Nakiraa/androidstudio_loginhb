package com.hb.loginhb

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class riwayat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riwayat)

        val listView = findViewById<ListView>(R.id.listdata)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list1)

        val ss : String = intent.getStringExtra("benar").toString()
        val angka : TextView = findViewById(R.id.angka1)
        angka.text = ss
    }


}