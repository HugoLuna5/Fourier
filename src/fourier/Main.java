/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourier;

import controller.MainController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mdlaf.MaterialLookAndFeel;
import view.MainView;

/**
 *
 * @author hugoluna
 */
public class Main {
    
    
    public static void main(String[] args) {
        initMaterialDesign();
        new MainController(new MainView());
        
    }
    
    
    public static void initMaterialDesign() {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    
}
