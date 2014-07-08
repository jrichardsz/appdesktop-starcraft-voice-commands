/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
public class TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       System.out.println("ini"); 
         try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_F5);
                System.out.println("fin");
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
    }
    
    
    
}
