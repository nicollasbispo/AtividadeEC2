package com.nicollasbispo.calculadora_api;

import com.nicollasbispo.calculadora_api.service.CalculadoraService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    @Test
    @DisplayName("Quando acionado com 10 e 2, deve retornar 5")
    void testDividir() {
        CalculadoraService service = new CalculadoraService();
        double resultado = service.dividir(10, 2);
        assertEquals(5, resultado);
    }

    @Test
    @DisplayName("Quando acionado com 10 e 0, deve lançar exceção")
    void testDividirPorZero() {
        CalculadoraService service = new CalculadoraService();
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class,
                () -> service.dividir(10, 0)
        );
        assertTrue(exception.getMessage().contains("Divisão por zero não permitida"));
    }
}