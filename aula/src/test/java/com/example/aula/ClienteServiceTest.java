package com.example.aula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;

class ClienteServiceTest{
    private final ClienteRepository repositorio = mock (ClienteRepository.class);
    private final ClienteService servico = new ClienteService(repositorio, List.of(new NomeObrigatorio(), new NomeMinimo()));

    @Test 
    void salvarClienteNovoComoNomeSemEspacos(){
        servico.salvar(null, " Ana");
        ArgumentCaptor<Cliente> captor = ArgumentCaptor.forClass(Cliente.class);
        verify(repositorio).save(captor.capture());
        assertEquals("Ana", captor.getValue().getNome());
    }
    @Test 
    void naoSalvaQuandoONomeEInvalido(){
        assertThrows(IllegalArgumentException.class, () -> servico.salvar(null, ""));
        verify(repositorio, never()).save(ArgumentMatchers.any());
    }
    @Test
    void alteraONomeDeUmClienteExistente() {
        Cliente existente = new Cliente("Ana");
        when(repositorio.findById(1)).thenReturn(Optional.of(existente));
        
        servico.salvar(1, "Ana Paula");
        
        assertEquals("Ana Paula", existente.getNome());
        verify(repositorio).save(existente);
    }
}