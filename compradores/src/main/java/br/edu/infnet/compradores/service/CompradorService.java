package br.edu.infnet.compradores.service;


import br.edu.infnet.compradores.model.domain.Comprador;
import br.edu.infnet.compradores.relatorio.AppImpressao;
import br.edu.infnet.compradores.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;


    public void incluir(Comprador comprador){

        compradorRepository.save(comprador);
        new AppImpressao().relatorio(comprador,"Inclusão do comprador " + comprador.getNome() + "realizada com sucesso!!!");

    }



    public void excluir(Integer id){
        compradorRepository.deleteById(id);
    }


    public Collection<Comprador> obterLista(){
        return (Collection<Comprador>) compradorRepository.findAll();
    }




}
