package com.example.ladm_u2_practica3_romerobautistabryanhassiel

import android.R.attr
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class HiloJuego (p: MainActivity) : Thread() {
    var puntero = p
    var ronda = 1
    var jugador = 1
    var puntosJ1 = 0
    var puntosJ2 = 0
    var puntosJ3 = 0
    var puntosJ4 = 0
    var valorDado1 = 0
    var valorDado2 = 0
    var bandera = true

    override fun run() {
        super.run()

        ronda = 1
        jugador = 1
        puntosJ1 = 0
        puntosJ2 = 0
        puntosJ3 = 0
        puntosJ4 = 0
        valorDado1 = 0
        valorDado2 = 0

        bandera = true
        while(bandera ) {



                sleep(1500)

                puntero.runOnUiThread {
                    if (ronda == 5) {
                        bandera = false
                    }
                    if (bandera) {
                        puntero.rondas.setText("Ronda " + ronda)

                        valorDado1 = (1..6).random()
                        valorDado2 = (1..6).random()

                        when (jugador) {
                            1 -> {
                                puntero.estadoJugador1.setText("Estado: Jugando")
                                puntero.estadoJugador2.setText("Estado: Esperando...")
                                puntero.estadoJugador3.setText("Estado: Esperando...")
                                puntero.estadoJugador4.setText("Estado: Esperando...")
                                puntosJ1 += valorDado1 + valorDado2


                            }

                            2 -> {
                                puntero.estadoJugador1.setText("Estado: Esperando...")
                                puntero.estadoJugador2.setText("Estado: Jugando")
                                puntero.estadoJugador3.setText("Estado: Esperando...")
                                puntero.estadoJugador4.setText("Estado: Esperando...")
                                puntosJ2 += valorDado1 + valorDado2


                            }


                            3 -> {
                                puntero.estadoJugador1.setText("Estado: Esperando...")
                                puntero.estadoJugador2.setText("Estado: Esperando...")
                                puntero.estadoJugador3.setText("Estado: Jugando")
                                puntero.estadoJugador4.setText("Estado: Esperando...")
                                puntosJ3 += valorDado1 + valorDado2

                            }

                            4 -> {
                                puntero.estadoJugador1.setText("Estado: Esperando...")
                                puntero.estadoJugador2.setText("Estado: Esperando...")
                                puntero.estadoJugador3.setText("Estado: Esperando...")
                                puntero.estadoJugador4.setText("Estado: Jugando")
                                puntosJ4 += valorDado1 + valorDado2

                            }


                        }

                        sleep(1500)
                        mostrarImagen(valorDado1, puntero.img1)
                        mostrarImagen(valorDado2, puntero.img2)

                        when (jugador) {
                            1 -> {
                                puntero.puntosJugador1.setText("Puntos: " + puntosJ1)
                            }

                            2 -> {
                                puntero.puntosJugador2.setText("Puntos: " + puntosJ2)
                            }

                            3 -> {
                                puntero.puntosJugador3.setText("Puntos: " + puntosJ3)
                            }


                            4 -> {
                                puntero.puntosJugador4.setText("Puntos: " + puntosJ4)
                            }
                        }

                        jugador++

                        if (jugador == 5) {
                            ronda++
                            jugador = 1

                        }

                    }
                }
        }

        puntero.runOnUiThread{
            mostrarGanador()
        }

        }

    fun mostrarImagen(valor : Int, img : ImageView) {
        when(valor){
            1 -> {
                img?.setImageResource(R.drawable.dadosuno)
            }
            2 -> {
                img?.setImageResource(R.drawable.dadodos)
            }
            3 -> {
                img?.setImageResource(R.drawable.dadostres)
            }
            4 -> {
                img?.setImageResource(R.drawable.dadocuatro)
            }

            5 -> {
                img?.setImageResource(R.drawable.dadocinco)

            }
            6 -> {

                img?.setImageResource(R.drawable.dadoseis)
            }

        }

    }

    fun mostrarGanador() {
        var arreglo = arrayOf(puntosJ1, puntosJ2, puntosJ3, puntosJ4)


        (0..3).forEach {x->
            (0..2).forEach {y->
                var elementoActual = arreglo[y]
                var elementoSiguiente = arreglo[y+1]
                if (elementoActual > elementoSiguiente) {
                    arreglo[y] = elementoSiguiente
                    arreglo[y+1] = elementoActual
                }
            }
        }

        if(puntosJ1 == arreglo[3]){
            puntero.ganadorJ1.setText("GANADOR")
        } else if(puntosJ2 == arreglo[3]){
            puntero.ganadorJ2.setText("GANADOR")
        } else if(puntosJ3 == arreglo[3]){
            puntero.ganadorJ3.setText("GANADOR")
        }else if(puntosJ4 == arreglo[3]){
            puntero.ganadorJ4.setText("GANADOR")
        }


        puntero.comenzar.visibility = View.VISIBLE
    }

    }

