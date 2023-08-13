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
    private JTextField inputAddCilindraje;
    private JLabel tituloBuscarAutomovil;
    private JLabel tituloNuevoAutomovil;
    private JButton botonEditarEstado;
    private JTextField inputAddMarca;
    private JLabel tituloBorrarAutomovil;
    private JTextField inputBorrarMarca;
    private JTextField inputBorrarSerial;
    private JLabel tituloEditarAutomovil;
    private JTextField inputEditarMarca;
    private JTextField inputEditarSerial;
    private JTextField inputEditarPrecio;
    private JTextField inputEditarModelo;
    private JButton botonBuscar;
    private JButton botonCrear;
    private JButton botonBorrar;
    private JButton botonEditar;
    private JButton atrasButton;
    private JTextField inputAddSerial;

    public InventarioAutomovil() {
        setContentPane(inventarioAutomovil);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Almacen.focus(inputAddCilindraje,"Cilindraje");
        Almacen.focus(inputAddMarca,"Marca");
        Almacen.focus(inputAddModelo,"Modelo");
        Almacen.focus(inputAddSerial,"Serial");
        Almacen.focus(inputBorrarMarca,"Marca");
        Almacen.focus(inputBorrarSerial,"Serial");
        Almacen.focus(inputBuscarMarca,"Marca");
        Almacen.focus(inputBuscarModelo,"Modelo");
        Almacen.focus(inputEditarMarca,"Marca");
        Almacen.focus(inputEditarModelo,"Modelo");
        Almacen.focus(inputEditarPrecio,"Precio");
        Almacen.focus(inputEditarSerial,"Serial");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InventarioGeneral();
                dispose();
            }
        });
    }
}
