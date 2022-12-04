package br.edu.infnet.venda_veiculos.interfaces;


import br.edu.infnet.venda_veiculos.dto.CompradorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "comprador")
public interface Comprador {

    @RequestMapping("/compradores")
    ResponseEntity<CompradorDTO> getCompradorById(Integer id);





}
