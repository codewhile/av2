package service

import com.marcus.mello.andreahneves_trabalhos.entities.Cartao

class PayService :
    IPayService {

    override fun pay(cartao: Cartao, preco:Double): Boolean {

        if (cartao.nome.isNotEmpty()) {
            println("Pagando R$ $preco conta com cartão")
            return true
        }

        else return false
    }


}