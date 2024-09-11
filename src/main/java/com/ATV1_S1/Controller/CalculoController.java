package com.ATV1_S1.Controller;

import com.ATV1_S1.Service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/calculo")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @PostMapping("/soma")
    public ResponseEntity<Double> calcularSoma(@RequestBody List<Double> lista) {
        return ResponseEntity.ok(calculoService.soma(lista));
    }

    @PostMapping("/media")
    public ResponseEntity<Double> calcularMedia(@RequestBody List<Double> lista) {
        return ResponseEntity.ok(calculoService.media(lista));
    }

    @PostMapping("/maiorMenor")
    public ResponseEntity<Double[]> maiorMenorValor(@RequestBody List<Double> lista) {
        return ResponseEntity.ok(calculoService.maiorMenorValor(lista));
    }

    @PostMapping("/repetidos")
    public ResponseEntity<Map<Integer, Integer>> encontrarRepetidos(@RequestBody List<Integer> lista) {
        return ResponseEntity.ok(calculoService.encontrarRepetidos(lista));
    }
}
