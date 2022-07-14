package com.marcus.mello.andreahneves_trabalhos.entities

data class Bus(
    val id:Long,
    val classe: Classe,
    val assentos: Int,
    var companhia: Companhia? = null
    ) {

    var price: Double = 0.0

    }
