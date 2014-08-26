/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.dao;

import imobiliaria.controle.FuncionariosControle;
import imobiliaria.modelo.Funcionarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author André
 */
/*
public class FuncionariosJDBCDao implements FuncionariosControle{
    
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
    public void salvar(Funcionarios funcionario) {
        if (funcionario.getCodigo() != 0)
        atualizarCliente(funcionario);
    else{
    Connection conexao = getConexao();
    String comando = "INSERT INTO CLIENTES"
    + "(NOME, CPF, MASCULINO, CTPS, ENDERECO, BAIRRO, CIDADE, ESTADO, CEP, TELEFONE, EMAIL, CARGO, SALARIO)"
    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setBoolean(3, funcionario.getMasculino());
            ps.setString(4, funcionario.getCtps());
            ps.setString(5, funcionario.getEndereco());
            ps.setString(6, funcionario.getBairro());
            ps.setString(7, funcionario.getCidade());
            ps.setString(8, funcionario.getEstado());
            ps.setString(9, funcionario.getCep());
            ps.setString(10, funcionario.getTelefone());
            ps.setString(11, funcionario.getEmail());
            ps.setString(12, funcionario.getCargo());
            ps.setString(13, funcionario.getSalario());
            
            
            ps.execute();
            ps.close();
    }
        catch (SQLException ex) {
            
            System.out.println("Falha na conexão do SQL" + ex.getMessage());
        }
        
        
        
        }
        
    }
        
        
    public void atualizarCliente(Funcionarios funcionario) {
    Connection conexao = getConexao();
    String comando = "UPDATE CLIENTES SET "
   + "nome = ?, cpf = ?, masculino = ?, ctps = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, telefone = ?, email = ?, cargo = ?, salario = ?"
    + " WHERE CODIGO = ?";
        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setBoolean(3, funcionario.getMasculino());
            ps.setString(4, funcionario.getCtps());
            ps.setString(5, funcionario.getEndereco());
            ps.setString(6, funcionario.getBairro());
            ps.setString(7, funcionario.getCidade());
            ps.setString(8, funcionario.getEstado());
            ps.setString(9, funcionario.getCep());
            ps.setString(10, funcionario.getTelefone());
            ps.setString(11, funcionario.getEmail());
            ps.setString(12, funcionario.getCargo());
            ps.setString(13, funcionario.getSalario());
            
            int a = ps.executeUpdate();
            
            System.out.println("Registros atualizados" + a);
            
            ps.close();
            
            
        } catch (SQLException ex) {
            
            System.out.println("Falha na conexão do SQL" + ex.getMessage());
        }
    
        
    }     

    @Override
    public void excluir(Funcionarios funcionario) {
        Connection conexao = getConexao();
    String comando = "DELETE FROM CLIENTES WHERE codigo =?";
        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setInt(1, funcionario.getCodigo());
            ps.execute();
            ps.close();
    }
        catch (SQLException ex) {
            
            System.out.println("Falha na conexão do SQL" + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Funcionarios> listar() {
             Connection conexao = getConexao();
         ArrayList<Funcionarios> listaClientes = new ArrayList<>();
         String consulta = "SELECT * FROM FUNCIONARIOS";
         try{
             PreparedStatement ps = conexao.prepareStatement(consulta);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 Funcionarios funcionario = new Funcionarios();
                 funcionario.setCodigo(rs.getInt("codigo"));
                 funcionario.setNome(rs.getString("nome"));
                 funcionario.setCpf(rs.getString("cpf"));
                 funcionario.setCtps(rs.getString("ctps"));
                 funcionario.setMasculino(rs.getBoolean("masculino"));
                 funcionario.setEndereco(rs.getString("endereco"));
                 funcionario.setBairro(rs.getString("bairro"));
                 funcionario.setCidade(rs.getString("cidade"));
                 funcionario.setEstado(rs.getString("estado"));
                 funcionario.setCep(rs.getString("cep"));
                 funcionario.setTelefone(rs.getString("telefone"));
                 funcionario.setEmail(rs.getString("email"));
                 funcionario.setSalario(rs.getString("salario"));
                 funcionario.setSalario(rs.getString("salario"));
                 
                 listaClientes.add(funcionario);
             }
             
             ps.close();
      }catch (SQLException ex) {
            
            System.out.println("Erro na listagem de clientes!" + ex.getMessage());
         
    }
         return listaClientes;
    }

    @Override
    public Funcionarios pesquisarFuncionariosPorCargo(String cargo) {
        Connection conexao = getConexao();
        Funcionarios FuncionarioEncontrado = null;
        String consulta = "SELECT * FROM CLIENTES WHERE CARGO = ?";
        try{
             PreparedStatement ps = conexao.prepareStatement(consulta);
             ps.setString(1, cargo);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 FuncionarioEncontrado = new Funcionarios();
                 FuncionarioEncontrado.setCodigo(rs.getInt("codigo"));
                 FuncionarioEncontrado.setNome(rs.getString("nome"));
                 FuncionarioEncontrado.setCpf(rs.getString("cpf"));
                 FuncionarioEncontrado.setCtps(rs.getString("ctps"));
                 FuncionarioEncontrado.setMasculino(rs.getBoolean("masculino"));
                 FuncionarioEncontrado.setEndereco(rs.getString("endereco"));
                 FuncionarioEncontrado.setBairro(rs.getString("bairro"));
                 FuncionarioEncontrado.setCidade(rs.getString("cidade"));
                 FuncionarioEncontrado.setEstado(rs.getString("estado"));
                 FuncionarioEncontrado.setCep(rs.getString("cep"));
                 FuncionarioEncontrado.setTelefone(rs.getString("telefone"));
                 FuncionarioEncontrado.setEmail(rs.getString("email"));
                 FuncionarioEncontrado.setSalario(rs.getString("salario"));
                 
                 
                 break;
       
             }
             
             ps.close();
      }catch (SQLException ex) {
            
            System.out.println("Erro na listagem de clientes!" + ex.getMessage());
         
    }
        
         return FuncionarioEncontrado;
        
        
    }
    
    @Override
    public Funcionarios pesquisarFuncionariosPorNome(String nome) {
        Connection conexao = getConexao();
        Funcionarios FuncionarioEncontrado = null;
        String consulta = "SELECT * FROM CLIENTES WHERE NOME = ?";
        try{
             PreparedStatement ps = conexao.prepareStatement(consulta);
             ps.setString(1, nome);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()){
                 FuncionarioEncontrado = new Funcionarios();
                 FuncionarioEncontrado.setCodigo(rs.getInt("codigo"));
                 FuncionarioEncontrado.setNome(rs.getString("nome"));
                 FuncionarioEncontrado.setCpf(rs.getString("cpf"));
                 FuncionarioEncontrado.setCtps(rs.getString("ctps"));
                 FuncionarioEncontrado.setMasculino(rs.getBoolean("masculino"));
                 FuncionarioEncontrado.setEndereco(rs.getString("endereco"));
                 FuncionarioEncontrado.setBairro(rs.getString("bairro"));
                 FuncionarioEncontrado.setCidade(rs.getString("cidade"));
                 FuncionarioEncontrado.setEstado(rs.getString("estado"));
                 FuncionarioEncontrado.setCep(rs.getString("cep"));
                 FuncionarioEncontrado.setTelefone(rs.getString("telefone"));
                 FuncionarioEncontrado.setEmail(rs.getString("email"));
                 FuncionarioEncontrado.setSalario(rs.getString("salario"));
                 
                 
                 break;
       
             }
             
             ps.close();
      }catch (SQLException ex) {
            
            System.out.println("Erro na listagem de clientes!" + ex.getMessage());
         
    }
        
         return FuncionarioEncontrado;
        
        
    }
}
*/