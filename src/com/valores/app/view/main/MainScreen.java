package com.valores.app.view.main;

import com.valores.app.model.controller.ControladorPlanilha;
import com.valores.app.view.configurator.ComponentsConfigurator;
import com.valores.app.view.panels.PainelFiltro;
import com.valores.app.view.panels.TabelaAcoes;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class MainScreen extends JFrame{
    
    private ComponentsConfigurator confComponents= new ComponentsConfigurator();
    private static JButton btnExportar;
    private static MainScreen instance;
    private String source = "/com/valores/app/view/imagens/";
    
    MainScreen() throws ParseException{
        initialize();
    }
    
    public static MainScreen getInstance() throws ParseException{
        if(instance == null){
            instance = new MainScreen();
        }return instance;
    }
    
    private void initialize() throws ParseException{
        setWindowSize();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Consulta a Base de Dados");
        this.setIconImage(getImage());
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, PainelFiltro.getInstance());
        JPanel tabela = TabelaAcoes.getInstance();
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        tabela.setBorder(border);
        this.add(BorderLayout.CENTER, tabela);
        
        
        btnExportar = confComponents.btnConfigurator
                    ("EXPORTAR",null, border, source+"xls.png");
        
         btnExportar.setMnemonic(KeyEvent.VK_S);
        btnExportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    ControladorPlanilha.getInstance().criaPanilha();
                    JOptionPane.showMessageDialog(null, "Planilha Criada com Sucesso! Arquivo disponivel em **C:/AcoesFiltradas**");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            null, "Nome da planilha inválido ou a planilha ja está aberta em seu dispositivo", 
                                                        "Erro ao criar planilha",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        JPanel pnlExportar = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlExportar.add(btnExportar);
        this.add(pnlExportar, BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private void setWindowSize(){
        int inset = 30;
        //captura a resolução da tela do usuário
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //cria uma magem externa na janela modelando seu tamanho de acordo com o inset;
        this.setBounds(inset, inset,
                  screenSize.width  - inset*2,
                  screenSize.height - inset*2);
    }
    
    public static void main(String[] args){
         try {
            //aplica o look and feel ao JFrame (TRUE configura a borda e FALSE nao configura).
            UIManager.put("Synthetica.window.decoration", Boolean.TRUE);
             //carrega o gerenciador de layouts UIMananger do Java
             //para a skin da synthetica funcionar devem-se carregar dois jars, um default da sintetica e o outro do layout que deseja utilizar.
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
            MainScreen.getInstance();
          //  ProcedureDAO.executar("1999-01-01", "2000-02-01", 30, 1000f);
         }
          catch(Exception e) {
                e.printStackTrace();
           }
    }
    
    public void desabilitar(){
        this.setEnabled(false);
    }
    
    public void habilitar(){
        this.setEnabled(true);
    }
    
    public Image getImage(){
        URL url = this.getClass().getResource(source+"MainIcon.png");
        Image icone  = Toolkit.getDefaultToolkit().getImage(url);
        return icone;
    }
    
    public void fechar(){
        System.exit(0);
    }
    
    public static void onButton(boolean estado){
        if(estado){
            btnExportar.setEnabled(true);
        }else{
            btnExportar.setEnabled(false);
        }
    }
}
