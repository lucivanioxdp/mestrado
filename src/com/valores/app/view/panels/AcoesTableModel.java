package com.valores.app.view.panels;

import com.valores.app.model.bean.Acoes;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class AcoesTableModel implements TableModel{
private List<Acoes>acoes;

public AcoesTableModel(List<Acoes> carteiras){
    this.acoes = carteiras;
}
    @Override
    public int getRowCount() {
         return acoes.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex){
            case 0:
                return "COD";
            case 1:
                return "NOME RESUMIDO";
            case 2: 
                return "DATA INICIAL";
            case 3:
                return "DATA FINAL";
            case 4:
                return "VALOR INICIAL";
            case 5:
                return "VALOR FINAL";
            case 6:
                return "RENDIMENTO";
            case 7:
                return "RETORNO STATUS";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return Float.class;
            case 7:
                return String.class;
        }
        return void.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Acoes acaoAtual = acoes.get(rowIndex);
        switch(columnIndex){
            case 0:
                return acaoAtual.getCod_neg_papel();
            case 1:
                return acaoAtual.getNome_resumido_ini();
            case 2:
                return acaoAtual.getData_per_ini_R();
            case 3:
                return acaoAtual.getData_per_fim_R();
            case 4:
                return acaoAtual.getPreult_ini();
            case 5:
                return acaoAtual.getPreult_fim();
            case 6:
                return acaoAtual.getCalc_rend_R();
            case 7:
                return acaoAtual.getVenc_perd();
        }
        return "";
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        
    }
    
    Acoes getAcao(int linha){
        return acoes.get(linha);
    }
    
    void setIAcoes(List<Acoes> acoes){
        this.acoes = acoes;
    }
    
}
