/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Richard Osmar Leon Ingaruca - RNASystems
 */
/**
 * RobotDemo.java
 *
 * Ejemplo básico del control del ratón y teclado a través de la clase java.awt.Robot .
 */

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

/**
 * Clase principal que extiende MouseAdapter e implementa ActionListener para poder
 * atender y manejar eventos sobre los componentes de la GUI.
 *
 * @author Dark[byte]
 */
class RobotDemo extends MouseAdapter implements ActionListener {

    private static JFrame frame;
    private static Robot robot;
    private JTextField coord_X;
    private JTextField coord_Y;
    private JButton mover;
    private JList lista;

    //array de teclas para la lista
    private static final Key keys[] = {
        new Key(KeyEvent.VK_F1, "F1"), new Key(KeyEvent.VK_F2, "F2"),
        new Key(KeyEvent.VK_F3, "F3"), new Key(KeyEvent.VK_F4, "F4"),
        new Key(KeyEvent.VK_F5, "F5"), new Key(KeyEvent.VK_F6, "F6"),
        new Key(KeyEvent.VK_F7, "F7"), new Key(KeyEvent.VK_F8, "F8"),
        new Key(KeyEvent.VK_F9, "F9"), new Key(KeyEvent.VK_F10, "F10"),
        new Key(KeyEvent.VK_F11, "F11"), new Key(KeyEvent.VK_F12, "F12"),
        new Key(KeyEvent.VK_NUMPAD0, "Num Pad 0"), new Key(KeyEvent.VK_NUMPAD1, "Num Pad 1"),
        new Key(KeyEvent.VK_NUMPAD2, "Num Pad 2"), new Key(KeyEvent.VK_NUMPAD3, "Num Pad 3"),
        new Key(KeyEvent.VK_NUMPAD4, "Num Pad 4"), new Key(KeyEvent.VK_NUMPAD5, "Num Pad 5"),
        new Key(KeyEvent.VK_NUMPAD6, "Num Pad 6"), new Key(KeyEvent.VK_NUMPAD7, "Num Pad 7"),
        new Key(KeyEvent.VK_NUMPAD8, "Num Pad 8"), new Key(KeyEvent.VK_NUMPAD9, "Num Pad 9"),
        new Key(KeyEvent.VK_A, "A"), new Key(KeyEvent.VK_B, "B"),
        new Key(KeyEvent.VK_C, "C"), new Key(KeyEvent.VK_D, "D"),
        new Key(KeyEvent.VK_E, "E"), new Key(KeyEvent.VK_F, "F"),
        new Key(KeyEvent.VK_G, "G"), new Key(KeyEvent.VK_H, "H"),
        new Key(KeyEvent.VK_I, "I"), new Key(KeyEvent.VK_J, "J"),
        new Key(KeyEvent.VK_K, "K"), new Key(KeyEvent.VK_L, "L"),
        new Key(KeyEvent.VK_M, "M"), new Key(KeyEvent.VK_N, "N"),
        new Key(KeyEvent.VK_O, "O"), new Key(KeyEvent.VK_P, "P"),
        new Key(KeyEvent.VK_Q, "Q"), new Key(KeyEvent.VK_R, "R"),
        new Key(KeyEvent.VK_S, "S"), new Key(KeyEvent.VK_T, "T"),
        new Key(KeyEvent.VK_U, "U"), new Key(KeyEvent.VK_V, "V"),
        new Key(KeyEvent.VK_W, "W"), new Key(KeyEvent.VK_X, "X"),
        new Key(KeyEvent.VK_Y, "Y"), new Key(KeyEvent.VK_Z, "Z"),
        new Key(KeyEvent.VK_ESCAPE, "Esc"), new Key(KeyEvent.VK_INSERT, "Insert"),
        new Key(KeyEvent.VK_SHIFT, "Shift"), new Key(KeyEvent.VK_PRINTSCREEN, "Print Screen"),
        new Key(KeyEvent.VK_END, "End"), new Key(KeyEvent.VK_SPACE, "Space"),
        new Key(KeyEvent.VK_NUM_LOCK, "Num Lock"), new Key(KeyEvent.VK_COPY, "Copy"),
        new Key(KeyEvent.VK_PASTE, "Paste"), new Key(KeyEvent.VK_PAGE_DOWN, "Page Down"),
        new Key(KeyEvent.VK_PAGE_UP, "Page Up"), new Key(KeyEvent.VK_ALT, "Alt"),
        new Key(KeyEvent.VK_KP_DOWN, "Down"), new Key(KeyEvent.VK_KP_UP, "Arriba"),
        new Key(KeyEvent.VK_KP_LEFT, "Left"), new Key(KeyEvent.VK_KP_RIGHT, "Right"),
        new Key(KeyEvent.VK_WINDOWS, "Windows"), new Key(KeyEvent.VK_SLASH, "Slash")
    };

    /**
     * Armamos el panel de contenido principal de la GUI agregando componentes.
     *
     * @param contenedor el panel de contenido principal.
     */
    public void addComponentToPane(Container contenedor) {
        JTabbedPane tabsPane = new JTabbedPane();

        //creamos el panel de control para el mouse
        JPanel tab1 = new JPanel();
        tab1.setLayout(new BorderLayout(5, 5));

        JPanel items = new JPanel();
        items.setLayout(new GridLayout(2, 2, 5, 5));
        items.setBorder(new EmptyBorder(35, 35, 35, 35));

        coord_X = new JTextField();
        coord_X.setHorizontalAlignment(JTextField.CENTER);

        coord_Y = new JTextField();
        coord_Y.setHorizontalAlignment(JTextField.CENTER);

        mover = new JButton("Mover!");
        mover.setActionCommand("mover");
        mover.addActionListener(this);

        items.add(new JLabel("Coordenada X:", JLabel.CENTER));
        items.add(coord_X);
        items.add(new JLabel("Coordenada Y:", JLabel.CENTER));
        items.add(coord_Y);

        tab1.add(items, BorderLayout.CENTER);
        tab1.add(mover, BorderLayout.SOUTH);

        //creamos el panel de control para el teclado
        JPanel tab2 = new JPanel();
        tab2.setLayout(new BorderLayout(5, 5));

        lista = new JList(keys);
        lista.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(lista);
        tab2.add(scrollPane, BorderLayout.CENTER);
        tab2.add(new JLabel("Doble-Click en alguna tecla!", JLabel.CENTER), BorderLayout.SOUTH);

        //introducimos en el panel de control sus sub-paneles
        tabsPane.addTab("Mouse", tab1);
        tabsPane.addTab("Teclado", tab2);

        //introducimos el panel de control en el contenedor principal
        contenedor.add(tabsPane, BorderLayout.CENTER);
    }

    /**
     * Construimos la GUI de nuestro programa, la configuramos, la centramos
     * en pantalla y la hacemos visible.
     */
    private static void createAndShowGUI() {
        frame = new JFrame("Ventana de control");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RobotDemo rd = new RobotDemo();
        rd.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Punto de entrada del programa.
     *
     * Ordenamos la construcción de la GUI en el EDT (Event Dispatch Thread).
     *
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) throws AWTException {
        //instanciamos la clase Robot
        robot = new Robot();

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                createAndShowGUI();
            }
        });
    }

    /**
     * Atendemos y manejamos los eventos sobre los componentes.
     *
     * @param ae evento disparado.
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("mover") == true) {
            try {
                int x = Integer.parseInt(coord_X.getText());
                int y = Integer.parseInt(coord_Y.getText());

                //Movemos el mouse a las coordenadas especificadas por el usuario
                robot.mouseMove(x, y);
            } catch (NumberFormatException ex) {
                System.out.println("ERROR - Introducir las coordenadas X : Y !");
            }
        }
    }

    /**
     * Atendemos y manejamos los eventos de doble-click sobre la lista de teclas.
     *
     * @param me evento del ratón disparado.
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2) {
            int index = lista.locationToIndex(me.getPoint());
            ListModel dlm = lista.getModel();
            Key item = (Key) dlm.getElementAt(index);

            //minimizamos el JFrame para que las teclas generen sus eventos en las ventanas que esten por debajo
            frame.setState(Frame.ICONIFIED);

            //presionamos y soltamos la tecla
            robot.keyPress(item.getKey());
            robot.keyRelease(item.getKey());
        }
    }
}

/**
 * Esta clase adicional representa una tecla en la lista.
 */
class Key {

    private final int key;
    private final String name;

    /**
     * Constructor de la clase.
     *
     * @param key el número entero de esta tecla.
     * @param name el nombre de esta tecla.
     */
    public Key(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Devuelve el número entero correspondiente a esta tecla.
     *
     * @return el número entero de esta tecla.
     */
    public int getKey() {
        return key;
    }

    /**
     * Devuelve el nombre de esta tecla.
     *
     * @return el nombre de esta tecla.
     */
    @Override
    public String toString() {
        return name;
    }
}

