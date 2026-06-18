package com.example.projetoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/sistema_estoque?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "@Pm13241";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver não encontrado.", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco de dados.", e);
        }
    }

    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Sucesso! O Java está conectado ao MySQL!");
            conexao.close();
        } catch (Exception e) {
            System.out.println("Ops, algo deu errado na conexão:");
            e.printStackTrace();
        }
    }
}