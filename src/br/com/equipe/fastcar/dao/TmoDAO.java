package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Tmo;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TmoDAO {

    private Connection con;

    public TmoDAO() {
        con = ConnectionFactory.getConnection();
    }

    public List<Tmo> findAll() {
        String sql = "SELECT * FROM tmo ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Tmo> tmoServicos = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Tmo tmo = new Tmo();
                tmo.setCodigo(rs.getString("codigo"));
                tmo.setValorHora(rs.getDouble("valor_hr"));
                tmo.setDescricao(rs.getString("descricao"));
                tmoServicos.add(tmo);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tmoServicos;
    }

    public Tmo findEspecific(String cod_tmo) {
        String sql = "SELECT valor_hr FROM tmo WHERE codigo = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tmo tmo = new Tmo();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cod_tmo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                tmo.setValorHora(rs.getDouble("valor_hr"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return tmo;
    }
}
