package view

import com.marcus.mello.andreahneves_trabalhos.entities.Bus
import com.marcus.mello.andreahneves_trabalhos.entities.Reserva
import entities.Terminal
import entities.Vaga

class RouteDetailsActivity(

    private val routeId: Long,
    private val embarque: Terminal,
    private val desembarque: Terminal

) : RouteDetailsView {


    private var onibusInfoListMap: MutableList<Map<Bus, List<Vaga>>>? = null
    private var busPrice: Double = 0.0

    override fun loadRoute(routeId: Long) {
        TODO("Not yet implemented")
    }

    override fun showError() {
        TODO("Not yet implemented")
    }

    override fun showRoute(onibusInfoListMap: MutableList<Map<Bus, List<Vaga>>>) {

        this.onibusInfoListMap = onibusInfoListMap

        onibusInfoListMap.forEach { busMap ->
            busMap.keys.forEach { bus ->
                println("${bus.companhia?.nome} - ${bus.price}")
            }
        }
    }

    fun reservarVagas() {

        val reserva = Reserva(embarque, desembarque, this.busPrice, false)
        ReservaActivity(reserva)

    }



    fun escolherVagas(busId: Long, vararg vagasPretendidas: Vaga): List<Vaga> {

        val busList = onibusInfoListMap!!.flatMap { onibusInfoListMap -> onibusInfoListMap.keys }
        val bus: Bus? = locateBusById(busId, busList)
        this.busPrice = bus?.price!!
        val vagas = obterVagasDoTrajeto(bus!!, onibusInfoListMap!!)
        return obterArrayDeVagasReservadas(vagas, vagasPretendidas)


    }

    private fun obterArrayDeVagasReservadas(vagas: List<Vaga>, vagasPretendidas: Array<out Vaga>) : List<Vaga> {

        val reservadas = mutableListOf<Vaga>()

        for (vaga in vagas) {
            for (pretendida in vagasPretendidas) {
                if (vaga.posicao == pretendida.posicao && vaga.disponivel) {
                    reservadas.add(vaga.apply { this.disponivel = false })
                    break
                }
            }
        }

        return reservadas

    }

    private fun obterVagasDoTrajeto(bus: Bus, onibusInfoListMap: MutableList<Map<Bus, List<Vaga>>>): List<Vaga> {

        onibusInfoListMap.forEach { busMap ->

            val vagas = busMap[bus]

            if (vagas != null) {
                return vagas
            }

        }

        return emptyList()

    }


    private fun locateBusById(busId: Long, busList: List<Bus>): Bus? = busList.find { bus -> bus.id == busId }


}