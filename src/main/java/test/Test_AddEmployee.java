
package test;

import GUI.AddEmployeeForm;
import GUI.Manager_GUI;

public class Test_AddEmployee {
    public static void main(String[] args) {
        new AddEmployeeForm(new Manager_GUI()).setVisible(true);
    }
}
