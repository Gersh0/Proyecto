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
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interfaz();
                dispose();
            }
        });
        inputAddCliente.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(inputAddCliente.getText().contains("Cedula Cliente")){
                    inputAddCliente.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!inputAddCliente.getText().equals("")){

                }else{
                    inputAddCliente.setText("Cedula Cliente");
                }
            }
        });

        inputAddVendedor.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(inputAddVendedor.getText().contains("Cedula Vendedor")){
                    inputAddVendedor.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!inputAddVendedor.getText().equals("")){

                }else{
                    inputAddVendedor.setText("Cedula Vendedor");
                }
            }
        });

        inputBuscarCodigoVenta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(inputBuscarCodigoVenta.getText().contains("Codigo")){
                    inputBuscarCodigoVenta.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!inputBuscarCodigoVenta.getText().equals("")){

                }else{
                    inputBuscarCodigoVenta.setText("Codigo");
                }
            }
        });
        inputAddCarroMarca.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(inputAddCarroMarca.getText().contains("Marca")){
                    inputAddCarroMarca.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!inputAddCarroMarca.getText().equals("")){

                }else{
                    inputAddCarroMarca.setText("Marca");
                }
            }
        });
        inputAddCarroModelo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(inputAddCarroModelo.getText().contains("Modelo")){
                    inputAddCarroModelo.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(!inputAddCarroModelo.getText().equals("")){

                }else{
                    inputAddCarroModelo.setText("Modelo");
                }
            }
        });
    }
}
