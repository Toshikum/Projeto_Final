/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import Classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author toshi
 */
public class DAO {
    public boolean existe (Usuario usuario) throws Exception{
        String sql = "SELECT*FROM usuarios WHERE nome = ? AND senha = ?";
        try(Connection conn = Conexao.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSenha());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    public boolean administrador (Usuario usuario) throws Exception{
        String sql = "SELECT*FROM usuarios WHERE nome = ?";
        try(Connection conn = Conexao.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getNome());          
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                return rs.getBoolean(4);
                }
            }
        }
    }
}
