package view

import com.marcus.mello.andreahneves_trabalhos.entities.Cartao
import com.marcus.mello.andreahneves_trabalhos.entities.Passageiro
import com.marcus.mello.andreahneves_trabalhos.entities.Reserva
import entities.Contato
import presenter.ReservaPresenter
import model.ReservaRepository
import service.PayService

class ReservaActivity(private val reserva: Reserva) : ReservaView {


    private val presenter = ReservaPresenter(
        "111.111.111-11",
        this,
        ReservaRepository(),
        PayService()
    )

    private val reservasList = mutableListOf<Reserva>()

    val contactReaded = Contato("111.111.111-11", "email@gmail.com", "(21) 9 9999-9999")

    val cartaoReaded =
        Cartao(
            "5335 0637 5274 1382",
            "13/02/2022",
            851,
            "Vitor Cordeiro",
            "111.111.111-11",
            "50830-590",
            12
        )

    val passageirosReaded = mutableListOf(
        Passageiro("Vitor Cordeiro", "21-111-111-1"),
        Passageiro("André Neves", "21-341-131-4"),
        Passageiro("Isabel Santos", "24-999-223-1")
    )

    init {
        doReserve(reserva)
    }

    override fun doReserve(reserva: Reserva) {

        reserva.contato = contactReaded
        reserva.passageiros.addAll(passageirosReaded)
        presenter.doReserve(reserva, this.cartaoReaded)

    }

    override fun operationFailed(message: String) {
        println(message)
    }

    override fun loadAllReserves(reservas: List<Reserva>) {
        this.reservasList.clear()
        this.reservasList.addAll(reservas)
        showReserves(reservas)
    }

    private fun showReserves(reservas: List<Reserva>) {
        reservas.forEach { reserva ->
            println(reserva)
        }
    }

    override fun loadNewReserve(reserva: Reserva) {
        this.reservasList.add(reserva)
        showReserves(this.reservasList)
    }


}