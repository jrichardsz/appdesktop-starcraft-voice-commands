/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rnasystems.com.voicegame.demo1;

import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JTextArea;
import org.linet.com.util.HandlerUtil;
import org.rnasystems.autojava.Autojava;
import org.rnasystems.com.voicegame.util.Constantes;
import org.rnasystems.com.voicegame.util.Propiedades;

/**
 *
 * @author RM-RCM
 */
public class EjecutaAccionStarCraft {

    public static int numero_suministro = 0;
    public static int[] coordenada_suministro = {0, 0};
    public static int[][] coordenadas_mineral;
    public static int[] coordenadas_comand_center;
    public static Point coordenada_suministro_inicial;
    public static Point coordenada_mineral_1;
    public static int[] size_suministro;
    public static int margen_suministro;
    public static ArrayList<Point> coordenadas_atake = new ArrayList<Point>();
    //92,81

    static {
        inicializaDimensionSuministro();
    }

    public static void ini() {
    }

    public static void reconoceAccion(String accion, JTextArea jTextAreaLog) {
        if (accion.equalsIgnoreCase(Acciones.INICIAR)) {
            //System.out.println("Accion reconozida:"+accion);
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            //recogerMineral();            
            //crearObrero();


        } else if (accion.equalsIgnoreCase(Acciones.GUARDAR_MINERAL)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            inicializaCoordenasMineral1();

        } else if (accion.equalsIgnoreCase(Acciones.GUARDAR_SUMINISTRO)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            inicializaCoordenasSuministro();

        } else if (accion.equalsIgnoreCase(Acciones.CREAR_SUMINISTRO)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            contruirSuministro();

        } else if (accion.equalsIgnoreCase(Acciones.CREAR_OBRERO)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            crearObrero();
        } else if (accion.equalsIgnoreCase(Acciones.BASE)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            irABase();
        } else if (accion.equalsIgnoreCase(Acciones.ENTRADA)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            irAEntrada();
        } else if (accion.equalsIgnoreCase(Acciones.GUARDAR_ATAKE)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            guardarCoordenaAtake();
        } else if (accion.equalsIgnoreCase(Acciones.ATACAR)) {
            jTextAreaLog.append("Accion reconozida:" + accion + "\n");
            guardarCoordenaAtake();
        } else {
            //System.out.println("Accion no reconozida:"+accion);
            jTextAreaLog.append("Accion no reconozida:" + accion + "\n");
        }
    }

    public static void atacar() {

        //seleccionamos el escuadradon de atake
        
        String event[] = new String[coordenadas_atake.size()];
        
        for(int a=0;a<coordenadas_atake.size();a++){
            
            
            
        }


        event[0] = "b";
        event[1] = "s";
        event[2] = "shift";
        actualizaCoordenasSuministro();
        event[3] = "izquierdo:" + coordenada_suministro[0] + "," + coordenada_suministro[1];
        event[4] = "derecho:" + coordenada_mineral_1.getX() + "," + coordenada_mineral_1.getY();
        Autojava.sendMultipleEvents(event);

    }

    public static void guardarCoordenaAtake() {
        coordenadas_atake.add(MouseInfo.getPointerInfo().getLocation());
    }

    public static void inicializaCoordenasMineral1() {
        //obtengo las coordenadas del mouse (coordenas iniciales del suminstro)
        if (coordenada_mineral_1 == null) {
            coordenada_mineral_1 = MouseInfo.getPointerInfo().getLocation();
        }
    }

    public static void inicializaDimensionSuministro() {
        String temp = Propiedades.getProperty(Constantes.SIZE_SUMINISTRO);
        String sum[] = temp.split(",");
        size_suministro = new int[2];
        int w = HandlerUtil.parseInteger(sum[0]);
        if (w < 0) {
            w = 150;
        }
        int h = HandlerUtil.parseInteger(sum[1]);
        if (h < 0) {
            h = 150;
        }

        //dimensiones de un suministro
        size_suministro[0] = w;
        size_suministro[1] = h;

        // margen entre suministro y suministro
        margen_suministro = HandlerUtil.parseInteger(Propiedades.getProperty(Constantes.MARGEN_SUMINISTRO));

    }

//    public static void inicializaCoordenadasMineral() {
//        String temp = Propiedades.getProperty(Constantes.ZONA_ESTE_MINERAL);
//        String min[] = temp.split(";");
//        coordenadas_mineral = new int[min.length][2];
//
//        for (int i = 0; i < min.length; i++) {
//            String xy_temp[] = min[i].split(",");
//            coordenadas_mineral[i][0] = Integer.parseInt(xy_temp[0]);
//            coordenadas_mineral[i][1] = Integer.parseInt(xy_temp[1]);
//        }
//
//    }
//    private static void recogerMineral() {
//        seleccionarObrero1();
//        seleccionarObrero2();
//        seleccionarObrero3();
//        seleccionarObrero4();
//        seleccionarObrero5();
//        seleccionarObrero6();
//    }
    private static void irABase() {
        // nos situamos en la base
        Autojava.sendKey(Propiedades.getProperty(Constantes.HOTKEY_IR_BASE));
    }

    private static void irAEntrada() {
        // nos situamos en la base
        Autojava.sendKey(Propiedades.getProperty(Constantes.HOTKEY_IR_ENTRADA));
    }

    private static void seleccionarABase() {
        // nos situamos en la base
        Autojava.sendKey(Propiedades.getProperty(Constantes.HOTKEY_SELECCIONAR_BASE));
    }

    private static void crearObrero() {
        seleccionarABase();
        Autojava.sendKey("s");
    }

    private static void inicializaCoordenasSuministro() {

        //obtengo las coordenadas del mouse (coordenas iniciales del suminstro)
        if (coordenada_suministro_inicial == null) {
            coordenada_suministro_inicial = MouseInfo.getPointerInfo().getLocation();
            coordenada_suministro[0] += (int) coordenada_suministro_inicial.getX();
            coordenada_suministro[1] += (int) coordenada_suministro_inicial.getY();
        }
    }

    public static void actualizaCoordenasSuministro() {
        //aumentamos la coordenada y
        coordenada_suministro[1] += coordenada_suministro[1] + size_suministro[1] + numero_suministro + margen_suministro;
        numero_suministro++;
    }

    private static void contruirSuministro() {

        irABase();

        String event[] = new String[5];

        event[0] = "b";
        event[1] = "s";
        event[2] = "shift";
        actualizaCoordenasSuministro();
        event[3] = "izquierdo:" + coordenada_suministro[0] + "," + coordenada_suministro[1];
        event[4] = "derecho:" + coordenada_mineral_1.getX() + "," + coordenada_mineral_1.getY();
        Autojava.sendMultipleEvents(event);

    }

    public static void seleccionarObrero1() {
        String pos_ini = Propiedades.getProperty(Constantes.ZONA_ESTE_POSINI_OB1);
        int[] pos_inin_obr = HandlerUtil.getCoordenadas(pos_ini);
        Autojava.mouseClic(pos_inin_obr[0], pos_inin_obr[1], "izquierdo");

        //marcamos este obrero como el que contruira lso suministros
        String event[] = new String[2];
        event[0] = "control";
        event[1] = "9";
        Autojava.sendMultipleEvents(event);

        Autojava.mouseClic(coordenadas_mineral[0][0], coordenadas_mineral[0][1], "derecho");


    }

    public static void seleccionarObrero2() {
        String pos_ini = Propiedades.getProperty(Constantes.ZONA_ESTE_POSINI_OB2);
        int[] pos_inin_obr = HandlerUtil.getCoordenadas(pos_ini);
        Autojava.mouseClic(pos_inin_obr[0], pos_inin_obr[1], "izquierdo");

        Autojava.mouseClic(coordenadas_mineral[1][0], coordenadas_mineral[1][1], "derecho");
    }

    public static void seleccionarObrero3() {
        String pos_ini = Propiedades.getProperty(Constantes.ZONA_ESTE_POSINI_OB3);
        int[] pos_inin_obr = HandlerUtil.getCoordenadas(pos_ini);
        Autojava.mouseClic(pos_inin_obr[0], pos_inin_obr[1], "izquierdo");

        Autojava.mouseClic(coordenadas_mineral[2][0], coordenadas_mineral[2][1], "derecho");
    }

    public static void seleccionarObrero4() {
        String pos_ini = Propiedades.getProperty(Constantes.ZONA_ESTE_POSINI_OB4);
        int[] pos_inin_obr = HandlerUtil.getCoordenadas(pos_ini);
        Autojava.mouseClic(pos_inin_obr[0], pos_inin_obr[1], "izquierdo");

        Autojava.mouseClic(coordenadas_mineral[3][0], coordenadas_mineral[3][1], "derecho");
    }

    public static void seleccionarObrero5() {
        String pos_ini = Propiedades.getProperty(Constantes.ZONA_ESTE_POSINI_OB5);
        int[] pos_inin_obr = HandlerUtil.getCoordenadas(pos_ini);
        Autojava.mouseClic(pos_inin_obr[0], pos_inin_obr[1], "izquierdo");

        Autojava.mouseClic(coordenadas_mineral[4][0], coordenadas_mineral[4][1], "derecho");
    }

    public static void seleccionarObrero6() {
        String pos_ini = Propiedades.getProperty(Constantes.ZONA_ESTE_POSINI_OB6);
        int[] pos_inin_obr = HandlerUtil.getCoordenadas(pos_ini);
        Autojava.mouseClic(pos_inin_obr[0], pos_inin_obr[1], "izquierdo");

        Autojava.mouseClic(coordenadas_mineral[5][0], coordenadas_mineral[5][1], "derecho");
    }
}
