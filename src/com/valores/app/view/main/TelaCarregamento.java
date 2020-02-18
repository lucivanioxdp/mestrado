package com.valores.app.view.main;

import com.valores.app.view.configurator.ComponentsConfigurator;
import com.valores.app.view.panels.PainelCarregamento;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class TelaCarregamento extends JWindow{
    private String source = "/com/valores/app/view/imagens/";
    private static TelaCarregamento instance;
    private TelaCarregamento(){
        inicializar();
        addMouseMotionListener(new MouseMotionListener() {
    private int mx, my;

    @Override
    public void mouseMoved(MouseEvent e) {
        mx = e.getXOnScreen();
        my = e.getYOnScreen();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = TelaCarregamento.this.getLocation();
        p.x += e.getXOnScreen() - mx;
        p.y += e.getYOnScreen() - my;
        mx = e.getXOnScreen();
        my = e.getYOnScreen();
        TelaCarregamento.this.setLocation(p);
    }
        });
    }
    
    public static TelaCarregamento getInstance(){
        if (instance == null){
            instance = new TelaCarregamento();
        }return instance;
    }
    
    private void inicializar(){
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        centralizarJanela();
        this.setBackground(Color.yellow);
        this.add(BorderLayout.CENTER, PainelCarregamento.getInstance());
        this.add(BorderLayout.SOUTH, setTexto());
        this.setVisible(true);
        this.setAlwaysOnTop(true);
    }
    
    private JPanel setTexto(){
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painel.setBackground(new Color(128,128,128));
        String texto = "<html><h3>Processando Dados...</h3></html>";
        JLabel lblCarregamento = new JLabel(texto);
        lblCarregamento.setForeground(Color.WHITE);
        painel.add(lblCarregamento);
        return painel;
    }
    
    private void centralizarJanela(){
         Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
         this.setLocation
        ((d.width - this.getSize().width)/2, (d.height - this.getSize().height)/2);
    }
    
    public void windowFuncion
        (String title, boolean resizable, 
                boolean closable, boolean maximizable, boolean iconifiable){
        
        
    }
        
    public void fecharTela(){
        this.dispose();
        clean();
    }
    
    public void clean(){
        instance = null;
    }
}
