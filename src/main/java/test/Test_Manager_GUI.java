
package test;

import GUI.Manager_GUI;
import javax.swing.JFrame;

public class Test_Manager_GUI extends JFrame{
    public Test_Manager_GUI(){        
        setSize(1025, 779);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
        add(new Manager_GUI());
        setVisible(true);                
    }
    public static void main(String[] args) {
        new Test_Manager_GUI();
    }
}
