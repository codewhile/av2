package presenter

import entities.Terminal
import model.RouteRepository
import view.RouteDetailsView

class RouteDetailsPresenter(
    private val routeId:Long,
    private val view: RouteDetailsView,
    private val model: RouteRepository
    )  {

    fun loadRoute(routeId:Long, embarque: Terminal, desembarque: Terminal) {
        model.loadRoute(routeId) { route ->

            if (route != null) {
                view.showRoute(route.getPriceInformationByBus(embarque, desembarque))
            }

        }

    }

}