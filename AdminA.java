/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import javax.swing.JOptionPane;
/**
 *
 * @author RAMA
 */
public class AdminA extends Admin {
    @Override
    public void username() {
        System.out.println("AdminA");
    
}

    @Override
    public void password() {
        System.out.println("A12345");
    }
    @Override
    public void welcome() {
        JOptionPane.showMessageDialog(null,"Welcome Admin A");
    }
}
