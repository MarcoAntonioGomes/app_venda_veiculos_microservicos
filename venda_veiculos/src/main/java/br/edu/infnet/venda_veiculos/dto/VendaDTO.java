package br.edu.infnet.venda_veiculos.dto;

import java.io.Serializable;
import java.util.List;

public class VendaDTO implements Serializable {

    private String descricao;
    private boolean avista;
    private Integer idComprador;
    private List<Integer> idsVeiculos;

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

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public List<Integer> getIdsVeiculos() {
        return idsVeiculos;
    }

    public void setIdsVeiculos(List<Integer> idsVeiculos) {
        this.idsVeiculos = idsVeiculos;
    }
}
