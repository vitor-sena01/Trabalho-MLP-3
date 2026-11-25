package com.example.aula;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest 
@Transactional 
class ClienteRepositoryTest{
    @Autowired 
    private ClienteRepository repositorio;

    @Test 
    void salvaEListaOCliente(){
        Cliente salvo = repositorio.save(new Cliente("Cliente de Teste"));

        assertNotNull(salvo.getId());
        assertTrue(repositorio.findAll().stream().anyMatch(c -> c.getNome().equals("Cliente de Teste")));
    }

    @Test 
    void excluirOCliente(){
        Cliente salvo = repositorio.save(new Cliente("Cliente de Teste"));

        repositorio.deleteById(salvo.getId());

        assertTrue(repositorio.findAll().stream().noneMatch(c -> c.getNome().equals("Cliente de Teste")));
    }
}