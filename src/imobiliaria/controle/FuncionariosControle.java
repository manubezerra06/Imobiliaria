/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.controle;

import imobiliaria.modelo.Funcionarios;
import java.util.ArrayList;

/**
 *
 * @author André
 */
public interface FuncionariosControle {
    
    public void salvar(Funcionarios cliente);
    
    public void excluir(Funcionarios cliente);
    
    public ArrayList<Funcionarios> listar();
    
    public ArrayList<Funcionarios> pesquisarFuncionariosPorCargo(String cargo);
    
    public ArrayList<Funcionarios> pesquisarFuncionariosPorNome(String nome);
    
}
