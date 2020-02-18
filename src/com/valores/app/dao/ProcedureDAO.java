package com.valores.app.dao;

import com.valores.app.connection.ConnectionFactory;
import com.valores.app.view.main.TelaCarregamento;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.swing.JOptionPane;

public class ProcedureDAO {
    
    public static void executar(String dataInicio, String dataFim, int qtDias,int qtDiasR, float valorInvestimento){
       EntityManager em = new ConnectionFactory().getEntityManager();
       try{
            StoredProcedureQuery query = em
             .createStoredProcedureQuery("processar")
             .registerStoredProcedureParameter(
                 "dataini",
                 String.class,
                 ParameterMode.IN
             )
             .registerStoredProcedureParameter(
                 "datafinall",
                 String.class,
                 ParameterMode.IN
             )
             .registerStoredProcedureParameter(
                 "qtdsem",
                 Integer.class,
                 ParameterMode.IN
             )
             .registerStoredProcedureParameter(
                 "qtdsemm",
                 Integer.class,
                 ParameterMode.IN
             )
             .registerStoredProcedureParameter(
                 "calcvalor",
                 Float.class,
                 ParameterMode.IN
             );

             query.setParameter("dataini", dataInicio);
             query.setParameter("datafinall", dataFim);
             query.setParameter("qtdsem", qtDias);
             query.setParameter("qtdsemm", qtDiasR);
             query.setParameter("calcvalor", valorInvestimento);
             query.execute();
             
              StoredProcedureQuery consulta = em
             .createStoredProcedureQuery("consulta");
              consulta.execute();

       }catch(Exception ex){
           TelaCarregamento.getInstance().fecharTela();
           JOptionPane.showMessageDialog
                        (null, "Erro #345, parâmetros inseridos incorretamente", 
                                          "Erro", JOptionPane.ERROR_MESSAGE);
       }finally{
            em.close();
       }
   }
}
