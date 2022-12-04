package br.edu.infnet.venda_veiculos.service;


import br.edu.infnet.venda_veiculos.domain.model.Venda;
import br.edu.infnet.venda_veiculos.relatorio.AppImpressao;
import br.edu.infnet.venda_veiculos.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendaService {

   @Autowired
   private VendaRepository vendaRepository;

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


}
