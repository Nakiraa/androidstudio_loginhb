package com.hb.loginhb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var buttonlog = findViewById(R.id.buttonlog) as Button


        buttonlog.setOnClickListener{
            if (username.text.toString() == "habli" && password.text.toString() == "habli"){
                Toast.makeText(this, "selamat datang habli", Toast.LENGTH_SHORT).show()

                val masuk = Intent (this@MainActivity,welcome::class.java)
                startActivity(masuk)
            }
            else{
                Toast.makeText(this, "username dan password anda salah", Toast.LENGTH_SHORT).show()
                username.setText("")
                password.setText("")
            }
        }
    }
}