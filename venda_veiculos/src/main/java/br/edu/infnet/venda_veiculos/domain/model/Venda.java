package br.edu.infnet.venda_veiculos.domain.model;



import br.edu.infnet.venda_veiculos.exceptions.CompradorNuloException;
import br.edu.infnet.venda_veiculos.exceptions.VendaSemVeiculosException;
import br.edu.infnet.venda_veiculos.interfaces.IPrinter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "TVenda")
public class Venda implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDateTime data;
    private boolean avista;
    private Integer idComprador;

    @ElementCollection
    private List<Integer> veiculosIds;


    public Venda() {
        this.data =  LocalDateTime.now();
    }

    public Venda(Integer idComprador, List<Integer> veiculosIds) throws CompradorNuloException, VendaSemVeiculosException {

        this();

       if(idComprador == null){
           throw new CompradorNuloException("Impossivel criar um pedido sem um solicitante");
       }


        this.idComprador = idComprador;
        this.veiculosIds = veiculosIds;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public boolean isAvista() {
        return avista;
    }

    public void setAvista(boolean avista) {
        this.avista = avista;
    }


    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public List<Integer> getVeiculosIds() {
        return veiculosIds;
    }

    public void setVeiculosIds(List<Integer> veiculosIds) {
        this.veiculosIds = veiculosIds;
    }

    @Override
    public String toString() {
        return descricao + ";" +data + ";" +avista + ";" + idComprador + ";" + "Quantidade de Veículos: " + veiculosIds.size();
    }

    @Override
    public void impressao() {
        System.out.println("#Venda");
        System.out.println(this);
    }
}
