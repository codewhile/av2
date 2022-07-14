package view

import com.marcus.mello.andreahneves_trabalhos.entities.Estado
import com.marcus.mello.andreahneves_trabalhos.entities.Municipio
import com.marcus.mello.andreahneves_trabalhos.entities.RouteInformation
import entities.Terminal
import entities.Route
import presenter.RoutePresenter
import model.RouteRepository

class RouteActivity : IRouteView {

    private val presenter: RoutePresenter = RoutePresenter(RouteRepository(), this)
    private val origem = Terminal("Terminal A", Municipio("Municipio 1", Estado.RIO_DE_JANEIRO))
    private val destino = Terminal("Terminal D", Municipio("Municipio 4", Estado.RIO_DE_JANEIRO))


    fun readInformation() {
        val information = RouteInformation(origem, destino)
        routesByInformation(information)
    }

    override fun routesByInformation(information: RouteInformation) {
        presenter.loadRouteByInformation(information)
    }

    override fun showRoutesRelatedToInformation(routes: List<Route>) {

        routes.forEach { route ->

            println("${route.id} ${route.nome} - ${route.companhia}")

            route.pontos.forEach { ponto ->
                println("${ponto.terminal} \n ${ponto.quilometrosPercorridos}")
            }

        }

    }


    fun escolherRota(rotaId:Long) {
        RouteDetailsActivity(rotaId, origem, destino)
    }


    override fun showNotFound() {
        println("Nenhuma rota foi encontrada para os pontos pesquisados")
    }


}