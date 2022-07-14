package com.marcus.mello.andreahneves_trabalhos.entities

import entities.Route
import entities.Terminal
import entities.Vaga

class Point(
    var terminal: Terminal,
    var quilometrosPercorridos: Float,
    /*var acesso: Calendar? = null,*/
    var rota: Route? = null
) : Entity() {

    var vagas: MutableList<Vaga> = mutableListOf()
        set(vagas) {
            vagas.forEach { vaga ->
                vaga.ponto = this
            }
            field = vagas
        }


}