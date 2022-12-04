package br.edu.infnet.venda_veiculos.controller;




import br.edu.infnet.venda_veiculos.dto.VendaDTO;
import br.edu.infnet.venda_veiculos.exceptions.CompradorNaoEncontradoException;
import br.edu.infnet.venda_veiculos.exceptions.VeiculosNaoEncontradosException;
import br.edu.infnet.venda_veiculos.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vendas")
public class VendaController {


    @Autowired
    private VendaService vendaService;



    @PostMapping
    public ResponseEntity efetuaPedido(@RequestBody VendaDTO vendaDTO) throws VeiculosNaoEncontradosException, CompradorNaoEncontradoException {
       return ResponseEntity.ok(vendaService.efetuarVenda(vendaDTO));
    }

}
