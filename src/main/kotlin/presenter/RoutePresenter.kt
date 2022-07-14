package presenter

import com.marcus.mello.andreahneves_trabalhos.entities.RouteInformation
import model.IRouteRepository
import view.IRouteView

class RoutePresenter (
    private val model: IRouteRepository,
    private val view: IRouteView
) {


    fun loadRouteByInformation(information: RouteInformation) {

        model.getRoutesFromInformation(information) { routes ->

            if (routes.isNotEmpty()) {
                view.showRoutesRelatedToInformation(routes)
            }
            else {
                view.showNotFound()
            }

        }

    }



}