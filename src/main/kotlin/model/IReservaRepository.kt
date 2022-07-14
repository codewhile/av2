package model

import com.marcus.mello.andreahneves_trabalhos.entities.Passageiro
import com.marcus.mello.andreahneves_trabalhos.entities.Reserva
import com.sun.org.apache.xpath.internal.operations.Bool

interface IReservaRepository {

    fun adicionarReserva(reserva:Reserva, callback: (reservas:List<Reserva>?) -> Unit)
    fun removerReserva(reserva: Reserva)
    fun atualizarReserva(reservaId: Long, vararg passageiro: Passageiro): Reserva?
    fun getAllReservesByRg(rg: String, callback: (reserve: List<Reserva>?) -> Unit)

}