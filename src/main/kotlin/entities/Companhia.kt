package com.marcus.mello.andreahneves_trabalhos.entities

class Companhia(val id: Long = 0,
                val nome: String,
                val precoPorQuilometro:Double
                )
{

    lateinit var onibusList: List<Bus>

    constructor(id:Long, nome:String, precoPorQuilometro:Double, onibusList: MutableList<Bus>)
            : this(id, nome, precoPorQuilometro) {

        onibusList.forEach { onibus ->
            onibus.companhia = this
        }

        this.onibusList = onibusList

    }
}