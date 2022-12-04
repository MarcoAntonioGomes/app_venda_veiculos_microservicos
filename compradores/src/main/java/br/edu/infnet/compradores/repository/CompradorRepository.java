package br.edu.infnet.compradores.repository;


import br.edu.infnet.compradores.model.domain.Comprador;
import org.springframework.data.repository.CrudRepository;



public interface CompradorRepository extends CrudRepository<Comprador, Integer> {

}
