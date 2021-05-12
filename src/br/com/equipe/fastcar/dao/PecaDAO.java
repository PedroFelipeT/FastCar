package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Cliente;
import br.com.equipe.fastcar.classes.Peca;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PecaDAO {

    private Connection con;

    public PecaDAO() {
        con = ConnectionFactory.getConnection();

    }

    public boolean save(Peca peca) {
        String sql = "INSERT INTO peca (nome, referencia, fornecedor, quantidade , valor_compra, valor_venda) VALUE(?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setInt(2, peca.getReferencia());
            stmt.setString(3, peca.getFornecedor());
            stmt.setInt(4, peca.getQuantidade());
            stmt.setDouble(5, peca.getValorDeCompra());
            stmt.setDouble(6, peca.getValorDeVenda());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Peca> findAll() {
        String sql = "SELECT * FROM peca order by nome";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Peca> pecas = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Peca peca = new Peca();
                peca.setNome(rs.getString("nome"));
                peca.setReferencia(rs.getInt("referencia"));
                peca.setFornecedor(rs.getString("fornecedor"));
                peca.setQuantidade(rs.getInt("quantidade"));
                peca.setValorDeCompra(rs.getDouble("valor_compra"));
                peca.setValorDeVenda(rs.getDouble("valor_venda"));
                pecas.add(peca);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pecas;
    }

    public boolean update(Peca peca) {
        String referencia = Integer.toString(peca.getReferencia());
        String sql = ("UPDATE peca SET nome = ?, referencia = ?, fornecedor = ?, quantidade = ? , valor_compra = ?, valor_venda = ? WHERE referencia = " + referencia);
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, peca.getNome());
            stmt.setInt(2, peca.getReferencia());
            stmt.setString(3, peca.getFornecedor());
            stmt.setInt(4, peca.getQuantidade());
            stmt.setDouble(5, peca.getValorDeCompra());
            stmt.setDouble(6, peca.getValorDeVenda());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Peca peca) {
        //Seleciona na tabela e exclui 
        String sql = ("DELETE FROM peca WHERE referencia = ?");
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, peca.getReferencia());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao excluir: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Peca> readForReference(String ref) {
        //PreparedStatement serve pra mostrar que é linguagem sql
        String sql = "SELECT * FROM peca WHERE referencia = ?"; //Mudando do = para LIKE ele pega onde tiver o %nome% em todas as colunas nome% começo %nome fim

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Peca> pecas = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ref);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Peca peca = new Peca();
                peca.setNome(rs.getString("nome"));
                peca.setReferencia(rs.getInt("referencia"));
                peca.setFornecedor(rs.getString("fornecedor"));
                peca.setQuantidade(rs.getInt("quantidade"));
                peca.setValorDeCompra(rs.getDouble("valor_compra"));
                peca.setValorDeVenda(rs.getDouble("valor_venda"));
                pecas.add(peca);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pecas;
    }

    public boolean updateQuantidade(Peca peca, int quantidade) {
        //Pega a quantidade atual e subtrai pela quantidade vendida
        String referencia = Integer.toString(peca.getReferencia());
        String sql = ("UPDATE peca SET quantidade = quantidade -" + quantidade + " WHERE referencia = " + referencia);
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean updateQuantidadeEntrada(int referencia, int quantidade) {
        //Pega a quantidade atual e subtrai pela quantidade vendida
        String sql = ("UPDATE peca SET quantidade = quantidade +" + quantidade + " WHERE referencia = ?");
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, referencia);
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean checkRef(String ref) {
        String sql = "SELECT referencia FROM peca WHERE referencia = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ref);
            rs = stmt.executeQuery();
            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }
}
