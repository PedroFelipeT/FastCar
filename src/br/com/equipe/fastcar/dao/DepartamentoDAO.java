
package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Departamento;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    
    private Connection con;
    
    public DepartamentoDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public List<Departamento> findAll() {
        String sql = "SELECT * FROM depto ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Departamento> departamentos = new ArrayList<>();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(rs.getInt("codigo"));
                departamento.setNomeDep(rs.getString("nome"));
                departamento.setSalario(rs.getDouble("salario"));
                departamentos.add(departamento);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return departamentos;
    }
}
