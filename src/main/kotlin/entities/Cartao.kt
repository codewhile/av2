package com.marcus.mello.andreahneves_trabalhos.entities

data class Cartao(
    val numero: String,
    val validade: String,
    val codigo: Int,
    val nome: String,
    val cpf: String,
    val cep: String,
    val parcelas: Int
) {

}