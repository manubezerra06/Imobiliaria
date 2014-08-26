/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gui;

import imobiliaria.modelo.Clientes;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author manuela
 */
public class Clientes2Table extends AbstractTableModel {
    
    private ArrayList<Clientes> clientes = new ArrayList<>();
    private String[] colunas = {"Codigo", "Nome", "cpf"};
    
    public static final int INDICE_CODIGO = 0;
    public static final int INDICE_NOME = 1;
    public static final int INDICE_CPF = 2;
    

    @Override
    public int getRowCount() {
        return clientes.size();
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
        String[] linha = clientes.get(rowIndex).toArray();
        return linha[columnIndex];
    }

    public void addClientes(Clientes cliente) {
        clientes.add(cliente);
        this.fireTableDataChanged();
    }

    public Clientes getSelectedCliente(int linhaSelecionada) {
        return clientes.get(linhaSelecionada);
    }
    
    public void removeCliente(int linhaSelecionada){
        clientes.remove(linhaSelecionada);
        this.fireTableDataChanged();
    }
    
     public void setClientes (ArrayList<Clientes> novaLista){
    
        this.clientes = novaLista;
        this.fireTableDataChanged();
    }
    
}
