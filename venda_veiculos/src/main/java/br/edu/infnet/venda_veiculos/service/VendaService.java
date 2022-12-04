package br.edu.infnet.venda_veiculos.service;


import br.edu.infnet.venda_veiculos.domain.model.Venda;
import br.edu.infnet.venda_veiculos.dto.CompradorDTO;
import br.edu.infnet.venda_veiculos.dto.VeiculoDTO;
import br.edu.infnet.venda_veiculos.dto.VendaDTO;
import br.edu.infnet.venda_veiculos.exceptions.CompradorNaoEncontradoException;
import br.edu.infnet.venda_veiculos.exceptions.VeiculosNaoEncontradosException;
import br.edu.infnet.venda_veiculos.interfaces.Comprador;
import br.edu.infnet.venda_veiculos.interfaces.Veiculo;
import br.edu.infnet.venda_veiculos.relatorio.AppImpressao;
import br.edu.infnet.venda_veiculos.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class VendaService {

   @Autowired
   private VendaRepository vendaRepository;

   @Autowired
   private Veiculo veiculoService;

   @Autowired
   private Comprador compradorService;

    public  void incluir(Venda venda) {

        vendaRepository.save(venda);

        new AppImpressao().relatorio(venda, "Inclusão da venda " + venda.getDescricao() + " realizada com sucesso!!");
    }

    public void excluir(Integer id){
        vendaRepository.deleteById(id);
    }

    public  Collection<Venda> obterLista(){
        return (Collection<Venda>) vendaRepository.findAll();
    }


    public Venda efetuarVenda(VendaDTO vendaDTO) throws CompradorNaoEncontradoException, VeiculosNaoEncontradosException {

        CompradorDTO compradorDTO = compradorService.getCompradorById(vendaDTO.getIdComprador()).getBody();

        if(Objects.isNull(compradorDTO)){
            throw new CompradorNaoEncontradoException("Não foi efetuar a venda, pois o comprador não foi encontrado");
        }

        List<VeiculoDTO> veiculos = veiculoService.getVeiculosByIds(vendaDTO.getIdsVeiculos()).getBody();

        if(Objects.isNull(veiculos) || veiculos.isEmpty()){
            throw new VeiculosNaoEncontradosException("Não foi efetuar a venda, pois os veículos não foram encontrados");
        }

        Venda venda = new Venda();
        venda.setAvista(vendaDTO.isAvista());
        venda.setDescricao(vendaDTO.getDescricao());
        venda.setIdComprador(vendaDTO.getIdComprador());
        venda.setVeiculosIds(vendaDTO.getIdsVeiculos());
        vendaRepository.save(venda);

        new AppImpressao().relatorio(venda, "Inclusão da venda " + venda.getDescricao() + " realizada com sucesso!!");
        return venda;
    }
}
