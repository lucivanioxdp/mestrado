package com.valores.app.model.controller;

import com.valores.app.dao.AcoesDAO;
import com.valores.app.model.bean.Acoes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ControladorPlanilha {
    
    private String[] tituloColuna;
    private static ControladorPlanilha instance;
    
    public static ControladorPlanilha getInstance(){
        if(instance == null){
            instance = new ControladorPlanilha();
        }return instance;
    }
    
    public void criaPanilha() throws FileNotFoundException, IOException{
        nomearColunas();
        String nomePlanilha = JOptionPane.showInputDialog("Digite um nome para a planilha", "não utilize caracteres especiais");
        
        File filetes = new File("C:/AcoesFiltradas");  

        if (!filetes.exists()) {
            filetes.mkdirs();
        }
        
        FileOutputStream file = new FileOutputStream("C:/AcoesFiltradas/"+nomePlanilha+".xls");
        
        //cria pasta de trabalho do Excel
        Workbook pastaTrabalho = new HSSFWorkbook();
        
        //cria a planilha
        Sheet planilha = pastaTrabalho.createSheet("Acoes");
        
        //cria linha
        Row linha = planilha.createRow(0);
        
        //Cria celulas
        for(int i = 0; i<tituloColuna.length;i++){
            Cell celula = linha.createCell(i);
            celula.setCellValue(tituloColuna[i]);
            planilha.setColumnWidth(i,tituloColuna[i].length()*300);
        }
            List<Acoes> acoes = AcoesDAO.getInstance().getAcoes();
           
            for(int i = 0; i< acoes.size();i++){
                Row dados = planilha.createRow(i+1);
                
                String codNeg = acoes.get(i).getCod_neg_papel();
                Cell celula1 = dados.createCell(0);
                celula1.setCellValue(codNeg);
                
                String nomeResumido = acoes.get(i).getNome_resumido_fim();
                Cell celula2 = dados.createCell(1);
                celula2.setCellValue(nomeResumido);
                
                String especi = acoes.get(i).getEspeci_fim();
                Cell celula3 = dados.createCell(2);
                celula3.setCellValue(especi);
                
                String modRef = acoes.get(i).getModref_fim();
                Cell celula4 = dados.createCell(3);
                celula4.setCellValue(modRef);
                
                String dataIniPregao = acoes.get(i).getData_per_ini_M();
                Cell celula5 = dados.createCell(4);
                celula5.setCellValue(dataIniPregao);
                
                String dataFimPregao = acoes.get(i).getData_per_fim_M();
                Cell celula6 = dados.createCell(5);
                celula6.setCellValue(dataFimPregao);
                
                float preIniM = acoes.get(i).getPreult_ini_M();
                Cell celula7 = dados.createCell(6);
                celula7.setCellValue(preIniM);
                
                float preFimM = acoes.get(i).getPreult_fim_M();
                Cell celula8 = dados.createCell(7);
                celula8.setCellValue(preFimM);
                
                float rendimentoM = acoes.get(i).getCalc_rend_M();
                Cell celula9 = dados.createCell(8);
                celula9.setCellValue(rendimentoM);
                
                String venc_perd = acoes.get(i).getVenc_perd();
                Cell celula10 = dados.createCell(9);
                celula10.setCellValue(venc_perd);
                
                String dataIniR = acoes.get(i).getData_per_ini_R();
                Cell celula11 = dados.createCell(10);
                celula11.setCellValue(dataIniR);
                
                String dataFimR = acoes.get(i).getData_per_fim_R();
                Cell celula12 = dados.createCell(11);
                celula12.setCellValue(dataFimR);
                
                float preIniR = acoes.get(i).getPreult_ini();
                Cell celula13 = dados.createCell(12);
                celula13.setCellValue(preIniR);
                
                float preFimR = acoes.get(i).getPreult_fim();
                Cell celula14 = dados.createCell(13);
                celula14.setCellValue(preFimR);
                
                float rendimentoR = acoes.get(i).getCalc_rend_R();
                Cell celula15 = dados.createCell(14);
                celula15.setCellValue(rendimentoR);

                String tipo_registro_ini = acoes.get(i).getTipo_registro_ini();
                Cell celula16 = dados.createCell(15);
                celula16.setCellValue(tipo_registro_ini);
                
                String tipo_mercado_ini = acoes.get(i).getTipo_mercado_ini();
                Cell celula17 = dados.createCell(16);
                celula17.setCellValue(tipo_mercado_ini);
                
                String dismes_fin = acoes.get(i).getDismes_fim();
                Cell celula18 = dados.createCell(17);
                celula18.setCellValue(dismes_fin);
            }
        //Passando os dados inseridos para um arquivo
        pastaTrabalho.write(file);
        
        //fechamento do arquivo criado
        file.close();
        

    }
    
    private void nomearColunas(){
        String[] nomes = {"Cod_neg_papel","Nome_resumido_fim","Especi_fim",
            "Modref_fim","Data_pregao_ini_M","Data_pregao_fim_M","Preult_ini_M","Preult_fim_M","Calc_rend_M",
            "Venc_perd","Data_per_ini_R","Data_per_fim_R", "Preult_ini_R","Preult_fim_R","Calc_rend_R",
            "Tipo_registro_ini","Tipo_mercado_ini","Dismes_fim"};
        tituloColuna = nomes;
    }
}
