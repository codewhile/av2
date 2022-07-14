package com.marcus.mello.andreahneves_trabalhos.entities

enum class Classe(val tax:Double) {

    LEITO(1.45) {
        override fun getFinalPrice(basePrice: Double): Double {
            return tax * basePrice;
        }
    },
    SEMI_EXECUTIVO(1.25) {

        override fun getFinalPrice(basePrice: Double): Double {
            return tax * basePrice;
        }
    },
    EXECUTIVO(1.0) {
        override fun getFinalPrice(basePrice: Double): Double {
            return tax * basePrice;
        }
    };


    abstract fun getFinalPrice(basePrice:Double): Double


}