/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gui;

import imobiliaria.modelo.Funcionarios;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author André
 */
public class Funcionarios2Table extends AbstractTableModel {
    private ArrayList<Funcionarios> funcionarios = new ArrayList<>();
    private String[] colunas = {"Codigo", "Nome", "Cargo","Salario"};
    
    public static final int INDICE_CODIGO = 0;
    public static final int INDICE_NOME = 1;
    public static final int INDICE_CARGO = 2;
    public static final int INDICE_SALARIO =3;
    

    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;    
    }
    
    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = funcionarios.get(rowIndex).toArray();
        return linha[columnIndex];
    }

    public void addFuncionarios(Funcionarios funcionario) {
        funcionarios.add(funcionario);
        this.fireTableDataChanged();
    }

    public Funcionarios getSelectedFuncionario(int linhaSelecionada) {
        return funcionarios.get(linhaSelecionada);
    }
    
    public void removeFuncionario(int linhaSelecionada){
        funcionarios.remove(linhaSelecionada);
        this.fireTableDataChanged();
    }
    
     public void setFuncionarios (ArrayList<Funcionarios> novaLista){
    
        this.funcionarios = novaLista;
        this.fireTableDataChanged();
    }
}
