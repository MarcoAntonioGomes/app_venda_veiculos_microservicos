package br.edu.infnet.venda_veiculos.interfaces;

import br.edu.infnet.venda_veiculos.dto.VeiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "veiculo")
public interface Veiculo {

    @RequestMapping(method = RequestMethod.GET, value = "/veiculos/all/by/ids")
    ResponseEntity<List<VeiculoDTO>> getVeiculosByIds(@RequestParam List<Integer> ids);

}
