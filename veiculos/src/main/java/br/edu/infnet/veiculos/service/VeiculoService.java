package br.edu.infnet.veiculos.service;



import br.edu.infnet.veiculos.model.domain.Veiculo;
import br.edu.infnet.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    public List<Veiculo> obterLista(){
        return (List<Veiculo>) veiculoRepository.findAll();
    }


    public void excluir(Integer id){
        veiculoRepository.deleteById(id);
    }
}
