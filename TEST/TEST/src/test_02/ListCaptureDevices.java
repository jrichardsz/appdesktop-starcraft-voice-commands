/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_02;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */

/*

Java Media APIs: Cross-Platform Imaging, Media and Visualization
Alejandro Terrazas
Sams, Published November 2002, 
ISBN 0672320940
*/

import javax.media.*;
import java.util.*;

/*******************************************************************************
 * Simple application to list all capture devices currently known to the JMF.
 * The CaptureDeviceManager is queried as to known devices and its output
 * printed to the screen.
 * 
 * @author Michael (Spike) Barlow
 ******************************************************************************/
public class ListCaptureDevices {

  public static void main(String[] args) {

    /////////////////////////////////////////////////////////////
    // Query CaptureDeviceManager about ANY capture devices (null
    // format)
    Vector info = CaptureDeviceManager.getDeviceList(null);
    if (info == null)
      System.out.println("No Capture devices known to JMF");
    else {
      System.out.println("The following " + info.size()
          + " capture devices are known to the JMF");
      for (int i = 0; i < info.size(); i++)
        System.out
            .println("\t" + (CaptureDeviceInfo) info.elementAt(i));
    }
  }
}
