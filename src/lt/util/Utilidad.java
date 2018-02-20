/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author brother
 */
public class Utilidad extends PlainDocument {

    public void insertString(int offset, String str, AttributeSet atrr) throws BadLocationException {
        super.insertString(offset, str.toUpperCase(), atrr);
    }
    private static MaskFormatter mascara;
    //Establece el formato de fecha a ser mostrado en el FormatedTexField
    final private static SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    //Metodo que establece el formato de mascara del FormatedTextField
    public static MaskFormatter getMascara() {
        try {
            mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('*');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mascara;
    }

    //Metodo que obtiene el valor String del FormatedTextField y lo convierte a 
    //date para ser guardado en la base de datos
    public static LocalDate formatoFechaStringALocalDate(LocalDate s) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd LLL yyyy");
      String date = s.format(formato);
            //return FORMAT.parse(s);
            LocalDate parse = LocalDate.parse(date, formato);
            return parse;
       
    }

    //Metodo que obtiene una fecha guardada en la Base de Datos y lo convierte
    //en string para mostrarlo en el FormatedTextField
    public static String formatoFechaDateAString(Date d) {
        return FORMAT.format(d);
    }

    //Metodo que obtiene el valor String de un TextFiel y lo convierte a double
    //para ser guardado en la base de datos
    public static Double formatoValorNumeroStringADouble(String valor) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.###", simbolo);
        Number numero = 0;

        try {
            numero = formato.parse(valor);
        } catch (ParseException ex) {
            Logger.getLogger(Utilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numero.doubleValue();
    }

    //Metodo que obtiene el valor String de un TextFiel y lo convierte a integer
    //para ser guardado en la base de datos
    public static Integer formatoValorNumeroStringAInteger(String valor) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.###", simbolo);
        Number numero = 0;

        try {
            numero = formato.parse(valor);
        } catch (ParseException ex) {
            Logger.getLogger(Utilidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numero.intValue();
    }

    //Metodo que obtiene el valor double de una Base de datos y lo convierte a 
    // Sting para ser seteado en un TextField
    public static String formatoValorNumeroDoubleAString(Double valor) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.###", simbolo);

        return formato.format(valor);
    }
    public static String formatoValorNumeroDoubleSinComa(Double valor) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###", simbolo);

        return formato.format(valor);
    }

    //Metodo que obtiene el valor integer de una Base de datos y lo convierte a 
    // Sting para ser seteado en un TextField
    public static String formatoValorNumeroIntegerAString(Integer valor) {
        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator(',');
        simbolo.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("###,###.###", simbolo);

        return formato.format(valor);
    }

    //Metodo que valida el ingreso de datos en un TextFiel para que solo se 
    //pueda ingresar letras
    public static final void soloLetras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
//                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    //Metodo que valida el ingreso de datos en un TextFiel para que solo se 
    //pueda ingresar numeros
    public static final void soloNumeros(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    e.consume();
                }
            }
        });
    }

    //Metodo que permite pasar de un TextField a otro presionando enter
    public static void moverConEnter(java.awt.event.KeyEvent evt, JComponent source) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            source.requestFocus();
        }
    }

    //Metodo que acciona un boto al presionar enter
    public static void hacerClicConEnter(java.awt.event.KeyEvent evt, JButton buttom) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttom.doClick();
        }
    }
    
    //Metodo que limita la cantidad de caraceteres que se puede ingresar
    public static void limitarCaracteresTextField(java.awt.event.KeyEvent evt, JTextField text, int limite) {
        if (text.getText().length()== limite){
            evt.consume();
        }
    }

    //Metodo que limita la cantidad de caraceteres que se puede ingresar
    public static void limitarCaracteresTextArea(java.awt.event.KeyEvent evt, JTextArea text, int limite) {
        if (text.getText().length()== limite){
            evt.consume();
        }
    }

    //Metodo que sirve para seleccionar todo el contenido de un texfield cuando gana el foco
    public static void seleccionarContenido(java.awt.event.FocusEvent evt, JTextField textField) {
        textField.selectAll();
    }

    //Metodo para cerrar la ventana principal
    public static void salirConEscapeJFrame(final JFrame frame) {
        ActionListener escListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        null, "Desea salir de " + frame.getTitle() + "?",
                        "Atencion", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        };
        frame.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    //Metodo para cerrar las ventanas internas
    public static void salirConEscapeJDialog(final JDialog dialog) {
        ActionListener escListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        null, "Desea salir de " + dialog.getTitle() + "?",
                        "Atencion", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    dialog.dispose();
                }
            }
        };
        dialog.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    //Metodo para cerrar los buscadores
    public static void salirConEscapeBuscador(final JDialog dialog) {
        ActionListener escListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        };
        dialog.getRootPane().registerKeyboardAction(escListener, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
}
