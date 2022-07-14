package service

import com.marcus.mello.andreahneves_trabalhos.entities.Cartao

interface IPayService {

    fun pay(cartao:Cartao, preco:Double) : Boolean

}