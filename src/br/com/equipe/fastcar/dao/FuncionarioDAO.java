package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Funcionario;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    private Connection con;

    public FuncionarioDAO() {
        con = ConnectionFactory.getConnection();
    }

    public boolean save(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome,cpf,telefone,endereco,email,cidade,cod_depto) VALUE(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            //stmt.setInt(1, funcionario.getCodigo());
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getCidade());
            stmt.setInt(7, funcionario.getCodDepto());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Funcionario> findAll() {
        String sql = "SELECT * FROM cliente order by nome ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("codigo"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEmail(rs.getString("email"));
                funcionarios.add(funcionario);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }

    public Funcionario findEspecific(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                funcionario.setCodigo(rs.getInt("codigo"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setCodDepto(rs.getInt("cod_depto"));

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionario;
    }

    public List<Funcionario> findForCpf(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setCodDepto(rs.getInt("cod_depto"));
                funcionarios.add(funcionario);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return funcionarios;
    }

    public boolean update(Funcionario funcionario) {
        String codigo = Integer.toString(funcionario.getCodigo());
        String sql = ("UPDATE  funcionario SET nome = ?, cpf = ?, telefone = ?, endereco = ?, email = ?, cidade = ?, cod_depto = ? WHERE codigo = " + codigo);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getTelefone());
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getEmail());
            stmt.setString(6, funcionario.getCidade());
            stmt.setInt(7, funcionario.getCodDepto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualização efetuada com sucesso!");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}//Fim da classe
