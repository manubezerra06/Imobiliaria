/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controle;

import imobiliaria.modelo.Clientes;
import java.util.ArrayList;

/**
 *
 * @author manuela
 */
public interface ClientesControle {
    
    public void salvar(Clientes cliente);
    
    public void excluir(Clientes cliente);
    
    public ArrayList<Clientes> listar();
    
    public ArrayList<Clientes> pesquisarClientesPorCPF(String cpf);
    
}
