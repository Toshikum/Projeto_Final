package Conexao;


import java.sql.Connection;
import java.sql.DriverManager;



public class Conexao {
    private static String usuario = "root"; 
    private static String senha = "123456";
    private static String host = "127.0.0.1";
    private static String porta = "3306";
    private static String bd = "fila_covac";
    
    public static Connection obterConexao () throws Exception{
        String url = String.format(
        "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo",
        host,
        porta,
        bd
        );
        return DriverManager.getConnection(url, usuario, senha);
    }
}
