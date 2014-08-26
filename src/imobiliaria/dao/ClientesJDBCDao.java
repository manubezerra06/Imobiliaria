/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.dao;

import imobiliaria.controle.ClientesControle;
import imobiliaria.modelo.Clientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manuela
 */
public class ClientesJDBCDao implements ClientesControle{
    
    
    private Connection getConexao(){
    
        Connection conexao = null;
        
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:hsql://localhost/";
            conexao = DriverManager.getConnection(url, "SA", "");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não encontrado!");
        }
        return conexao;
 
    }

    @Override
    public void salvar(Clientes cliente) {
        if (cliente.getCodigo() != 0)
        atualizarCliente(cliente);
    else{
    Connection conexao = getConexao();
    String comando = "INSERT INTO CLIENTES"
    + "(NOME, CPF, MASCULINO, ENDERECO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, EMAIL, RENDA, VENDA, LOCACAO)"
    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setBoolean(3, cliente.isMasculino());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getBairro());
            ps.setString(6, cliente.getCidade());
            ps.setString(7, cliente.getEstado());
            ps.setString(8, cliente.getCep());
            ps.setString(9, cliente.getTelefone());
            ps.setString(10, cliente.getEmail());
            ps.setString(11, cliente.getRenda());
            ps.setBoolean(12, cliente.getVenda());
            ps.setBoolean(13, cliente.getLocacao());
            
            ps.execute();
            ps.close();
    }
        catch (SQLException ex) {
            
            System.out.println("Falha na conexão do SQL" + ex.getMessage());
        }
        
        
        
        }
        
    }
        
        
    public void atualizarCliente(Clientes cliente) {
    Connection conexao = getConexao();
    String comando = "UPDATE CLIENTES SET "
   + "nome = ?, cpf = ?, masculino = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, telefone = ?, email = ?, renda = ?, venda = ?, locacao = ?"
    + " WHERE CODIGO = ?";
        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setBoolean(3, cliente.isMasculino());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getBairro());
            ps.setString(6, cliente.getCidade());
            ps.setString(7, cliente.getEstado());
            ps.setString(8, cliente.getCep());
            ps.setString(9, cliente.getTelefone());
            ps.setString(10, cliente.getEmail());
            ps.setString(11, cliente.getRenda());
            ps.setBoolean(12, cliente.getVenda());
            ps.setBoolean(13, cliente.getLocacao());
            ps.setInt(14, cliente.getCodigo());
            
            int a = ps.executeUpdate();
            
            System.out.println("Registros atualizados" + a);
            
            ps.close();
            
            
        } catch (SQLException ex) {
            
            System.out.println("Falha na conexão do SQL" + ex.getMessage());
        }
    
        
    }     

    @Override
    public void excluir(Clientes cliente) {
        Connection conexao = getConexao();
    String comando = "DELETE FROM CLIENTES WHERE codigo =?";
        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setInt(1, cliente.getCodigo());
            ps.execute();
            ps.close();
    }
        catch (SQLException ex) {
            
            System.out.println("Falha na conexão do SQL" + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Clientes> listar() {
             Connection conexao = getConexao();
         ArrayList<Clientes> listaClientes = new ArrayList<>();
         String consulta = "SELECT * FROM CLIENTES";
         try{
             PreparedStatement ps = conexao.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 Clientes cliente = new Clientes();
                 cliente.setCodigo(rs.getInt("codigo"));
                 cliente.setNome(rs.getString("nome"));
                 cliente.setCpf(rs.getString("cpf"));
                 cliente.setMasculino(rs.getBoolean("masculino"));
                 cliente.setEndereco(rs.getString("endereco"));
                 cliente.setBairro(rs.getString("bairro"));
                 cliente.setCidade(rs.getString("cidade"));
                 cliente.setEstado(rs.getString("estado"));
                 cliente.setCep(rs.getString("cep"));
                 cliente.setTelefone(rs.getString("telefone"));
                 cliente.setEmail(rs.getString("email"));
                 cliente.setRenda(rs.getString("renda"));
                 cliente.setVenda(rs.getBoolean("venda"));
                 cliente.setLocacao(rs.getBoolean("locacao"));
                 
                 listaClientes.add(cliente);
             }
             
             ps.close();
      }catch (SQLException ex) {
            
            System.out.println("Erro na listagem de clientes!" + ex.getMessage());
         
    }
         return listaClientes;
    }

    @Override
   public ArrayList<Clientes> pesquisarClientesPorCPF(String cpf) {
        Connection conexao = getConexao();
        ArrayList<Clientes> clientesEncontrados = new ArrayList<>();
        String consulta = "SELECT * FROM CLIENTES WHERE CPF = ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(consulta);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes cliente = new Clientes();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setMasculino(rs.getBoolean("masculino"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCep(rs.getString("cep"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setRenda(rs.getString("renda"));
                cliente.setVenda(rs.getBoolean("venda"));
                cliente.setLocacao(rs.getBoolean("locacao"));

                clientesEncontrados.add(cliente);

            }

            ps.close();
        } catch (SQLException ex) {

            System.out.println("Erro na listagem de clientes!" + ex.getMessage());

        }

        return clientesEncontrados;

        
    }
    
}
