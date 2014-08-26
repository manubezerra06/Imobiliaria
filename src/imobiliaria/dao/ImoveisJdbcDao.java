/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.dao;

import imobiliaria.controle.ImoveisControle;
import imobiliaria.modelo.Imoveis;
import java.sql.*;
import java.util.ArrayList;


public class ImoveisJdbcDao implements ImoveisControle {

    public Connection getConexao(){
        Connection conexao = null;
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String url = "jdbc:hsqldb:hsql://localhost/";
            conexao = DriverManager.getConnection(url, "sa", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("Nao achei a classe");
        } catch (SQLException ex) {
            System.out.println("Nao deu pra conectar: " + ex.getMessage());
        }
        return conexao;
    }

    @Override
    public void insereImovel(Imoveis imovel) {
        if (imovel.getCodigo() != 0)
        atualizaImovel(imovel);
    else{
        Connection conexao = getConexao();

        String comando = "INSERT INTO IMOVEIS"
                + "(endereco, numero, bairro, cidade, estado, pais, proprietario, telefone, valormaximo, valorminimo) "
                + "values (?,?,?,?,?,?,?,?,?,?)";

        System.out.println(comando);
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);

            ps.setString(1, imovel.getEndereco());
            ps.setString(2, imovel.getNumero());
            ps.setString(3, imovel.getBairro());
            ps.setString(4, imovel.getCidade());
            ps.setString(5, imovel.getEstado());
            ps.setString(6, imovel.getPais());
            ps.setString(7, imovel.getProprietario());
            ps.setString(8, imovel.getTelefone());
            ps.setString(9, imovel.getValormaximo());
            ps.setString(10, imovel.getValorminimo());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Falha na execução do SQL " + ex.getMessage());
        }

    }
    }

    @Override
    public void removeImovel(Imoveis imovel) {
        Connection conexao = getConexao();
        String query = "DELETE FROM IMOVEIS WHERE CODIGO=?";
        try {
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, imovel.getCodigo());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Problemas com a exclusão do Livro");
        }
    }

    @Override
    public ArrayList<Imoveis> listar() {
        Connection conexao = getConexao();
        ArrayList<Imoveis> listaImoveis = new ArrayList<Imoveis>();

        String consulta = "select * from imoveis";

        try {
            PreparedStatement ps = conexao.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Imoveis imovel = new Imoveis();
                imovel.setCodigo(rs.getInt("codigo"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setNumero(rs.getString("numero"));
                imovel.setBairro(rs.getString("bairro"));
                imovel.setCidade(rs.getString("cidade"));
                imovel.setEstado(rs.getString("estado"));
                imovel.setPais(rs.getString("pais"));
                imovel.setProprietario(rs.getString("proprietario"));
                imovel.setTelefone(rs.getString("telefone"));
                imovel.setValormaximo(rs.getString("valormaximo"));
                imovel.setValorminimo(rs.getString("valorminimo"));
                listaImoveis.add(imovel);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na listagem de Imóveis");;
        }
        return listaImoveis;

    }

    @Override
    public void atualizaImovel(Imoveis imovel) {
        Connection conexao = getConexao();

        String comando = "UPDATE IMOVEIS SET "
                + "endereco=?, numero=?, bairro=?, cidade=?, estado=?, pais=?, proprietario=?, telefone=?, "
                + "valormaximo=?, valorminimo=?"
                + "where codigo=? ";
        try {
            PreparedStatement ps = conexao.prepareStatement(comando);
            ps.setString(1, imovel.getEndereco());
            ps.setString(1, imovel.getEndereco());
            ps.setString(2, imovel.getNumero());
            ps.setString(3, imovel.getBairro());
            ps.setString(4, imovel.getCidade());
            ps.setString(5, imovel.getEstado());
            ps.setString(6, imovel.getPais());
            ps.setString(7, imovel.getProprietario());
            ps.setString(8, imovel.getTelefone());
            ps.setString(9, imovel.getValormaximo());
            ps.setString(10, imovel.getValorminimo());
            ps.setInt(11, imovel.getCodigo());

            int a = ps.executeUpdate();

            System.out.println("Registros atualizados: " + a);
            
            

        } catch (SQLException ex) {
            System.out.println("Falha na execução do SQL " + ex.getMessage());
        }

    }
}
