package br.edu.infnet.veiculos.controller;



import br.edu.infnet.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class VeiculoController {


    @Autowired
    private VeiculoService veiculoService;



    @GetMapping(value = "/veiculo/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        veiculoService.excluir(id);
        return "redirect:/veiculo/lista";
    }



}
