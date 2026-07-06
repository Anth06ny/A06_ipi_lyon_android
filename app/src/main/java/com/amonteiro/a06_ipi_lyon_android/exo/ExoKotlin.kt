package com.amonteiro.a06_ipi_lyon_android.exo

import kotlin.random.Random

fun main() {
    println("Coucou")

    var v1 : String ="toto"
    println(v1.uppercase())

    var v2 : String? ="toto"
    println(v2?.uppercase())

    var v3 : String? = null
    println(v3?.uppercase())


    var v4 : Int? = null
//Laisser le curseur de la souris sur Random pour qu'il vous propose de l'importer
//Choisir celui de Koltin
    if(Random.nextBoolean()){
        v4 = Random.nextInt(10)
    }
    println(v4 ?: "Pas de valeur")

    println(boulangerie())
    println(boulangerie(1,2,3))
    println(boulangerie(nbBag = 5, nbSand = 4))
}

fun boulangerie(nbCrois : Int = 0, nbBag:Int =0, nbSand:Int =0): Double
    = nbCrois * PRICE_CROISSANT + nbBag * PRICE_BAGUETTE + nbSand * PRICE_SANDWITCH
