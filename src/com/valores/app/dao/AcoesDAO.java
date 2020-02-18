package com.valores.app.dao;

import com.valores.app.connection.ConnectionFactory;
import com.valores.app.model.bean.Acoes;
import com.valores.app.view.main.TelaCarregamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

public class AcoesDAO {
    public boolean buscaVazia;
    private static AcoesDAO instance;
    
    public static AcoesDAO getInstance(){
        if (instance == null){
            instance = new AcoesDAO();
        }return instance;
    }
    
    public List<Acoes>getAcoes(){
        List<Acoes>acoes = null;
        Session session = (Session) new ConnectionFactory().getEntityManager();
     //  EntityManager em = new ConnectionFactory().getEntityManager();
       try{
           Criteria criteria = session.createCriteria(Acoes.class);
           criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("data_pregao_ini_M"));
           acoes = criteria.list();
       }catch(Exception e){
           TelaCarregamento.getInstance().fecharTela();
           JOptionPane.showMessageDialog
                        (null, "Erro de acesso ao Banco de Dados", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
       }finally{
           session.close();
       }
       if(acoes.size() < 1){
           buscaVazia = true;
       }else{
           buscaVazia = false;
       }
       return acoes;
    }
}
