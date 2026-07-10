package com.amonteiro.a06_ipi_lyon_android.exo

import com.amonteiro.a06_ipi_lyon_android.data.remote.WindDTO

class MyLiveData(value : WindDTO, var action : (WindDTO)->Unit) {
    var value : WindDTO = value
        set(newValue) {
            field = newValue
            action(newValue)
        }
}

fun main() {
    //exo1()

    var toto = MyLiveData(WindDTO(5.0)){
        println(it.speed)
    }

    toto.value = WindDTO(6.0)
    toto.value.speed = 7.0

}



fun exo1() {
    //Déclaration
    val lower: (String) -> Unit = { it: String -> println(it.uppercase()) }
    val lower2 = { it: String -> println(it) }
    val lower3: (String) -> Unit = { it -> println(it) }
    val lower4: (String) -> Unit = { println(it) }

    lower("coucou")

    val hour: (Int) -> Int = { it / 60 }
    println(hour(122))

    val max = { a: Int, b: Int -> Math.max(a, b) }
    val reverse: (String) -> String = { it.reversed() }

    var minToMinHour :((Int?)-> Pair<Int, Int>?)? = { if(it!=null) Pair(it/60, it%60) else null}

    println(minToMinHour?.invoke(123))
    println( minToMinHour?.invoke(null))
    minToMinHour = null
}