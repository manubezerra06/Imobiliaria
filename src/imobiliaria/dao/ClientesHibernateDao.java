/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.dao;

import imobiliaria.controle.ClientesControle;
import imobiliaria.modelo.Clientes;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author manuela
 */
public class ClientesHibernateDao implements ClientesControle {

    @Override
    public void salvar(Clientes cliente) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transacao = session.beginTransaction();
        session.saveOrUpdate(cliente);
        transacao.commit();
        session.close();
    }

    @Override
    public void excluir(Clientes cliente) {
       SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transacao = session.beginTransaction();
        session.delete(cliente);
        transacao.commit();
        session.close();
    }

    @Override
    public ArrayList<Clientes> listar() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Clientes.class);
        ArrayList<Clientes> listaDeClientes = (ArrayList<Clientes>) criteria.list();
        session.close();
        return listaDeClientes;
    }

    @Override
    public ArrayList<Clientes> pesquisarClientesPorCPF(String cpf) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Clientes.class);
        criteria.add(Restrictions.like("cpf", cpf));
        ArrayList<Clientes> listaDeClientes = (ArrayList<Clientes>) criteria.list();
        session.close();
        
        return listaDeClientes;    
        
    }
    
}
