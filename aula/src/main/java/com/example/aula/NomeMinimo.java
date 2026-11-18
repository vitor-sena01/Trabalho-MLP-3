package com.example.aula;
import org.springframework.stereotype.Component;

@Component
public class NomeMinimo implements RegraDeNome {
    @Override
    public void validar(String nome) {
        if (!nome.isBlank() && nome.length() < 3) {
            throw new IllegalArgumentException("O nome precisa ter pelo menos 3 letras.");
        }
    }
}