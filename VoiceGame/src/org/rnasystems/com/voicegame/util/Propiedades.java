package org.rnasystems.com.voicegame.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.linet.com.util.archivos.ArchivoUtil;

/**
 * @author Richard Leon Ingaruca
 *
 */
public class Propiedades {

    private static Propiedades instance = null;
    private Properties propert = null;

    /**
     * Metodo que permite obtener una sola instancia de la clase Propiedades(Singleton)
     * @return
     */
    private static Propiedades getInstance() {
        if (instance == null) {
            instance = new Propiedades();
        }
        return instance;
    }

    /**
     * Constructor por defecto
     */
    private Propiedades() {
        super();
        
        try {
            String rutaProp = ArchivoUtil.getPathDirectorioEjecucion()+File.separator+Constantes.DIR_PROJECT_PROPERTIES+File.separator+Constantes.PROJECT_PROPERTIES;
            propert = new Properties();
            propert.load(new FileInputStream(rutaProp));
        } catch (Exception e) {
            System.out.println(Constantes.MENSAJE_ERROR_PROPIEDADES + e);
        } finally {
//            if (initial != null) {
//                try {
//                    initial.close();
//                } catch (NamingException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    /**
     * Metodo que permite obtener un valor leido del objeto property, el cual se
     * cargo en memoria una primera vez del archivo de Propiedades
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        String valorPropiedad = null;

        valorPropiedad = getInstance().propert.getProperty(key);

        if (valorPropiedad != null) {
            valorPropiedad = valorPropiedad.trim();
        }

        return valorPropiedad;
    }
}
