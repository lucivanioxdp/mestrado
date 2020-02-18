package com.valores.app.connection;

import com.valores.app.view.main.MainScreen;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ConnectionFactory {
   private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    
    public EntityManager getEntityManager(){
        if(entityManager==null){
            try{
            entityManagerFactory = 
                    Persistence.createEntityManagerFactory("acoesPU");
            entityManager = entityManagerFactory.createEntityManager();
            }catch(Exception ex){
                    JOptionPane.showMessageDialog(
                   null, "BANCO DE DADOS INDISPONÍVEL"
                   ,"Erro",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
            }
        }
        return entityManager;
    }
    
    public void fechar(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
