/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imobiliaria.dao;

import imobiliaria.controle.FuncionariosControle;
import imobiliaria.modelo.Funcionarios;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author André
 */
public class FuncionariosHibernate implements FuncionariosControle {
    @Override
    public void salvar(Funcionarios funcionario) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transacao = session.beginTransaction();
        session.saveOrUpdate(funcionario);
        transacao.commit();
        session.close();
    }

    @Override
    public void excluir(Funcionarios funcionario) {
       SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transacao = session.beginTransaction();
        session.delete(funcionario);
        transacao.commit();
        session.close();
    }

    @Override
    public ArrayList<Funcionarios> listar() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Funcionarios.class);
        ArrayList<Funcionarios> listaDeFuncionarios = (ArrayList<Funcionarios>) criteria.list();
        session.close();
        return listaDeFuncionarios;
    }

    @Override
    public ArrayList<Funcionarios> pesquisarFuncionariosPorCargo(String cargo) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Funcionarios.class);
        criteria.add(Restrictions.like("cargo", cargo));
        ArrayList<Funcionarios> listaDeFuncionarios = (ArrayList<Funcionarios>) criteria.list();
        session.close();
        
        return listaDeFuncionarios;
            
        
    }
    
    @Override
    public ArrayList<Funcionarios> pesquisarFuncionariosPorNome(String nome) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(Funcionarios.class);
        criteria.add(Restrictions.like("nome", nome));
        ArrayList<Funcionarios> listaDeFuncionarios = (ArrayList<Funcionarios>) criteria.list();
        session.close();
        
        return listaDeFuncionarios;
           
        
    }
}
