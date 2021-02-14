package com.example.practica03guessthenumber_165454

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0
    var maxValue = 0
    var num: Int = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessing: TextView = findViewById(R.id.guessings)
        val down: Button = findViewById(R.id.btnDown)
        val up: Button = findViewById(R.id.btnUp)
        val generate: Button = findViewById(R.id.btnGenerate)
        val guessed: Button = findViewById(R.id.btnGuessed)

        generate.setOnClickListener{
            num = Random.nextInt(minValue, maxValue)
            guessing.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        fun checkingLimits(): Boolean{
            return minValue != maxValue
        }

        fun resetValues(){
            minValue=0
            maxValue=100
            num=0
            won=false
        }

        up.setOnClickListener{
            minValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("Ganaste")
            }
        }

        down.setOnClickListener {
            maxValue = num
            if (checkingLimits()) {
                num = Random.nextInt(minValue, maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("Me ganaste")
            }
        }

        guessed.setOnClickListener{
            if(!won) {
                guessing.setText("Adivina el numero")
                guessed.setText("Intentalo de nuevo")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                guessing.setText("Tap on generate to start")
                guessed.visibility = View.GONE
                resetValues()
            }
        }
    }
}