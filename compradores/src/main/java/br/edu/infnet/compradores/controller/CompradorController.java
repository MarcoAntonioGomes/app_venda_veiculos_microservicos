package br.edu.infnet.compradores.controller;



import br.edu.infnet.compradores.model.domain.Comprador;
import br.edu.infnet.compradores.service.CompradorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/compradores")
public class CompradorController {

    private static Logger log = LoggerFactory.getLogger(CompradorController.class);

    @Autowired
    private CompradorService compradorService;


    @GetMapping(value = "/{id}")
    ResponseEntity<Comprador> getCompradorById(@PathVariable Integer id){
        log.info("Buscando comprador por id: " + id);
        return ResponseEntity.ok(compradorService.obterPorId(id));
    }

    @GetMapping()
    ResponseEntity<List<Comprador>> getCompradorById(){
        return ResponseEntity.ok(compradorService.obterCompradores());
    }

    @GetMapping(value = "/comprador/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        compradorService.excluir(id);
        return "redirect:/comprador/lista";
    }


    @GetMapping(value = "/comprador")
    public String telaCadastro(){
        return "comprador/cadastro";
    }


    @PostMapping(value = "comprador/incluir")
    public String incluir(Comprador comprador){
        compradorService.incluir(comprador);
        return "redirect:/comprador/lista";
    }

}
