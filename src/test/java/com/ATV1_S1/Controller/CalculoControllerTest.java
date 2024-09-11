package com.ATV1_S1.Controller;

import com.ATV1_S1.Service.CalculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculoControllerTest {

    @Autowired
    CalculoController calculoController;

    List<Double> lista;
    List<Integer> listaInteiros;

    @BeforeEach
    void setup() {
        this.lista = Arrays.asList(1.0, 2.0, 3.0);
        this.listaInteiros = Arrays.asList(1, 1, 2, 3, 4, 4);
    }

    @Test
    void calcularSoma() {
        ResponseEntity<Double> retorno = calculoController.calcularSoma(this.lista);
        assertEquals(HttpStatus.OK, retorno.getStatusCode());
        assertEquals(6.0, retorno.getBody());
    }

    @Test
    void calcularMedia() {
        ResponseEntity<Double> retorno = calculoController.calcularMedia(this.lista);
        assertEquals(HttpStatus.OK, retorno.getStatusCode());
        assertEquals(2.0, retorno.getBody());
    }

    @Test
    void maiorMenorValor() {
        ResponseEntity<Double[]> retorno = calculoController.maiorMenorValor(this.lista);
        assertEquals(HttpStatus.OK, retorno.getStatusCode());

        Double[] esperado = {3.0, 1.0};
        assertArrayEquals(esperado, retorno.getBody());
    }

    @Test
    void encontrarRepetidos() {
        ResponseEntity<Map<Integer, Integer>> retorno = calculoController.encontrarRepetidos(this.listaInteiros);
        assertEquals(HttpStatus.OK, retorno.getStatusCode());

        Map<Integer, Integer> esperado = new HashMap<>();
        esperado.put(1, 2);
        esperado.put(4, 2);

        assertEquals(esperado, retorno.getBody());
    }
}
