package com.example.aula;
import org.springframework.stereotype.Component;

@Component
public class NomeObrigatorio implements RegraDeNome {
    @Override
    public void validar(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Informe o nome do cliente.");
        }
    }
}