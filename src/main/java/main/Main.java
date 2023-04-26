package main;

import GUI.Login_GUI;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
//            com.sun.java.swing.plaf.gtk.GTKLookAndFeel 
//            com.sun.java.swing.plaf.motif.MotifLookAndFeel 
//            com.sun.java.swing.plaf.windows.WindowsLookAndFeel                     
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            new Login_GUI().setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
