package com.ATV1_S1.Service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculoService {

    public Double soma(List<Double> lista) {
        return lista.stream().mapToDouble(Double::doubleValue).sum();
    }

    public Double media(List<Double> lista) {
        return lista.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public Double[] maiorMenorValor(List<Double> lista) {
        Double maximo = lista.stream().mapToDouble(Double::doubleValue).max().orElseThrow();
        Double minimo = lista.stream().mapToDouble(Double::doubleValue).min().orElseThrow();
        return new Double[]{maximo, minimo};
    }

    public Map<Integer, Integer> encontrarRepetidos(List<Integer> lista) {
        Map<Integer, Integer> contador = new HashMap<>();

        for (Integer num : lista) {
            contador.put(num, contador.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> repetidos = new HashMap<>();
        for (Map.Entry<Integer, Integer> entrada : contador.entrySet()) {
            if (entrada.getValue() > 1) {
                repetidos.put(entrada.getKey(), entrada.getValue());
            }
        }
        return repetidos;
    }
}
