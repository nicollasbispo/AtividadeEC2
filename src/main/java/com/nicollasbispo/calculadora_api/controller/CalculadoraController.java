package com.nicollasbispo.calculadora_api.controller;

import com.nicollasbispo.calculadora_api.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @PostMapping("/divisao/{a}/{b}")
    public ResponseEntity<Double> divisao(
            @PathVariable double a,
            @PathVariable double b
    ) {
        double resultado = calculadoraService.dividir(a, b);
        return ResponseEntity.ok(resultado);
    }
}