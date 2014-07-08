/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rnasystems.autojava;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author RM-RCM
 */
public class Autojava {
    
    public static int CLIC_DERECHO = InputEvent.BUTTON3_MASK;
    public static int CLIC_IZQUIERDO = InputEvent.BUTTON1_MASK;
    public static int CLIC_EVENT = 0;
    public static int KEY_EVENT = 1;
    public static String STRING_CLIC_IZQUIERDO = "IZQUIERDO";
    public static String STRING_CLIC_DERECHO = "DERECHO";
    public static HashMap<String, Integer> TECLAS = new HashMap<String, Integer>();
    
    static {
        
        TECLAS.put("A", KeyEvent.VK_A);
        TECLAS.put("B", KeyEvent.VK_B);
        TECLAS.put("C", KeyEvent.VK_C);
        TECLAS.put("D", KeyEvent.VK_D);
        TECLAS.put("E", KeyEvent.VK_E);
        TECLAS.put("F", KeyEvent.VK_F);
        TECLAS.put("G", KeyEvent.VK_G);
        TECLAS.put("H", KeyEvent.VK_H);
        TECLAS.put("I", KeyEvent.VK_I);
        TECLAS.put("J", KeyEvent.VK_J);
        TECLAS.put("K", KeyEvent.VK_K);
        TECLAS.put("L", KeyEvent.VK_L);
        TECLAS.put("M", KeyEvent.VK_M);
        TECLAS.put("N", KeyEvent.VK_N);
        TECLAS.put("O", KeyEvent.VK_O);
        TECLAS.put("P", KeyEvent.VK_P);
        TECLAS.put("Q", KeyEvent.VK_Q);
        TECLAS.put("R", KeyEvent.VK_R);
        TECLAS.put("S", KeyEvent.VK_S);
        TECLAS.put("T", KeyEvent.VK_T);
        TECLAS.put("U", KeyEvent.VK_U);
        TECLAS.put("V", KeyEvent.VK_V);
        TECLAS.put("W", KeyEvent.VK_W);
        TECLAS.put("X", KeyEvent.VK_X);
        TECLAS.put("Y", KeyEvent.VK_Y);
        TECLAS.put("Z", KeyEvent.VK_Z);
        
        TECLAS.put("SHIFT", KeyEvent.VK_SHIFT);
        TECLAS.put("CONTROL", KeyEvent.VK_CONTROL);
        TECLAS.put("ALT", KeyEvent.VK_ALT);
        TECLAS.put("TAB", KeyEvent.VK_TAB);
        
        TECLAS.put("F5", KeyEvent.VK_F5);
        TECLAS.put("F6", KeyEvent.VK_F6);
        TECLAS.put("F7", KeyEvent.VK_F7);
        TECLAS.put("F8", KeyEvent.VK_F8);
        TECLAS.put("F9", KeyEvent.VK_F9);
        TECLAS.put("F10", KeyEvent.VK_F10);
        TECLAS.put("F11", KeyEvent.VK_F11);
        TECLAS.put("F12", KeyEvent.VK_F12);
        
        TECLAS.put("0", KeyEvent.VK_0);
        TECLAS.put("1", KeyEvent.VK_1);
        TECLAS.put("2", KeyEvent.VK_2);
        TECLAS.put("3", KeyEvent.VK_3);
        TECLAS.put("4", KeyEvent.VK_4);
        TECLAS.put("5", KeyEvent.VK_5);
        TECLAS.put("6", KeyEvent.VK_6);
        TECLAS.put("7", KeyEvent.VK_7);
        TECLAS.put("8", KeyEvent.VK_8);
        TECLAS.put("9", KeyEvent.VK_9);
        
    }
    
    public static void mouseClic(int x, int y, String clic) {
        if (clic.toUpperCase().equals(Autojava.STRING_CLIC_DERECHO)) {
            
            try {
                Robot robot = new Robot();
                robot.mouseMove(x, y);
                robot.mousePress(Autojava.CLIC_DERECHO);
                robot.mouseRelease(Autojava.CLIC_DERECHO);
                
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        } else if (clic.toUpperCase().equals(Autojava.STRING_CLIC_IZQUIERDO)) {
            try {
                Robot robot = new Robot();
                robot.mouseMove(x, y);
                robot.mousePress(Autojava.CLIC_IZQUIERDO);
                robot.mouseRelease(Autojava.CLIC_IZQUIERDO);
                
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void mouseClic(int x, int y, int clic) {

            try {
                Robot robot = new Robot();
                robot.mouseMove(x, y);
                robot.mousePress(clic);
                robot.mouseRelease(clic);
                
            } catch (AWTException ex) {
                ex.printStackTrace();
            }

    }    
    
    public static void sendKey(String tecla) {
        try {
            Robot robot = new Robot();
            robot.keyPress(TECLAS.get(tecla.toUpperCase()));
            robot.keyRelease(TECLAS.get(tecla.toUpperCase()));
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void sendMultipleEvents(String events[]) {
        try {
            Robot robot = new Robot();
            ArrayList<Integer> teclasPresionadas = new ArrayList<Integer>();
            for (String event : events) {
                event = event.toUpperCase();
                switch (getTipoEvento(event)) {
                    
                    case 0:/*tipo event*/
                        int[] coor = getCoordenadas(event);
                        mouseClic(coor[0],coor[1],getClic(event));
                        break;
                    
                    case 1:/*tipo key*/
                        robot.keyPress(TECLAS.get(event));
                        teclasPresionadas.add(Integer.valueOf(TECLAS.get(event)));
                        break;
                }
            }
            
            //soltamos las teclas
            for(Integer i:teclasPresionadas){
               robot.keyRelease(i.intValue()); 
            }
            
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void combineKeyPress(String teclas[], String clic) {
        try {
            Robot robot = new Robot();
            for (String tecla : teclas) {
                robot.keyPress(TECLAS.get(tecla));
            }
        } catch (AWTException ex) {
            ex.printStackTrace();
        }
    }
    
    public static int getTipoEvento(String event) {
        event = event.toUpperCase();
        
        if (!event.contains(":")) {
            if (TECLAS.get(event) != null) {
                return KEY_EVENT;                
            } else {
                throw new IllegalArgumentException("No se encuentra tipo de evento.");
            }
        } else {
            
            String tipo[] = event.split(":");
            if (tipo == null || tipo.length != 2) {
                throw new IllegalArgumentException("No se encuentra tipo de clic.");
            }
            
            String clic = tipo[0].toUpperCase();
            
            if (!clic.equalsIgnoreCase(Autojava.STRING_CLIC_DERECHO) && !clic.equalsIgnoreCase(Autojava.STRING_CLIC_IZQUIERDO)) {
                throw new IllegalArgumentException("Tipo de clic incorrecto.");
            }
            return CLIC_EVENT;
        }
    }
    
    public static int getClic(String event) {
        
        
        String tipo[] = event.split(":");
        if (tipo == null || tipo.length != 2) {
            throw new IllegalArgumentException("No se encuentra tipo de clic.");
        }
        
        String clic = tipo[0].toUpperCase();
        
        if (clic.equalsIgnoreCase(Autojava.STRING_CLIC_DERECHO)) {
           return CLIC_DERECHO;
        }
        
        if (clic.equalsIgnoreCase(Autojava.STRING_CLIC_IZQUIERDO)) {
           return CLIC_IZQUIERDO;
        }
        
        return -1;
        
    }
    
    public static int[] getCoordenadas(String event) {
        
        
        String tipo[] = event.split(":");
        if (tipo == null || tipo.length != 2) {
            throw new IllegalArgumentException("No se encuentra tipo de clic.");
        }
        
        String cad_coordenadas = tipo[1].toUpperCase();
        String coordenadas[] = cad_coordenadas.split(",");
        
        int[] coord = {Integer.parseInt(coordenadas[0]),Integer.parseInt(coordenadas[1])};
        
        
        return coord;
        
    }    
}
