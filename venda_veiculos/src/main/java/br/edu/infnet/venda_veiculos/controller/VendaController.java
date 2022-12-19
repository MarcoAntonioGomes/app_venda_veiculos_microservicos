package br.edu.infnet.venda_veiculos.controller;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.venda_veiculos.domain.model.Venda;
import br.edu.infnet.venda_veiculos.dto.VendaDTO;
import br.edu.infnet.venda_veiculos.exceptions.CompradorNaoEncontradoException;
import br.edu.infnet.venda_veiculos.exceptions.VeiculosNaoEncontradosException;
import br.edu.infnet.venda_veiculos.service.VendaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/vendas")
public class VendaController {

    private static Logger log = LoggerFactory.getLogger(VendaController.class);

    @Autowired
    private VendaService vendaService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${comprador.endpoint.url}")
    private String compradorEndpointUrl;
    
    @ApiOperation(value = "Serviço responsável por efetuar o pedido de compra de veículo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido efetuado com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @PostMapping(produces="application/json", consumes="application/json")
    public ResponseEntity<Venda> efetuaPedido(@RequestBody VendaDTO vendaDTO) throws VeiculosNaoEncontradosException, CompradorNaoEncontradoException {

        log.info("Efetuando pedido com a informacao: {}", vendaDTO);
        return ResponseEntity.ok(vendaService.efetuarVenda(vendaDTO));
    }
    
    @ApiOperation(value = "Serviço responsável por listar todos os compradores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Compradores recuperado com sucesso!"),
			@ApiResponse(code = 404, message = "Serviço indisponível!") })
    @GetMapping(value="/compradores", produces="application/json")
    public  ResponseEntity<List> getCompradores(){
        log.info("Obtendo lista de compradores");
        return restTemplate.getForEntity(compradorEndpointUrl, List.class);
    }


}
