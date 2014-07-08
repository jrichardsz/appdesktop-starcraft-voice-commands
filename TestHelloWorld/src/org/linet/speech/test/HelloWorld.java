/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.linet.speech.test;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.*;

import javax.speech.recognition.*;

import java.io.FileReader;

import java.util.Locale;

public class HelloWorld extends ResultAdapter {

    static Recognizer rec;

    // Receives RESULT_ACCEPTED event: print it, clean up, exit
    public void resultAccepted(ResultEvent e) {

        Result r = (Result) (e.getSource());

        ResultToken tokens[] = r.getBestTokens();



        for (int i = 0; i < tokens.length; i++) {
            System.out.print(tokens[i].getSpokenText() + " ");
        }

        System.out.println();
        try {
            // Deallocate the recognizer and exit

            rec.deallocate();
        } catch (EngineException ex) {
            ex.printStackTrace();
        } catch (EngineStateError ex) {
            ex.printStackTrace();
        }

        System.exit(0);

    }

    public static void main(String args[]) {

        try {

            // Create a recognizer that supports English.

            rec = Central.createRecognizer(new EngineModeDesc(Locale.ENGLISH));



            // Start up the recognizer

            rec.allocate();



            // Load the grammar from a file, and enable it

            FileReader reader = new FileReader("E:\\RICHARD\\PROYECTOS\\2012\\VozControlGames\\SimpleGrammarES2.txt");

            RuleGrammar gram = rec.loadJSGF(reader);

            gram.setEnabled(true);



            // Add the listener to get results

            rec.addResultListener(new HelloWorld());



            // Commit the grammar

            rec.commitChanges();



            // Request focus and start listening

            rec.requestFocus();

            rec.resume();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
