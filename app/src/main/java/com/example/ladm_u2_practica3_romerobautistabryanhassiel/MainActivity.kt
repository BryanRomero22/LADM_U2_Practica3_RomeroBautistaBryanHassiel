package com.example.ladm_u2_practica3_romerobautistabryanhassiel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dado1 : ImageView ?= null
    var dado2 : ImageView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        comenzar.setOnClickListener {

            puntosJugador1.setText("Puntos: 0")
            puntosJugador2.setText("Puntos: 0")
            puntosJugador3.setText("Puntos: 0")
            puntosJugador4.setText("Puntos: 0")

            estadoJugador4.setText("Estado: Esperando...")

            ganadorJ1.setText("")
            ganadorJ2.setText("")
            ganadorJ3.setText("")
            ganadorJ4.setText("")

            rondas.setText("Ronda 1")

            var hilo = HiloJuego(this)
            hilo.start()
            comenzar.visibility = View.INVISIBLE
        }
    }
}
