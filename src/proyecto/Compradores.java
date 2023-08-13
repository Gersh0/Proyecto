package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Compradores extends JFrame {
    private JLabel tituloDatosCompradores;
    private JTextField inputCcBuscar;
    private JLabel tituloAddUsuario;
    private JTextField inputNombreNuevo;
    private JTextField inputCcNuevo;
    private JTextField inputTelNuevo;
    private JPanel compradores;
    private JButton botonBuscarComprador;
    private JButton botonCrarComprador;
    private JLabel tituloBorrarUsuario;
    private JTextField inputBorrarCc;
    private JButton botonBorrarUsuario;
    private JButton atrasButton;

    public Compradores() {
        setContentPane(compradores);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Almacen.focus(inputBorrarCc, "Cédula");
        Almacen.focus(inputCcBuscar, "Cédula");
        Almacen.focus(inputCcNuevo, "Cédula");
        Almacen.focus(inputTelNuevo, "Teléfono");
        Almacen.focus(inputNombreNuevo, "Nombre");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interfaz();
                dispose();
            }
        });
    }
}
