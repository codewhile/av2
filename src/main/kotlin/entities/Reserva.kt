package com.marcus.mello.andreahneves_trabalhos.entities

import entities.Contato
import entities.Terminal
import java.util.*

data class Reserva(
    val origem: Terminal,
    val destino: Terminal,
    val preco: Double,
    val circuito: Boolean = false,
    val passageiros: MutableList<Passageiro> = mutableListOf<Passageiro>(),
    var contato: Contato = Contato("", "", "")
) : Entity() {

}