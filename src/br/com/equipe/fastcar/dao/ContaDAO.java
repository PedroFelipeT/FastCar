package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Conta;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ContaDAO {

    private Connection con;

    public ContaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Conta conta) {
        String sql = "INSERT INTO conta (login, senha, acesso) VALUE(?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, conta.getLogin());
            stmt.setString(2, conta.getSenha());
            stmt.setInt(3, conta.getAcesso());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Conta> findAll() {
        String sql = "SELECT * FROM conta order by nome";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Conta> contas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setLogin(rs.getString("login"));
                conta.setSenha(rs.getString("senha"));
                conta.setAcesso(rs.getInt("acesso"));
                conta.setCod_funcionario(rs.getInt("cod_funcionario"));
                contas.add(conta);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return contas;
    }

    public Conta findForLoginSenha(String login, String senha) {
        String sql = "SELECT * FROM conta WHERE login = ? AND senha = ?";
        Conta conta = new Conta();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while (rs.next()) {

                conta.setLogin(rs.getString("login"));
                conta.setSenha(rs.getString("senha"));
                conta.setAcesso(rs.getInt("acesso"));
                conta.setCod_funcionario(rs.getInt("cod_funcionario"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return conta;
    }

    public boolean update(Conta conta) {
        String cod = Integer.toString(conta.getCod_funcionario());
        String sql = ("UPDATE  conta SET acesso = ? WHERE cod_funcionario = " + cod);
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, conta.getAcesso());
            stmt.executeUpdate();


            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
