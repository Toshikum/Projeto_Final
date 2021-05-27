/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author toshi
 */
public class Pessoa {
    private int id;
    private String nome;
    private int idade;
    private boolean saude;
    private String endereco;
    private boolean vacinacao;

    public Pessoa(String nome, int idade, boolean saude, String endereco, boolean vacinacao) {
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
        this.vacinacao = vacinacao;
    }

    //cadastrar pessoa
    public Pessoa(String nome, int idade, boolean saude, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
        this.endereco = endereco;
    }
    
    //buscar pessoa
    public Pessoa(int id, String nome, int idade, boolean saude) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.saude = saude;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isSaude() {
        return saude;
    }

    public void setSaude(boolean saude) {
        this.saude = saude;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isVacinacao() {
        return vacinacao;
    }

    public void setVacinacao(boolean vacinacao) {
        this.vacinacao = vacinacao;
    }
        
}
