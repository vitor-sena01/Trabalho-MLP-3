package com.example.aula;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class RegraDeNomeTest{

    @Test 
    void nomeObrigatorioRejeitaNomeVazio(){
        assertThrows(IllegalArgumentException.class, () -> new NomeObrigatorio().validar(""));
    }
    @Test 
    void nomeObrigatorioAceitaNomePreenchido(){
        assertDoesNotThrow(() -> new NomeObrigatorio().validar("Ana"));
    }
    @Test
    void nomeMinimoRejeitaDuasLetras() {
        assertThrows(IllegalArgumentException.class, () -> new NomeMinimo().validar("Al"));
    }
    @Test
    void nomeMinimoAceitaTresLetras() {
        assertDoesNotThrow(() -> new NomeMinimo().validar("Ana"));
    }
    @Test 
    void nomeSemNumerosRejeitaDigitos() {
        assertThrows(IllegalArgumentException.class, () -> new NomeSemNumeros().validar("Ana2"));
    }
    @Test
    void nomeSemNumerosAceitaSoLetras() {
        assertDoesNotThrow(() -> new NomeSemNumeros().validar("Ana Paula"));
    }
}