package entities

import com.marcus.mello.andreahneves_trabalhos.entities.Bus
import com.marcus.mello.andreahneves_trabalhos.entities.Point

data class Vaga(
    var posicao: Int = 0,
    var disponivel: Boolean = true,
    var onibus: Bus,
    var ponto: Point? = null
) {


    companion object {

        fun generateNewVacancies(vararg onibus: Bus): MutableList<Vaga> {

            val vagas = mutableListOf<Vaga>()

            onibus.forEach { bus ->
                for (position in 1..bus.assentos) {
                    vagas.add(Vaga(position, true,  bus))
                }
            }

            return vagas

        }
    }

}