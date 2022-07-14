package model

import com.marcus.mello.andreahneves_trabalhos.entities.Passageiro
import com.marcus.mello.andreahneves_trabalhos.entities.Reserva

class ReservaRepository : IReservaRepository {

    private val reservas:MutableList<Reserva> = mutableListOf()

    override fun adicionarReserva(reserva: Reserva, callback: (reservas: List<Reserva>?) -> Unit) {
        reservas.add(reserva)
    }

    override fun removerReserva(reserva: Reserva) {
        reservas.remove(reserva)
    }

    override fun atualizarReserva(reservaId: Long, vararg passageiro: Passageiro): Reserva? {
        TODO("Not yet implemented")
    }

    override fun getAllReservesByRg(rg: String, callback: (reserve: List<Reserva>?) -> Unit) {
        TODO("Not yet implemented")
    }


}