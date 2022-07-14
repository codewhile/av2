package com.marcus.mello.andreahneves_trabalhos

import com.marcus.mello.andreahneves_trabalhos.entities.Estado
import com.marcus.mello.andreahneves_trabalhos.entities.Municipio
import com.marcus.mello.andreahneves_trabalhos.entities.RouteInformation
import entities.Terminal
import model.RouteRepository
import org.junit.jupiter.api.Test
import presenter.RoutePresenter
import view.RouteActivity

class RouteActivityUnitTest {

    private val presenter: RoutePresenter = RoutePresenter(RouteRepository(), this)


    @Test
    fun deve_receber_informações_de_acordo_com_o_embarque_e_desembarque() {

        val info = RouteInformation(Terminal("Terminal A", Municipio("Municipio 1", Estado.RIO_DE_JANEIRO)), Terminal("Terminal D", Municipio("Municipio 4", Estado.RIO_DE_JANEIRO)))
        val rotaActivity = RouteActivity()
        rotaActivity.routesByInformation(info)


    }

}