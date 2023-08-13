package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioCampero extends JFrame{


    private JPanel invCamperos;
    private JLabel tituloInventarioCamperos;
    private JLabel tituloBuscarCampero;
    private JTextField inputBuscarMarca;
    private JTextField inputBuscarModelo;
    private JLabel tituloMarca;
    private JLabel tituloModelo;
    private JLabel tituloNuevoCampero;
    private JTextField inputNuevaMarca;
    private JTextField inputNuevoModelo;
    private JTextField inputNuevoCC;
    private JTextField inputNuevaCantidad;
    private JLabel tituloBorrarCampero;
    private JTextField inputBorrarMarca;
    private JTextField inputBorrarModelo;
    private JLabel tituloEditarCampero;
    private JTextField inputEditarCampero;
    private JTextField inputEditarCantidad;
    private JTextField inputEditarModelo;
    private JButton botonEstado;
    private JButton botonBuscar;
    private JButton botonCrear;
    private JButton botonBorrar;
    private JButton botonEditar;
    private JTextField inputEditarPrecio;
    private JButton atrasButton;

    public InventarioCampero(){
        setContentPane(invCamperos);
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

