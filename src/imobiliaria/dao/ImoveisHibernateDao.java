/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imobiliaria.dao;

import imobiliaria.controle.ImoveisControle;
import imobiliaria.modelo.Imoveis;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ImoveisHibernateDao implements ImoveisControle{

    @Override
    public void insereImovel(Imoveis imovel) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(imovel);
        tr.commit();
        session.close();
    }

    @Override
    public void removeImovel(Imoveis imovel) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Transaction tr = session.beginTransaction();
        session.delete(imovel);
        tr.commit();
        session.close();
    }

    @Override
    public ArrayList<Imoveis> listar() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        
        Criteria crit = session.createCriteria(Imoveis.class);
        ArrayList<Imoveis> lista = (ArrayList<Imoveis>) crit.list();
        
        return lista;
        
    }

    @Override
    public void atualizaImovel(Imoveis imovel) {
    }
    
    

}
