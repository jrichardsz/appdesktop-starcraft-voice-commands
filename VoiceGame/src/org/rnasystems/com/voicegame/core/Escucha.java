package org.rnasystems.com.voicegame.core;


/**
 *
 * @author Cmop
 */
import java.io.File;
import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;
import org.linet.com.util.archivos.ArchivoUtil;

public class Escucha extends ResultAdapter {

    static Recognizer recognizer;
    String gst;

    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result) (re.getSource());
            ResultToken tokens[] = res.getBestTokens();

            String args[] = new String[1];
            args[0] = "";
            for (int i = 0; i < tokens.length; i++) {
                gst = tokens[i].getSpokenText();
                args[0] += gst + " ";
                System.out.print(gst + " ");
            }
            System.out.println();
            if (gst.equals("cmop")) {
                recognizer.deallocate();
                args[0] = "Hasta la proxima Cmop!";
                System.out.println(args[0]);
                Lee.main(args);
                System.exit(0);
            } else {
                recognizer.suspend();
                Lee.main(args);
                recognizer.resume();
            }
        } catch (Exception ex) {
            System.out.println("Ha ocurrido algo inesperado " + ex);
        }
    }

    public static void main(String args[]) {
        try {
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();
            String urlApp = ArchivoUtil.getPathDirectorioEjecucion();
            String urlGrammar = urlApp + File.separator+"config"+File.separator+"SimpleGrammarES2.txt";   
            System.out.println(""+urlGrammar);
            FileReader grammar1 = new FileReader(urlGrammar);

            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);

            recognizer.addResultListener(new Escucha());

            System.out.println("Empieze Dictado");
            recognizer.commitChanges();

            recognizer.requestFocus();
            recognizer.resume();
        } catch (Exception e) {
            System.out.println("Exception en " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
}