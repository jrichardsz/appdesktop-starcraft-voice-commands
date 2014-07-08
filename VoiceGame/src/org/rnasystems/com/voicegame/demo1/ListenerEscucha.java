/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rnasystems.com.voicegame.demo1;

import javax.speech.recognition.Result;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;
import javax.swing.JTextArea;

/**
 *
 * @author RM-RCM
 */
public class ListenerEscucha extends ResultAdapter {

    public ListenerEscucha(JTextArea jTextAreaLog) {
        this.jTextAreaLog = jTextAreaLog;
    }
    
    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            String gst = "";
            String cadRecognition = "";

            for (int i = 0; i < tokens.length; i++) {
                gst = tokens[i].getSpokenText();

                if (i == tokens.length - 1) {
                    cadRecognition += gst;
                } else {
                    cadRecognition += gst + " ";
                }
            }
            
            //System.out.print("|"+cadRecognition+"|");            
            
            EjecutaAccionStarCraft.reconoceAccion(cadRecognition,jTextAreaLog);

        } catch (Exception ex) {
            System.out.println("Ha ocurrido algo inesperado " + ex);
        }
    }
    
    private javax.swing.JTextArea jTextAreaLog;    
    
}
