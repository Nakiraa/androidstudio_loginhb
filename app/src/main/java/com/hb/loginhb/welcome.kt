package com.hb.loginhb

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


val list1 : MutableList<String> = mutableListOf<String>()

class welcome : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        //dadu 1
        val roll1: Button = findViewById(R.id.roll1)
        roll1.setOnClickListener {rol1()}
        //dadu2
        val roll2 : Button = findViewById(R.id.roll2)
        roll2.setOnClickListener {rol2()}
        //hasil
        val buthasil :Button = findViewById(R.id.hasilbut)
        buthasil.setOnClickListener {buttonhasil()}

        val reset : Button = findViewById(R.id.reset)
        reset.setOnClickListener { reset()}

        val riwayat : Button = findViewById(R.id.riwayat)
        riwayat.setOnClickListener{riwayat1()}
    }

    private fun rol1(){
        val angka1: TextView = findViewById(R.id.angka1)
        val randomInt1 = (1..6).random()
        angka1.text = randomInt1.toString()

        val image1 : ImageView = findViewById(R.id.dadu1)

        val drawable = when (randomInt1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image1.setImageResource(drawable)
    }

    private fun rol2(){
        val angka2 : TextView = findViewById(R.id.angka2)
        val randomInt2 = (1..6).random()
        angka2.text = randomInt2.toString()

        val image2 : ImageView = findViewById(R.id.dadu2)

        val drawable = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        image2.setImageResource(drawable)
    }

    private fun buttonhasil() {
        val angka1: TextView = findViewById(R.id.angka1)
        val angka2: TextView = findViewById(R.id.angka2)
        val hasil: EditText = findViewById(R.id.hasil)


        val habli1 = angka1.text.toString().toInt()
        val habli2 = angka2.text.toString().toInt()

        val tambah = habli1 + habli2

        val isi1 = hasil.getText().toString()

        if (isi1.isEmpty()) {
            hasil.error = "silakan di isi dahulu"
        } else {
            val isi4 : Int = isi1.toInt()
            if (isi4 == tambah) {
                list1.add("$habli1 + $habli2 = $tambah jawaban anda benar")
                Toast.makeText(this, "jawaban anda benar", Toast.LENGTH_SHORT).show()
            } else {
                list1.add("$habli1 + $habli2 = $isi1 jawaban anda salah")
                Toast.makeText(this, "jawaban anda salah", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun reset(){
        val angka1: TextView = findViewById(R.id.angka1)
        val angka2: TextView = findViewById(R.id.angka2)
        val hasil: EditText = findViewById(R.id.hasil)
        val image1 : ImageView = findViewById(R.id.dadu1)
        val image2 : ImageView = findViewById(R.id.dadu2)

        angka1.setText("")
        angka2.setText("")
        hasil.setText("")

        image1.setImageResource(R.drawable.empty_dice)
        image2.setImageResource(R.drawable.empty_dice)
    }

    private fun riwayat1(){
        val angka1: TextView = findViewById(R.id.angka1)
        val angka2: TextView = findViewById(R.id.angka2)
        val hasil: EditText = findViewById(R.id.hasil)


        val habli1 = angka1.text.toString().toInt()
        val habli2 = angka2.text.toString().toInt()

        val tambah = habli1 + habli2

        val isi1 = hasil.getText().toString()

        if (isi1.isEmpty()) {
            hasil.error = "silakan di isi dahulu"
        } else {
            val isi4 : Int = isi1.toInt()
            if (isi4 == tambah) {
                val r = Intent (this@welcome,riwayat::class.java)
                r.putExtra("benar", "benar $angka1")
                startActivity(r)
                Toast.makeText(this, "jawaban anda benar", Toast.LENGTH_SHORT).show()
            } else {
                val r = Intent (this@welcome,riwayat::class.java)
                r.putExtra("salah", "salah")
                startActivity(r)
                Toast.makeText(this, "jawaban anda salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



