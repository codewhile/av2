package model

import com.marcus.mello.andreahneves_trabalhos.entities.*
import entities.Route
import entities.Terminal

class RouteRepository :
    IRouteRepository {

    private val routes: MutableList<Route> = mutableListOf()
    private val t1 = Terminal("Terminal A", Municipio("Municipio 1", Estado.RIO_DE_JANEIRO))
    private val t2 = Terminal("Terminal B", Municipio("Municipio 2", Estado.RIO_DE_JANEIRO))
    private val t3 = Terminal("Terminal C", Municipio("Municipio 3", Estado.RIO_DE_JANEIRO))
    private val t4 = Terminal("Terminal D", Municipio("Municipio 4", Estado.RIO_DE_JANEIRO))

    init {

        val route = Route(
            1,
            "Rota Carioca",
            Companhia(1, "Companhia A", 3.75, mutableListOf(Bus(1,Classe.LEITO, 60), Bus(2, Classe.SEMI_EXECUTIVO, 60))),
            listOf(
                Point(t1, 0f),
                Point(t2, 40f),
                Point(t3, 100f),
                Point(t4, 200f)
            )
        )

        addNewRoute(route)

    }


    override fun getRoutesFromInformation(info: RouteInformation, callback: (routes: List<Route>) -> Unit) {

        val routes: MutableList<Route> = mutableListOf()

        routes.forEach { route ->

            try {
                route.localizarDoisPontos(info.origem, info.destino)
                routes.add(route)
            } catch (e: Exception) {
                println("Rota ${route.nome} não possui trajeto")
            }

        }

        callback(routes)

    }

    override fun addNewRoute(route: Route) {
        routes.add(route)
    }

    override fun updateRoute(route: Route) {
        val index = routes.indexOfFirst { r -> r.nome == route.nome }
        routes[index] = route
    }


    override fun loadRoute(routeId: Long, callback: (route: Route?) -> Unit) {
        callback(routes.find { route -> route.id == routeId })
    }

}