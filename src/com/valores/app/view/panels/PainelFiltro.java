package com.valores.app.view.panels;

import com.valores.app.dao.AcoesDAO;
import com.valores.app.dao.ProcedureDAO;
import com.valores.app.model.TipoPeriodo;
import com.valores.app.model.controller.CalculadoraData;
import com.valores.app.view.configurator.ComponentsConfigurator;
import com.valores.app.view.main.MainScreen;
import com.valores.app.view.main.TelaCarregamento;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.MaskFormatter;

public class PainelFiltro extends JPanel{
    private ComponentsConfigurator confComponents= new ComponentsConfigurator();
    private String source = "/com/valores/app/view/imagens/";
    private JLabel lblDataInicio, lblDataLimite, lblValorDias, lblPeriodo, lblQtdSemanasR;
    private JFormattedTextField txtDataInicio, txtDataLimite; 
    private JTextField txtNumeroDias, txtQtdSemanaR;
    private JComboBox cbxPeriodo;
    private JButton btnBuscar;
    private boolean erro;
    private static PainelFiltro instance;
    
    private PainelFiltro() throws ParseException{
        initialize();
    }
    
    public static PainelFiltro getInstance() throws ParseException{
        if(instance == null){
            instance = new PainelFiltro();
        }return instance;
    }
    
    private void initialize(){
        this.setLayout(new BorderLayout());
        this.add(montaPainelFiltro(), BorderLayout.NORTH);
        this.add(montaPnlButton(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private JPanel montaPainelFiltro(){
        JPanel pnlFiltro = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Border border = BorderFactory.createEmptyBorder(1, 1, 1, 30);
        
        lblDataInicio = new JLabel("<html><h3>Data Início</h3></html>");
        lblDataLimite = new JLabel("<html><h3>Data Limite</h3></html>");
        lblValorDias = new JLabel("<html><h3>Nº Base</h3></html>");
        lblPeriodo = new JLabel("<html><h3>Período</h3></html>");
        lblQtdSemanasR = new JLabel("<html><h3>Semanas Retenção</h3></html>");
        try {
            txtDataInicio = new JFormattedTextField(new MaskFormatter("##/##/####"));
            txtDataLimite = new JFormattedTextField(new MaskFormatter("##/##/####"));
        } catch (ParseException ex) {
            Logger.getLogger(PainelFiltro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtNumeroDias = new JTextField();
        txtQtdSemanaR = new JTextField();
        cbxPeriodo = new JComboBox(TipoPeriodo.values());
        
       JPanel pnlDataInicio = criarBlocoFiltro(lblDataInicio, txtDataInicio);
            pnlDataInicio.setBorder(border);
       JPanel pnlDataLimite = criarBlocoFiltro(lblDataLimite, txtDataLimite); 
            pnlDataLimite.setBorder(border);
       JPanel pnlPeriodo = criarBlocoFiltro(lblPeriodo, cbxPeriodo);
            pnlPeriodo.setBorder(border);
       JPanel pnlQtDias = criarBlocoFiltro(lblValorDias, txtNumeroDias);
            pnlQtDias.setBorder(border);
       JPanel pnlValor = criarBlocoFiltro(lblQtdSemanasR, txtQtdSemanaR);
            pnlValor.setBorder(border);
            
       pnlFiltro.add(pnlDataInicio);
       pnlFiltro.add(pnlDataLimite);
       pnlFiltro.add(pnlPeriodo);
       pnlFiltro.add(pnlQtDias);
       pnlFiltro.add(pnlValor);
       return pnlFiltro;
    }
    
    private JPanel criarBlocoFiltro(JComponent titulo, JComponent conteudo){
        JPanel bloco = new JPanel(new GridLayout(2, 1));
        bloco.add(titulo);
        bloco.add(conteudo);
        return bloco;
    }
    
    private JPanel montaPnlButton(){
        JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
         Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        btnBuscar = confComponents.btnConfigurator
                    ("BUSCAR",null, border, source+"search.png");
        btnBuscar.setMnemonic(KeyEvent.VK_S);
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //código para executar em paralelo
                        TelaCarregamento.getInstance();
                        //disabilita botão buscar
                        btnBuscar.setEnabled(false);
                        //desabilita botao exportar
                        MainScreen.onButton(false);
                        try {
                            erro = false;
                            calcular();
                        } catch (ParseException ex) {
                            erro = true;
                            TelaCarregamento.getInstance().fecharTela();
                            JOptionPane.showMessageDialog(
                                    null, "Campos vazios ou inseridos incorretamente", "Erro ao buscar dados",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        //fim do carregamento
                        TabelaAcoes.getInstance().atualizaTabela();
                        //fecha tela de loading...
                        TelaCarregamento.getInstance().fecharTela();
                        //habilita botão buscar
                        btnBuscar.setEnabled(true);
                        //habilita botão exportar
                        MainScreen.onButton(true);
                        if(!erro){
                                JOptionPane.showMessageDialog(null, "Processamento Concluído! " +
                                        "Clique no botão **EXPORTAR** para criar uma planilha com os resultados");
                            }
                    }
                }).start();
            }
        });

        pnlButton.add(btnBuscar);
        pnlButton.setBorder(border);
        return pnlButton;
    }
    
    public String getData(JFormattedTextField txt) throws ParseException{
        //recupera a data do JFormattedText enviado
        String data = txt.getText();
        String dataFormatada = "";
         //cria um formatador no padrão brasileiro
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        //variavel que irá guardar a data
        Date txtData = null;
            //converteu o texto de data em um objeto data
            txtData = formato.parse(data);
            //cria um formatador de data para o padrão do banco de dados
            SimpleDateFormat formatoDataBD = new SimpleDateFormat("yyyy/MM/dd");
            //guarda o valor da conversão em uma String
            dataFormatada = formatoDataBD.format(txtData);
        return dataFormatada;
    }
    
    //facilitador de uso da procedure
    public void calcular() throws ParseException{
        int dias = 0;
        int diasRetencao = 0;
        
        try{
            dias = Integer.parseInt(txtNumeroDias.getText());
        }catch(Exception ex){
            TelaCarregamento.getInstance().fecharTela();
            erro = true;
            JOptionPane.showMessageDialog(
               null, "Insira um valor numério no campo **Nº Dias**", 
                                                              "Valor Incorreto",
                                                       JOptionPane.ERROR_MESSAGE);
        }
        
        try{
            diasRetencao = Integer.parseInt(txtQtdSemanaR.getText());
        }catch(Exception ex){
            TelaCarregamento.getInstance().fecharTela();
            erro = true;
            JOptionPane.showMessageDialog(
               null, "Insira um valor numério no campo **Semanas Retenção**", 
                                                              "Valor Incorreto",
                                                       JOptionPane.ERROR_MESSAGE);
        }
        
        int tempoR = 7;
        if(cbxPeriodo.getSelectedIndex() == 0){
            //corrigindo erro do banco que avança 2 semanas da data escolhida, subtraindo  2 semanas da data estipulada
                ProcedureDAO.executar(CalculadoraData.subtarirData(0, getData(txtDataInicio)),
                CalculadoraData.subtarirData(0, getData(txtDataLimite)), dias*7, diasRetencao*tempoR,0);
        }
        
        if(cbxPeriodo.getSelectedIndex() == 1){
            //corrigindo erro do banco que avança 2 semanas da data escolhida, subtraindo  2 semanas da data estipulada
                ProcedureDAO.executar(CalculadoraData.subtarirData(0, getData(txtDataInicio)),
                CalculadoraData.subtarirData(0, getData(txtDataLimite)), dias*15, diasRetencao*tempoR,0);
        }
        
        if(cbxPeriodo.getSelectedIndex() == 2){
            //corrigindo erro do banco que avança 2 semanas da data escolhida, subtraindo  2 semanas da data estipulada
                ProcedureDAO.executar(CalculadoraData.subtarirData(0, getData(txtDataInicio)),
                CalculadoraData.subtarirData(0, getData(txtDataLimite)), dias*30, diasRetencao*tempoR,0);
        }
        
        if(cbxPeriodo.getSelectedIndex() == 3){
            //corrigindo erro do banco que avança 2 semanas da data escolhida, subtraindo  2 semanas da data estipulada
                ProcedureDAO.executar(CalculadoraData.subtarirData(0, getData(txtDataInicio)),
                CalculadoraData.subtarirData(0, getData(txtDataLimite)), dias*60, diasRetencao*tempoR,0);
        }
        
        if(cbxPeriodo.getSelectedIndex() == 4){
            //corrigindo erro do banco que avança 2 semanas da data escolhida, subtraindo  2 semanas da data estipulada
                ProcedureDAO.executar(CalculadoraData.subtarirData(0, getData(txtDataInicio)),
                CalculadoraData.subtarirData(0, getData(txtDataLimite)), dias*120, diasRetencao*tempoR,0);
        }
        
        if(cbxPeriodo.getSelectedIndex() == 5){
            //corrigindo erro do banco que avança 2 semanas da data escolhida, subtraindo  2 semanas da data estipulada
                ProcedureDAO.executar(CalculadoraData.subtarirData(0, getData(txtDataInicio)),
                CalculadoraData.subtarirData(0, getData(txtDataLimite)), dias*180, diasRetencao*tempoR,0);
        }
    }  
                    
}

