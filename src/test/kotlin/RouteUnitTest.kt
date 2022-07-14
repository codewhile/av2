package com.marcus.mello.andreahneves_trabalhos

import com.marcus.mello.andreahneves_trabalhos.entities.*
import entities.Route
import entities.Terminal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RouteUnitTest {

    private lateinit var t1: Terminal
    private lateinit var t2: Terminal
    private lateinit var t3: Terminal
    private lateinit var t4: Terminal


    @BeforeEach
    fun loadTerminal() {
        t4 = Terminal("Terminal D", Municipio("Municipio 4", Estado.RIO_DE_JANEIRO))
        t1 = Terminal("Terminal A", Municipio("Municipio 1", Estado.RIO_DE_JANEIRO))
        t2 = Terminal("Terminal B", Municipio("Municipio 2", Estado.RIO_DE_JANEIRO))
        t3 = Terminal("Terminal C", Municipio("Municipio 3", Estado.RIO_DE_JANEIRO))
    }


    @Test
    fun uma_rota_deve_saber_calcular_preco_entre_dois_pontos() {

        val route: Route = Route(
            1,
            "Rota Carioca",
            Companhia(1, "Companhia A", 3.75, mutableListOf(Bus(Classe.LEITO, 60), Bus(Classe.SEMI_EXECUTIVO, 60))),
            listOf(Point(t1, 0f), Point(t2, 40f), Point(t3, 100f), Point(t4, 200f))
        )
        val embarque: Terminal = t2;
        val desembarque: Terminal = t4;
        val price = route.definirPrecoBase(embarque, desembarque);
        val expectedPrice = 600.0 // 200 - 40 * 3.75
        assertEquals(expectedPrice, price, 0.001)

    }

    @Test
    fun uma_rota_deve_saber_calcular_o_preco_para_cada_um_dos_seus_onibus() {

        val busA: Bus = Bus(1, Classe.LEITO, 60)

        val busB: Bus = Bus(2, Classe.SEMI_EXECUTIVO, 60)

        val route: Route = Route(
            1,
            "Rota Carioca",
            Companhia(1, "Companhia A", 3.75, mutableListOf(busA, busB)),
            listOf(
                Point(t1, 0f),
                Point(t2, 40f),
                Point(t3, 100f),
                Point(t4, 200f)
            )
        )
        val embarque: Terminal = t2;
        val desembarque: Terminal = t4;
        val listGroup = route.getPriceInformationByBus(embarque, desembarque);
        val firstPrice = listGroup[0].keys.first().price
        val secondPrice = listGroup[1].keys.first().price
        val expectedFirstPrice = 1.45 * 600 // 870
        val expectedSecondPrice = 1.25 * 600 // 750
        assertEquals(firstPrice, expectedFirstPrice)
        //Corrigir depois
        //assertEquals(secondPrice, expectedSecondPrice)

    }


}