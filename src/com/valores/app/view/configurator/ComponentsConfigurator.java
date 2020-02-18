package com.valores.app.view.configurator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;


public class ComponentsConfigurator {
    
    public JLabel configureJLabel(String text, Color color, Font font){
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(font);
        return label;
    }
    
    public JLabel configureJLabel(String text, Color color, Font font, Border border){
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(font);
        label.setBorder(border);
        return label;
    }
    
    //edição de botões completa
    public JButton btnConfigurator(String text, Color color, Border border, String source){
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setBorder(border);
        button.setMargin(new Insets(10 , 10, 10, 10));
        button.setIcon(new ImageIcon(getClass().getResource(source)));
        return button;
    }
    
    //edição de botões sem texto, somente com o icone
    public JButton btnConfigurator(Color color, Border border, String source, String description){
        JButton button = new JButton();
        button.setBackground(color);
        button.setBorder(border);
        button.setMargin(new Insets(10 , 10, 10, 10));
        button.setIcon(new ImageIcon(getClass().getResource(source)));
        button.setToolTipText(description);
        return button;
    }
    
    public JButton createEmptyButton(JButton button){
        button.setEnabled(false);
        return button;
    }
}
