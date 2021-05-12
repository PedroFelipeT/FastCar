package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Veiculo;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VeiculoDAO {

    private Connection con;

    public VeiculoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (proprietario, chassi, placa, modelo , cor, kilometragem,motor,ano) VALUE(?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, veiculo.getId());
            stmt.setString(2, veiculo.getChassi());
            stmt.setString(3, veiculo.getPlaca());
            stmt.setString(4, veiculo.getModelo());
            stmt.setString(5, veiculo.getCor());
            stmt.setInt(6, veiculo.getKilometragem());
            stmt.setString(7, veiculo.getMotor());
            stmt.setString(8, veiculo.getAno());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Veiculo> findAll() {
        String sql = "SELECT * FROM veiculo order by proprietario";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setProprietario(rs.getString("proprietario"));
                veiculo.setChassi(rs.getString("chassi"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setKilometragem(rs.getInt("kilometragem"));
                veiculo.setMotor(rs.getString("motor"));
                veiculo.setAno(rs.getString("ano"));
                veiculos.add(veiculo);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return veiculos;
    }

    public Veiculo findEspecific(String placa) {
        String sql = "SELECT c.id,c.nome,v.id,v.modelo,v.chassi,v.cor,v.kilometragem,v.placa,v.motor,v.ano FROM veiculo AS v,cliente AS c WHERE v.placa = ? AND v.proprietario = c.id";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Veiculo veiculo = new Veiculo();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, placa);
            rs = stmt.executeQuery();
            rs.next();
            veiculo.setId(rs.getInt("v.id"));
            veiculo.setProprietario(rs.getString("c.nome"));
            veiculo.setModelo(rs.getString("v.modelo"));
            veiculo.setChassi(rs.getString("v.chassi"));
            veiculo.setCor(rs.getString("v.cor"));
            veiculo.setKilometragem(rs.getInt("v.kilometragem"));
            veiculo.setPlaca(rs.getString("v.placa"));
            veiculo.setMotor(rs.getString("v.motor"));
            veiculo.setAno(rs.getString("v.ano"));

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return veiculo;
    }

    public Veiculo findVeiculo(int id) {
        String sql = "SELECT c.id,c.nome,v.id,v.modelo,v.chassi,v.cor,v.kilometragem,v.placa,v.motor,v.ano FROM veiculo AS v,cliente AS c WHERE v.id = ? AND v.proprietario = c.id";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Veiculo veiculo = new Veiculo();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                veiculo.setId(rs.getInt("v.id"));
                veiculo.setProprietario(rs.getString("c.nome"));
                veiculo.setModelo(rs.getString("v.modelo"));
                veiculo.setChassi(rs.getString("v.chassi"));
                veiculo.setCor(rs.getString("v.cor"));
                veiculo.setKilometragem(rs.getInt("v.kilometragem"));
                veiculo.setPlaca(rs.getString("v.placa"));
                veiculo.setMotor(rs.getString("v.motor"));
                veiculo.setAno(rs.getString("v.ano"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return veiculo;
    }

    public boolean update(Veiculo veiculo,String placa) {
        String sql = ("UPDATE veiculo SET chassi = ?, placa = ?, modelo = ?, cor = ?, kilometragem = ?,motor = ?,ano = ? WHERE placa = ?");
        PreparedStatement stmt = null;
        con = ConnectionFactory.getConnection();
        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, veiculo.getChassi());
            stmt.setString(2, veiculo.getPlaca());
            stmt.setString(3, veiculo.getModelo());
            stmt.setString(4, veiculo.getCor());
            stmt.setInt(5, veiculo.getKilometragem());
            stmt.setString(6, veiculo.getMotor());
            stmt.setString(7, veiculo.getAno());
            stmt.setString(8, placa);
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

}
