package com.example.aula;
import org.springframework.stereotype.Component;

@Component
public class NomeSemNumeros implements RegraDeNome {
    @Override
    public void validar(String nome) {
        if (nome.matches(".*\\d.*")) {
            throw new IllegalArgumentException("O nome não pode ter números.");
        }
    }
}