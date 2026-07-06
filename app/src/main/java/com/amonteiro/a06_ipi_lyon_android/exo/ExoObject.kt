package com.amonteiro.a06_ipi_lyon_android.exo

fun main(args: Array<String>) {
    var car = CarEntity("Seat", "Leon")
    var car2 = CarEntity("Seat", "Leon")
var car3 = car2
    car.color = "Grise"

    println(car.print())
    println("C'est une ${car.marque} ${car.model} de couleur ${car.color}")

    println(car === car2)
    println(car2 === car3)

}

class RandomName{

    private  val list = arrayListOf("Bob", "Toto", "Titi")
    private var oldName =""

    fun add(name:String){
        if(name.isNotBlank() && name !in list){
            list.add(name)
        }
    }

    fun addAll(vararg nameList : String){
        for(name in nameList) {
            add(name)
        }
    }

    fun next() = list.random()

    fun nextDiff(): String {
        var nextName = next()
        while(nextName == oldName) {
            nextName = next()
        }
        oldName = nextName
        return nextName
    }

    fun nextDiffV2(): String {
        oldName = list.filter { it != oldName }.random()
        return oldName
    }

    fun next2() = Pair(nextDiff(), nextDiff())
}

data class CarEntity(var marque : String = "", var model : String) {
    var color = ""


    fun print() = "C'est une $marque $model de couleur $color"
}