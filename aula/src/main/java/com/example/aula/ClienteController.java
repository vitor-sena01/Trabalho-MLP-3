package com.example.aula;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ClienteController {
    private final ClienteService servico;

    public ClienteController(ClienteService servico) {
        this.servico = servico;
    }

    @GetMapping("/clientes")
    public String listar(Model model) {
        model.addAttribute("clientes", servico.listar());
        return "clientes";
    }

    @PostMapping("/clientes")
    public String salvar(@RequestParam String nome, RedirectAttributes aviso) {
        return gravar(null, nome, aviso);
    }

    @PostMapping("/clientes/{id}")
    public String alterar(@PathVariable Integer id, @RequestParam String nome, RedirectAttributes aviso) {
        return gravar(id, nome, aviso);
    }

    @PostMapping("/clientes/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        servico.excluir(id);
        return "redirect:/clientes";
    }

    private String gravar(Integer id, String nome, RedirectAttributes aviso) {
        try {
            servico.salvar(id, nome);
        } catch (IllegalArgumentException e) {
            aviso.addFlashAttribute("erro", e.getMessage());
        }
        return "redirect:/clientes";
    }
}




