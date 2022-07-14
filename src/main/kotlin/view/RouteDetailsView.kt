package view

import com.marcus.mello.andreahneves_trabalhos.entities.Bus
import entities.Vaga

interface RouteDetailsView {

    fun loadRoute(routeId:Long)
    fun showError()
    fun showRoute(route: MutableList<Map<Bus, List<Vaga>>>)


}