package com.example.aula;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteController {
    private final ClienteRepository repositorio;

    public ClienteController(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", repositorio.findAll());
        return "clientes";
    }

    @PostMapping("/clientes")
public String salvar(@RequestParam String nome) {
    repositorio.save(new Cliente(nome));
    return "redirect:/clientes";
}

@PostMapping("/clientes/{id}")
public String alterar(@PathVariable Integer id, @RequestParam String nome) {
    Cliente cliente = repositorio.findById(id).orElseThrow();
    cliente.setNome(nome);
    repositorio.save(cliente);
    return "redirect:/clientes";
}

@PostMapping("/clientes/{id}/excluir")
public String excluir(@PathVariable Integer id) {
    repositorio.deleteById(id);
    return "redirect:/clientes";
}

}
