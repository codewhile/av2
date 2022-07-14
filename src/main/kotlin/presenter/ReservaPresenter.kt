package presenter

import com.marcus.mello.andreahneves_trabalhos.entities.Cartao
import com.marcus.mello.andreahneves_trabalhos.entities.Reserva
import service.IPayService
import model.IReservaRepository
import view.ReservaView

class ReservaPresenter(
    private val cpf:String,
    private val view: ReservaView,
    private val model: IReservaRepository,
    private val service: IPayService
) {

    fun getAllReserves() {

        model.getAllReservesByRg(cpf) { reservas ->
            if (reservas != null)
                view.loadAllReserves(reservas)
            else
                view.operationFailed("O CPF $cpf não foi utilizado para comprar passagem alguma")

        }
    }

    fun doReserve(reserve: Reserva, cartao:Cartao) {

        if (service.pay(cartao)) {

            model.adicionarReserva(reserve) { reservas ->

                if (reservas != null)
                    view.loadAllReserves(reservas)
                else
                    view.operationFailed("Não foi possível adicionar reserva")

            }

        }
        else {
            view.operationFailed("Cartão inválido")
        }

    }

}