package br.edu.infnet.venda_veiculos.controller;



import br.edu.infnet.venda_veiculos.domain.model.Venda;
import br.edu.infnet.venda_veiculos.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class VendaController {


    @Autowired
    private VendaService vendaService;



    @GetMapping(value = "/venda/{id}/excluir")
    public String exclusao(@PathVariable Integer id){

        vendaService.excluir(id);
        return "redirect:/venda/lista";
    }

    @PostMapping(value = "/venda/incluir")
    public String incluir(Venda venda){

        vendaService.incluir(venda);

        return "redirect:/venda/lista";
    }

}
