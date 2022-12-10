package br.edu.infnet.venda_veiculos.controller;




import br.edu.infnet.venda_veiculos.dto.VendaDTO;
import br.edu.infnet.venda_veiculos.exceptions.CompradorNaoEncontradoException;
import br.edu.infnet.venda_veiculos.exceptions.VeiculosNaoEncontradosException;
import br.edu.infnet.venda_veiculos.service.VendaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;



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

    @PostMapping
    public ResponseEntity efetuaPedido(@RequestBody VendaDTO vendaDTO) throws VeiculosNaoEncontradosException, CompradorNaoEncontradoException {

        log.info("Efetuando pedido com a informacao: {}", vendaDTO);
        return ResponseEntity.ok(vendaService.efetuarVenda(vendaDTO));
    }

    @GetMapping("/compradores")
    public  ResponseEntity getCompradores(){
        log.info("Obtendo lista de compradores");
        return restTemplate.getForEntity(compradorEndpointUrl, List.class);
    }


}
