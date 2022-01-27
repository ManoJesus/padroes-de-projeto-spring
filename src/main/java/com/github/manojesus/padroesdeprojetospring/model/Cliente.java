package com.github.manojesus.padroesdeprojetospring.model;


import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Endereco endereco;

    public Cliente() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String id) {
        this.cpf = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
