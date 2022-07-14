package model

import com.marcus.mello.andreahneves_trabalhos.entities.RouteInformation
import entities.Route

interface IRouteRepository {

    fun addNewRoute(route: Route)

    fun updateRoute(route: Route)

    fun getRoutesFromInformation(info: RouteInformation, callback: (routes: List<Route>) -> Unit)

    fun loadRoute(routeId:Long, callback: (route: Route?) -> Unit)

}