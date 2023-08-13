package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioDeportivos extends JFrame{
    private JLabel tituloInventarioDeportivos;
    private JLabel tituloBuscarDeportivo;
    private JTextField inputBuscarMarca;
    private JTextField inputBuscarModelo;
    private JLabel tituloBuscarMarca;
    private JLabel tituloBuscarModelo;
    private JLabel tituloNuevoDeportivo;
    private JTextField inputNuevaMarca;
    private JTextField inputNuevoModelo;
    private JTextField inputNuevoCC;
    private JTextField inputNuevaCantidad;
    private JLabel tituloBorrarDeportivo;
    private JTextField inputBorrarMarca;
    private JTextField inputBorrarModelo;
    private JPanel inventarioDeportivos;
    private JLabel tituloeditarDeportivo;
    private JTextField inputEditarMarca;
    private JTextField inputEditarModelo;
    private JTextField inputEditarCantidad;
    private JButton botonEstado;
    private JButton botonBuscar;
    private JButton botonCrear;
    private JButton botonBorrar;
    private JButton botonEditar;
    private JTextField inputEditarPrecio;
    private JButton atrasButton;

    public InventarioDeportivos(){
        setContentPane(inventarioDeportivos);
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
