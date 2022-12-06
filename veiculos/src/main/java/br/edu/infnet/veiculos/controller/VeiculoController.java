package br.edu.infnet.veiculos.controller;



import br.edu.infnet.veiculos.model.domain.Veiculo;
import br.edu.infnet.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/veiculos")
public class VeiculoController {


    @Autowired
    private VeiculoService veiculoService;



    @GetMapping(value = "/veiculo/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        veiculoService.excluir(id);
        return "redirect:/veiculo/lista";
    }

    @GetMapping("/all/by/ids")
    ResponseEntity<List<Veiculo>> getVeiculosByIds(@RequestParam List<Integer> ids){
        return ResponseEntity.ok(veiculoService.obterPorIds(ids));
    }


}
