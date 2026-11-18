package com.example.aula;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repositorio;
    private final List<RegraDeNome> regras;

    public ClienteService(ClienteRepository repositorio, List<RegraDeNome> regras) {
        this.repositorio = repositorio;
        this.regras = regras;
    }

    public List<Cliente> listar() {
        return repositorio.findAll();
    }

    public Cliente salvar(Integer id, String nome) {
        String limpo = nome == null ? "" : nome.trim();
        regras.forEach(regra -> regra.validar(limpo));
        
        if (id == null) {
            return repositorio.save(new Cliente(limpo));
        }
        
        Cliente cliente = repositorio.findById(id).orElseThrow();
        cliente.setNome(limpo);
        return repositorio.save(cliente);
    }

    public void excluir(Integer id) {
        repositorio.deleteById(id);
    }
}