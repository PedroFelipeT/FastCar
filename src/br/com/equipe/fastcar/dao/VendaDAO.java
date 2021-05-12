package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Peca;
import br.com.equipe.fastcar.classes.Venda;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import br.com.equipe.fastcar.util.AuxVenda;
import br.com.equipe.fastcar.util.Data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private Connection con;

    public VendaDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Venda venda) {
        String sql = "INSERT INTO venda (id_venda, data_venda, id_cliente, cod_funcionario , ref_peca, quantidade, valor_total,num_venda) VALUE(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {
            for (Peca p : venda.getDados()) {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, venda.getId_venda());
                stmt.setDate(2, Data.dateToDateSQL(venda.getData_venda()));
                stmt.setInt(3, venda.getId_cliente());
                stmt.setInt(4, venda.getCod_funcionario());
                stmt.setInt(5, p.getReferencia());
                stmt.setInt(6, p.getQuantidade());
                stmt.setDouble(7, venda.getValor_total());
                stmt.setInt(8, venda.getNum_venda());
                stmt.executeUpdate();
            }

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<AuxVenda> findAllRelatorio() {
        String sql = "SELECT DISTINCT cliente.nome,venda.valor_total,venda.num_venda FROM cliente ,venda WHERE cliente.id = venda.id_cliente";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AuxVenda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AuxVenda venda = new AuxVenda();
                venda.setNomeCliente(rs.getString("nome"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                vendas.add(venda);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return vendas;
    }

    public List<AuxVenda> findAllVendaOs() {
        String sql = "SELECT DISTINCT venda.num_venda ,venda.valor_total FROM venda WHERE venda.ref_peca = 9999";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AuxVenda> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AuxVenda venda = new AuxVenda();
                venda.setNum_venda(rs.getInt("num_venda"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                vendas.add(venda);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return vendas;
    }

    public int pegaUltimaCompra() {
        //String sql = "SELECT num_venda FROM venda ";
        String sql = "SELECT MAX(num_venda) FROM venda ";
        int valor = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            valor = rs.getInt(1);

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return valor + 1;

    }
}
