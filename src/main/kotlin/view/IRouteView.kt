package view

import com.marcus.mello.andreahneves_trabalhos.entities.RouteInformation
import entities.Route

interface IRouteView {

    fun routesByInformation(information: RouteInformation)
    fun showRoutesRelatedToInformation(routes:List<Route>)
    fun showNotFound()

}