package imobiliaria.controle;

import imobiliaria.modelo.Imoveis;
import java.util.ArrayList;


public interface ImoveisControle {

    public void insereImovel(Imoveis imovel);
    
    public void removeImovel(Imoveis imovel);
    
    public ArrayList<Imoveis> listar(); 
    
    /*public Carro consultaPorId(int id);*/

    public void atualizaImovel(Imoveis imovel);
    
}
