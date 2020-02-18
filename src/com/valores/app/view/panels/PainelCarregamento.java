package com.valores.app.view.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelCarregamento extends JPanel{
    private static PainelCarregamento instance;
    String source = "/com/valores/app/view/imagens/";
    
    private PainelCarregamento(){
        inicializar();
    }
    
    public static PainelCarregamento getInstance(){
        if (instance == null){
            instance = new PainelCarregamento();
        }return instance;
    }
    
    public void inicializar(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(new Color(220,220,220));
        this.add(montaPainel(source+"loadDuo.gif"));
        this.setVisible(true);
    }
    public JLabel montaPainel(String source){
        ImageIcon icon = new ImageIcon(getClass().getResource(source));
        JLabel imagemCarregamento = new JLabel("", icon, JLabel.CENTER);
        return imagemCarregamento;
    }
    
}
