
package test;

import GUI.Statistical_GUI;
import javax.swing.JFrame;

public class Test_Statistical extends JFrame {
    public Test_Statistical(){        
        setTitle("Thống Kê");
        setSize(1025, 779);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add(new Statistical_GUI());
        setVisible(true);
    }
    public static void main(String[] args) {
        new Test_Statistical();
    }
}
