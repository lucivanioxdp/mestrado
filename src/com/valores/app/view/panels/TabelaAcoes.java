package com.valores.app.view.panels;

import com.valores.app.dao.AcoesDAO;
import com.valores.app.view.main.TelaCarregamento;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TabelaAcoes extends JPanel{
    
    private static TabelaAcoes instance;
    private JTable tblAcoes;
    
    public TabelaAcoes(){
        inicializar();
    }
    
    public static TabelaAcoes getInstance(){
        if(instance == null){
           instance = new TabelaAcoes(); 
        }return instance;
    }
    
    private void inicializar(){
        this.setLayout(new BorderLayout());
        JScrollPane painelTabela = criaPainelTabela();
        this.add(painelTabela, BorderLayout.CENTER);
       
    }
    
    private JScrollPane criaPainelTabela(){
        AcoesTableModel tblModel = null;
        try {
            tblModel = new AcoesTableModel(AcoesDAO.getInstance().getAcoes());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                   null, "Erro ao buscar dados, "
                   ,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        tblAcoes = new JTable(tblModel);
        tblAcoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(tblAcoes);
        return scroll;
    }
    
    public void atualizaTabela(){
        AcoesTableModel model = (AcoesTableModel)tblAcoes.getModel();
        model.setIAcoes(AcoesDAO.getInstance().getAcoes());
        tblAcoes.repaint();
        tblAcoes.revalidate();
        //mensagem relatando que a busca não retornou nenhum resultado
        if(AcoesDAO.getInstance().buscaVazia){
            TelaCarregamento.getInstance().fecharTela();
            JOptionPane.showMessageDialog(
                   null, "A busca não retornou nenhum resultado, "+
                   "por favor verifique os parâmetros inseridos", 
                   "Erro ao buscar dados",JOptionPane.ERROR_MESSAGE);
        }
    }
}
