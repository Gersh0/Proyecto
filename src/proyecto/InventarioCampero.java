package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioCampero extends JFrame {


    private JLabel tituloInventarioCamperos;
    private JLabel tituloBuscarCampero;
    private JTextField inputBuscarMarca;
    private JTextField inputBuscarSerial;
    private JLabel tituloNuevoCampero;
    private JLabel tituloBorrarCampero;
    private JTextField inputBorrarMarca;
    private JLabel tituloEditarCampero;
    private JTextField inputEditarModelo;
    private JButton botonBuscar;
    private JButton botonCrear;
    private JButton botonBorrar;
    private JButton botonEditar;
    private JTextField inputEditarPrecio;
    private JButton atrasButton;
    private JTextField inputBorrarSerial;
    private JTextField inputEditarMarca;
    private JTextField inputEditarSerial;
    private JTextField inputAddSerial;
    private JComboBox inputAddCilindraje;
    private JTextField inputAddModelo;
    private JTextField inputAddMarca;
    private JPanel inventarioCampero;
    private JButton botonEstado;

    public InventarioCampero() {
        setContentPane(inventarioCampero);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Botones.focus(inputAddMarca, "Marca");
        Botones.focus(inputAddModelo, "Modelo");
        Botones.focus(inputAddSerial, "Serial");
        Botones.focus(inputBorrarMarca, "Marca");
        Botones.focus(inputBorrarSerial, "Serial");
        Botones.focus(inputBuscarMarca, "Marca");
        Botones.focus(inputBuscarSerial, "Serial");
        Botones.focus(inputEditarMarca, "Marca");
        Botones.focus(inputEditarModelo, "Modelo");
        Botones.focus(inputEditarPrecio, "Precio");
        Botones.focus(inputEditarSerial, "Serial");
        String tipoCarro = "Campero";
        Botones.enviarBuscar(botonBuscar, inputBuscarMarca, inputBuscarSerial, tipoCarro);
        Botones.enviarCrear(botonCrear, inputAddCilindraje, inputAddMarca, inputAddSerial, inputAddModelo, tipoCarro);
        Botones.enviarBorrar(botonBorrar, inputBorrarMarca, inputBorrarSerial, tipoCarro);
        Botones.enviarEditar(botonEditar, inputEditarMarca, inputEditarSerial, inputEditarModelo, inputEditarPrecio, tipoCarro);
        Botones.botonEstado(botonEstado,this);
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InventarioGeneral();
                dispose();
            }
        });
    }


}

