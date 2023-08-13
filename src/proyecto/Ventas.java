package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Ventas extends JFrame {
    private JPanel Ventas;
    private JLabel tituloNuevaVenta;
    private JTextField inputAddCliente;
    ;
    private JTextField inputAddVendedor;
    private JTextField inputAddCarroMarca;
    private JComboBox inputAddFormaDePAgo;
    private JLabel tituloVentas;
    private JLabel tituloCarro;
    private JLabel tituloFormaDePago;
    private JLabel tituloBuscarVenta;
    private JTextField inputBuscarCodigoVenta;
    private JTextField inputAddCarroModelo;
    private JButton botonCrearVenta;
    private JButton botonBuscarVenta;
    private JButton atrasButton;

    public Ventas() {
        setContentPane(Ventas);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Almacen.focus(inputAddCliente, "Cedula Cliente");
        Almacen.focus(inputAddVendedor, "Cedula Vendedor");
        Almacen.focus(inputBuscarCodigoVenta, "Codigo");
        Almacen.focus(inputAddCarroModelo, "Modelo");
        Almacen.focus(inputAddCarroMarca, "Marca");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interfaz();
                dispose();
            }
        });
    }

}
