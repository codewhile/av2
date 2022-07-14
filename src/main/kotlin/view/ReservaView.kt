package view

import com.marcus.mello.andreahneves_trabalhos.entities.Reserva

interface ReservaView {

    fun doReserve(reserva:Reserva)

    fun operationFailed(s: String)

    fun loadAllReserves(reservas: List<Reserva>)

    fun loadNewReserve(reserva: Reserva)

}