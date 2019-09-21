/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import view.MainView;

/**
 *
 * @author hugoluna
 */
public class MainController {
    
    private MainView mainView;

    private double intervalo;
    private int tiempo;
    private int T;
    private float amplitud[];
    private float frecuencia[];
    private int noTerminos;
    private float datos[];
    
    
    public MainController(MainView mainView) {
        
        this.mainView = mainView;
        this.mainView.setVisible(true);
        initEvents();
        configViews();
    }
    
    public void configViews(){
        mainView.btnGenerate.setEnabled(false);
    }
    
    
    
    public void initEvents(){
        
         mainView.btnAddAF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 getData();
                 
                 JOptionPane.showMessageDialog(mainView, "Ingresa datos en los siguientes campos desbloqueados");
                 
                 diableFields();
                 getDataAmFrec(mainView.terms.getSelectedIndex() +1);
                 
                
            }
        });
        
        
        mainView.btnGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               

            }
        });
        
       
        
        
    }
    
    
    public void getData(){
         
        T = Integer.parseInt(mainView.tField.getText().toString());
        intervalo = Double.parseDouble(mainView.intervalosField.getText().toString());
        tiempo = Integer.parseInt(mainView.tiempoField.getText().toString()); 
        initVectors(mainView.terms.getSelectedIndex() +1);
    }
    
    
    public void diableFields(){
        
        mainView.intervalosField.setEditable(false);
        mainView.tField.setEditable(false);
        mainView.tiempoField.setEditable(false);
        mainView.terms.setEnabled(false);
        
    }
    
    
    public void initVectors(int numTerms){
         
         amplitud = new float[numTerms];
         frecuencia = new float[numTerms];
    }
    
    
    public void getDataAmFrec(int numTerms){
        
        for (int i = 0; i < numTerms; i++) {
            float f = amplitud[i];
            
            String value = JOptionPane.showInputDialog(mainView, "Ingresa la frecuencia "+(i+1));
            frecuencia[i] = Float.parseFloat(value);
            String valueAmplitud = JOptionPane.showInputDialog(mainView, "Ingresa la amplitud "+(i+1));
            amplitud[i] = Float.parseFloat(value);
        }
        
    }
 
    
    
    
    
    
}
