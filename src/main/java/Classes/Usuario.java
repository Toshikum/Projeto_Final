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
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private boolean administrador;

    public Usuario(String nome, String senha, boolean administrador) {
        this.nome = nome;
        this.senha = senha;
        this.administrador = administrador;
    }
    
    public Usuario (String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }
    
    public Usuario (int id, String nome,boolean administrador){
        this.id = id;
        this.nome = nome;
        this.administrador = administrador;
    }
    
    public Usuario (int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}
