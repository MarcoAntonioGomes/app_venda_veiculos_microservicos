package br.edu.infnet.venda_veiculos.interfaces;

import br.edu.infnet.venda_veiculos.dto.VeiculoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "veiculo")
public interface Veiculo {

    @RequestMapping("/veiculos/all/by/ids")
    ResponseEntity<List<VeiculoDTO>> getVeiculosByIds(List<Integer> ids);

}
