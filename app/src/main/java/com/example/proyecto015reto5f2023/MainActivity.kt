package com.example.proyecto015reto5f2023

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var tv2: TextView
    private lateinit var et1: EditText
    private lateinit var boton1: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv2 = findViewById(R.id.tv2)
        et1 = findViewById(R.id.et1)
        boton1 = findViewById(R.id.boton1)

        sharedPreferences = getSharedPreferences("Puntaje", Context.MODE_PRIVATE)
        tv2.text = "Puntaje: ${sharedPreferences.getInt("puntaje", 0)}"

        val numeroAleatorio = Random.nextInt(50) + 1

        boton1.setOnClickListener {
            val respuesta = et1.text.toString().toInt()

            if (respuesta == numeroAleatorio) {
                Toast.makeText(this, "¡Felicidades! Adivinaste el número.", Toast.LENGTH_SHORT).show()
                val editor = sharedPreferences.edit()
                editor.putInt("puntaje", sharedPreferences.getInt("puntaje", 0) + 1)
                editor.apply()
            } else if (respuesta < numeroAleatorio) {
                Toast.makeText(this, "El número es mayor que $respuesta.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "El número es menor que $respuesta.", Toast.LENGTH_SHORT).show()
            }

            tv2.text = "Puntaje: ${sharedPreferences.getInt("puntaje", 0)}"
        }
    }
}
