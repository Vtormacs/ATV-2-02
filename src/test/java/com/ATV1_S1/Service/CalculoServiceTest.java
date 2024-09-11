package com.ATV1_S1.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculoServiceTest {

    @Autowired
    CalculoService calculoService;

    List<Double> lista = new ArrayList<>();

    @BeforeEach
    void setuo() {
        this.lista = Arrays.asList(1.0, 2.0, 3.0);
    }

    @Test
    void soma() {
        var retorno = this.calculoService.soma(this.lista);
        assertEquals(6.0, retorno);
        assertEquals(3.0, lista.size());
    }

    @Test
    void media() {
        var retorno = this.calculoService.media(this.lista);
        assertEquals(2.0, retorno);
        assertEquals(3, lista.size());
    }

    @Test
    void maiorMenorValor() {
        var retorno = this.calculoService.maiorMenorValor(this.lista);
        assertArrayEquals(new Double[]{3.0, 1.0}, retorno);
        assertEquals(3, lista.size());
    }

    @Test
    void encontrarRepetidos() {
        List<Integer> lista = Arrays.asList(1, 1, 2, 3, 4, 4);

        Map<Integer, Integer> retorno = calculoService.encontrarRepetidos(lista);

        assertEquals(2, retorno.size());
        assertEquals(2, retorno.get(1));
        assertEquals(2, retorno.get(4));
    }
}
