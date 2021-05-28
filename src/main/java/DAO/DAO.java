/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classes.Pessoa;
import Conexao.Conexao;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author toshi
 */
public class DAO {
    public boolean existe (Usuario usuario) throws Exception{
        String sql = "SELECT*FROM usuarios WHERE nome = ? AND senha = ?";
        try(Connection conexao = Conexao.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    public boolean administrador (Usuario usuario) throws Exception{
        String sql = "SELECT*FROM usuarios WHERE nome = ?";
        try(Connection conexao = Conexao.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, usuario.getNome());          
            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                return rs.getBoolean(4);                
            }
        }
    }
    public void cadastrarUsuario(Usuario usuario) throws Exception{
        String sql = "INSERT INTO usuarios(nome, senha, administrador) VALUES (?, ?, ?)";
        try(Connection conexao = Conexao.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            ps.setBoolean(3, usuario.getAdministrador());
            ps.execute();
        }
    }
    public Usuario[] obterUsuario () throws Exception{
        String sql = "SELECT * FROM usuarios";
        try(Connection conexao = Conexao.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(
                sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = ps.executeQuery()){
                    
                int totalDeUsuarios = rs.last() ? rs.getRow() : 0;
                Usuario [] usuarios = new Usuario[totalDeUsuarios];
                rs.beforeFirst();
                int contador = 0;
                while (rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    boolean administrador = rs.getBoolean("administrador");
                    usuarios[contador++] = new Usuario (id,nome,administrador);
                }
                return usuarios;
            }
    }
    public void removerUsuario(Usuario usuario) throws Exception{
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try(Connection conexao = Conexao.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql);){
            ps.setInt(1, usuario.getId());
            ps.execute();
        }                
    }
    
    public void cadastrarPessoa(Pessoa pessoa) throws Exception{
        String sql = "INSERT INTO pessoas(nome, idade, saude, endereco) VALUES (?, ?, ?, ?)";
        try(Connection conexao = Conexao.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, pessoa.getNome());
            ps.setInt(2, pessoa.getIdade());
            ps.setBoolean(3, pessoa.isSaude());
            ps.setString(4, pessoa.getEndereco());
            ps.execute();
        }
    }
    
    public List <Pessoa> obterPessoa () throws Exception{
        String sql = "SELECT * FROM pessoas WHERE data_vacinacao IS NULL";
        List <Pessoa> pessoas = new ArrayList <> ();
        try(Connection conexao = Conexao.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
                try (ResultSet rs = ps.executeQuery()){
                    while (rs.next()){
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    int idade = rs.getInt("idade");
                    boolean saude = rs.getBoolean("saude");
                    pessoas.add(new Pessoa(id,nome,idade,saude));
                }    
            }
        } 
        return pessoas;
    }
    public void confirmarVacinacao (int id) throws Exception{
        String sql = "UPDATE pessoas SET data_vacinacao = ? WHERE id = ?";
        try(Connection conexao = Conexao.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)){
                ps.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
                ps.setInt(2, id);
                ps.execute();
        }
    }
}