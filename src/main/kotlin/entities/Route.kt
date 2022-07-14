package entities

import com.marcus.mello.andreahneves_trabalhos.entities.Companhia
import com.marcus.mello.andreahneves_trabalhos.entities.Bus
import com.marcus.mello.andreahneves_trabalhos.entities.Point

data class Route(
    val id: Long,
    val nome: String,
    val companhia: Companhia,
) {

    lateinit var pontos: List<Point>

    constructor(id:Long, nome: String, companhia: Companhia, pontos: List<Point>) : this(id, nome, companhia) {

        pontos.forEach { ponto ->
            ponto.rota = this
            ponto.vagas = Vaga.generateNewVacancies(*companhia.onibusList.toTypedArray() )
        }

        this.pontos = pontos

    }

    private fun locatePoint(terminal: Terminal): Point? =
        pontos.find { ponto -> ponto.terminal == terminal }

    private fun locateIndexPoint(terminal: Terminal): Int =
        pontos.indexOfFirst { ponto -> ponto.terminal == terminal }

    private fun agruparOnibusPorVagas(path: List<Point>, basePrice: Double)
            : MutableList<Map<Bus, List<Vaga>>> {

        val busGroupList: MutableList<Map<Bus, List<Vaga>>> = mutableListOf()
        path.forEach { ponto ->
            val onibusGroup: Map<Bus, List<Vaga>> = ponto.vagas.groupBy { vaga ->
                vaga.onibus.apply {
                    this.price = this.classe.getFinalPrice(basePrice)
                }
            }
            busGroupList.add(onibusGroup)
        }
        return busGroupList

    }

    fun localizarDoisPontos(embarque: Terminal, desembarque: Terminal): OnlyTwoPoints {

        val t1 = locatePoint(embarque)
        val t2 = locatePoint(desembarque)
        if (t1 != null && t2 != null)
            return OnlyTwoPoints(t1, t2)
        else throw IllegalArgumentException()

    }


    private fun definirTrajeto(embarque: Terminal, desembarque: Terminal): List<Point> {

        val firstIndex = locateIndexPoint(embarque)
        val secondIndex = locateIndexPoint(desembarque)
        if (firstIndex != -1 && secondIndex != -1)
            return pontos.subList(firstIndex, secondIndex)
        else
            throw IllegalArgumentException()

    }

    fun definirPrecoBase(embarque: Terminal, desembarque: Terminal): Double {
        val (p1, p2) = localizarDoisPontos(embarque, desembarque)
        return companhia.precoPorQuilometro * (p2.quilometrosPercorridos - p1.quilometrosPercorridos)
    }


    fun getPriceInformationByBus(embarque: Terminal, desembarque: Terminal):
            MutableList<Map<Bus, List<Vaga>>> {

        val precoBaseDaViagem = definirPrecoBase(embarque, desembarque)
        val trajeto = definirTrajeto(embarque, desembarque)
        return agruparOnibusPorVagas(trajeto, precoBaseDaViagem)

    }


}