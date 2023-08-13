package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioAutomovil extends JFrame {
    private JPanel inventarioAutomovil;
    private JLabel tituloInventarioAutomoviles;
    private JTextField inputBuscarMarca;
    private JTextField inputBuscarModelo;
    private JTextField inputAddModelo;
    private JTextField inputAddCc;
    private JTextField inputAddCantidad;
    private JLabel tituloBuscarAutomovil;
    private JLabel tituloMarca;
    private JLabel tituloModelo;
    private JLabel tituloNuevoAutomovil;
    private JButton botonEditarEstado;
    private JTextField inputAddMarca;
    private JLabel tituloBorrarAutomovil;
    private JTextField inputBorrarMarca;
    private JTextField inputBorrarModelo;
    private JLabel tituloEditarAutomovil;
    private JTextField inputEditarMarca;
    private JTextField inputEditarModelo;
    private JTextField inputEditarCantidad;
    private JTextField inputEditarPrecio;
    private JButton botonBuscar;
    private JButton botonCrear;
    private JButton botonBorrar;
    private JButton botonEditar;
    private JButton atrasButton;

    public InventarioAutomovil() {
        setContentPane(inventarioAutomovil);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InventarioGeneral();
                dispose();
            }
        });
    }
}
