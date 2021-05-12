package br.com.equipe.fastcar.dao;

import br.com.equipe.fastcar.classes.Cliente;
import br.com.equipe.fastcar.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private Connection con;

    public ClienteDAO() {
        con = ConnectionFactory.getConnection();

    }

    public boolean save(Cliente cliente) {
        String sql = "INSERT INTO cliente (id,nome, cpf, endereco , cidade, telefone, email) VALUE(?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCidade());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getEmail());
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

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente order by id ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    public List<Cliente> findForCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    public Cliente findCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";
        Cliente cliente = new Cliente();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            while (rs.next()) {
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));

            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cliente;
    }

    public  boolean checkCpf(String cpf) {
        String sql = "SELECT cpf FROM cliente WHERE cpf = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            if(rs.next()){
                check = true;
   
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return check;
    }

    public boolean update(Cliente cliente) {
        String id = Integer.toString(cliente.getId());
        String sql = ("UPDATE  cliente SET nome = ?, cpf = ?, endereco = ?, cidade = ?, telefone = ?, email = ? WHERE id = " + id);
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atialização efetuada com sucesso!");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean delete(Cliente cliente) {

        String sql = ("DELETE FROM cliente  WHERE id = ?");
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            return true;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Cliente findEspecific(String placa) {
        String sql = "SELECT c.id,c.nome,c.telefone,c.email,c.endereco,c.cidade FROM veiculo AS v,cliente AS c WHERE v.placa = ? AND v.proprietario = c.id";

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = new Cliente();
        con = ConnectionFactory.getConnection();
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, placa);
            rs = stmt.executeQuery();
            rs.next();
            cliente.setId(rs.getInt("c.id"));
            cliente.setNome(rs.getString("c.nome"));
            cliente.setTelefone(rs.getString("c.telefone"));
            cliente.setEmail(rs.getString("c.email"));
            cliente.setEndereco(rs.getString("c.endereco"));
            cliente.setCidade(rs.getString("c.cidade"));

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return cliente;
    }
}
