package br.edu.infnet.venda_veiculos.repository;


import br.edu.infnet.venda_veiculos.domain.model.Venda;
import org.springframework.data.repository.CrudRepository;

public interface VendaRepository extends CrudRepository<Venda, Integer> {

}
