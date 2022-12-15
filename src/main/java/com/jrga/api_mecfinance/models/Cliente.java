package com.jrga.api_mecfinance.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="cliente_id")
    private List<Veiculo> veiculos;


 /* 
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<Veiculo> veiculos;
*/

    //public Cliente(){}

 /* 
    public Cliente(String cpf, String nome, String telefone, Endereco endereco, List<Veiculo> veiculos) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.veiculos = veiculos;
        for (Veiculo veiculo : veiculos) {
            this.veiculos.add(veiculo);
        }
    }
*/
/* 
    public void setVeiculo(Veiculo v) {
        veiculos.add(v);
    }

    public void removeVeiculo(Veiculo v) {
        veiculos.remove(v);
    }

    public Veiculo buscaVeiculo(String placa) {
        Veiculo veiculo = new Veiculo();
        for (Veiculo item : veiculos) {
            if (item.getPlaca().equalsIgnoreCase(placa)) {
                veiculo = item;
                break;
            }
        }
        return veiculo;
    }
*/

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setVeiculos(List<Veiculo> veiculos){
        this.veiculos = veiculos;
    }

    public List<Veiculo> getVeiculos(){
        return veiculos;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", Endereco=" + endereco + "]";
    }

}
