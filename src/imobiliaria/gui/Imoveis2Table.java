/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.gui;

import imobiliaria.modelo.Imoveis;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author manuela
 */
public class Imoveis2Table extends AbstractTableModel {

    private ArrayList<Imoveis> imoveis = new ArrayList<Imoveis>();
    private String[] colunas = {"Codigo", "Bairro", "Cidade", "Proprietario"};
    
    public static final int INDICE_CODIGO = 0;
    public static final int INDICE_BAIRRO = 1;
    public static final int INDICE_CIDADE = 2;
    public static final int INDICE_PROPRIETARIO = 3;

    @Override
    public int getRowCount() {
        return imoveis.size();
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
        String[] linha = imoveis.get(rowIndex).toArray();
        return linha[columnIndex];
    }

    public void addImoveis(Imoveis imovel) {
        imoveis.add(imovel);
        this.fireTableDataChanged();
    }

    public Imoveis getSelectedImoveis(int linhaSelecionada) {
        return imoveis.get(linhaSelecionada);
    }
    
    public void removeImoveis(int linhaSelecionada){
        imoveis.remove(linhaSelecionada);
        this.fireTableDataChanged();
    }
    
    void setImoveis(ArrayList<Imoveis> imovel) {
        this.imoveis = imovel;
        this.fireTableDataChanged();
    }

    Imoveis getSelectedImovel(int linhaSelecionada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
