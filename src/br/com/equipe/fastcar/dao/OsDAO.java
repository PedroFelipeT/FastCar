package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Os;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import br.com.equipe.fastcar.util.AuxOsValores;
import static com.mysql.jdbc.NonRegisteringDriver.OS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class OsDAO {

    private Connection con;

    public OsDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Os os) {
        String sql = "INSERT INTO os (id,diagnostico,reclamacao, cod_funcionario, cod_tmo,cod_veiculo,valor_total) VALUE(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, os.getId());
            stmt.setString(2, os.getDiagnostico());
            stmt.setString(3, os.getReclamacao());
            stmt.setInt(4, os.getCod_atendete());
            stmt.setString(5, os.getCod_tmo());
            stmt.setInt(6, os.getCod_veiculo());
            stmt.setDouble(7, os.getValor_total());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "OS aberta com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean read(Os os) {
        String sql = "INSERT INTO os (id,diagnostico,reclamacao, cod_funcionario, cod_tmo,cod_veiculo,valor_total) VALUE(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, os.getId());
            stmt.setString(2, os.getDiagnostico());
            stmt.setString(3, os.getReclamacao());
            stmt.setInt(4, os.getCod_atendete());
            stmt.setString(5, os.getCod_tmo());
            stmt.setInt(6, os.getCod_veiculo());
            stmt.setDouble(7, os.getValor_total());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "OS aberta com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Os findEspecific(String id) {
        String sql = "SELECT * FROM os WHERE id = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Os os = new Os();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                os.setId(rs.getInt("id"));
                os.setDiagnostico(rs.getString("diagnostico"));
                os.setReclamacao(rs.getString("reclamacao"));
                os.setCod_atendete(rs.getInt("cod_funcionario"));
                os.setCod_tmo(rs.getString("cod_tmo"));
                os.setCod_veiculo(rs.getInt("cod_veiculo"));
                os.setValor_total(rs.getDouble("valor_total"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return os;
    }

    public boolean update(Os os) {
        String id = Integer.toString(os.getId());
        String sql = ("UPDATE os SET diagonostico = ?,cod_funcionario = ?,cod_tmo,valor_total = ? WHERE id = " + id);
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, os.getDiagnostico());
            stmt.setInt(2, os.getCod_atendete());
            stmt.setString(3, os.getCod_tmo());
            stmt.setDouble(4, os.getValor_total());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Os parcial finalizada!");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar! " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public int getIdOs() {
        String sql = "SELECT MAX(id) FROM os";
        int id = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);

            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return id + 1;
    }
        public List<AuxOsValores> findAllRelatorio() {
        String sql = "SELECT v.placa,os.valor_total FROM veiculo AS v,os AS os WHERE v.id = os.cod_veiculo";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AuxOsValores> vendas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                AuxOsValores venda = new AuxOsValores();
                venda.setValor_total(rs.getDouble("os.valor_total"));
                venda.setPlaca(rs.getString("v.placa"));
                vendas.add(venda);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return vendas;
    }
}
