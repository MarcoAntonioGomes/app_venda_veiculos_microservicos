package br.edu.infnet.compradores.model.domain;


import br.edu.infnet.compradores.exceptions.CpfInvalidoException;
import br.edu.infnet.compradores.interfaces.IPrinter;

import javax.persistence.*;

@Entity
@Table(name = "TComprador")
public class Comprador implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private  String cpf;
    private  String email;


    public Comprador() {
    }

    public Comprador(String nome, String cpf, String email) throws CpfInvalidoException {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;

        if(cpf == null){
            throw new CpfInvalidoException("Não é possível aceitar CPF nulo");
        }
        if(cpf.isEmpty()){
            throw new CpfInvalidoException("Não é possível aceitar CPF sem preenchimento");
        }

    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + email;
    }

    @Override
    public void impressao() {
        System.out.println("#Comprador");
        System.out.println(this);
    }
}
