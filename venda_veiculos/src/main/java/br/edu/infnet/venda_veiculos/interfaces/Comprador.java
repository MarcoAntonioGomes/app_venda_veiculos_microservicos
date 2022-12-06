package br.edu.infnet.venda_veiculos.interfaces;


import br.edu.infnet.venda_veiculos.dto.CompradorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comprador")
public interface Comprador {

    @RequestMapping(method = RequestMethod.GET, value = "/compradores/{id}")
    ResponseEntity<CompradorDTO> getCompradorById(@PathVariable Integer id);





}
