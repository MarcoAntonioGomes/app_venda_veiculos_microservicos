package br.edu.infnet.compradores.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.compradores.model.domain.Comprador;
import br.edu.infnet.compradores.service.CompradorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/compradores")
public class CompradorController {

    private static Logger log = LoggerFactory.getLogger(CompradorController.class);

    @Autowired
    private CompradorService compradorService;

    @ApiOperation(value = "Serviço responsável por recuperar comprador pelo identificador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Comprador recuperado com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping(value = "/{id}", produces="application/json")
    ResponseEntity<Comprador> getCompradorById(@PathVariable Integer id){
        log.info("Buscando comprador por id: " + id);
        return ResponseEntity.ok(compradorService.obterPorId(id));
    }
    @ApiOperation(value = "Serviço responsável por listar todos os compradores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Compradores recuperado com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping(produces="application/json")
    ResponseEntity<List<Comprador>> getCompradorById(){
        return ResponseEntity.ok(compradorService.obterCompradores());
    }
    
    @ApiOperation(value = "Serviço responsável por excluir comprador pelo identificador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Comprador excluído com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping(value = "/comprador/{id}/excluir", produces="application/json", consumes="application/json")
    public String excluir(@PathVariable Integer id){
        compradorService.excluir(id);
        return "redirect:/comprador/lista";
    }

    @ApiOperation(value = "Serviço responsável por redirecionar para tela de cadastro do comprador")
   	@ApiResponses(value = { @ApiResponse(code = 200, message = "Redirectcom sucesso!"),
   			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping(value = "/comprador")
    public String telaCadastro(){
        return "comprador/cadastro";
    }

    @ApiOperation(value = "Serviço responsável por cadastrar o comprador")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cadastro com sucesso"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @PostMapping(value = "comprador/incluir", produces="application/json", consumes="application/json")
    public String incluir(Comprador comprador){
        compradorService.incluir(comprador);
        return "redirect:/comprador/lista";
    }

}
