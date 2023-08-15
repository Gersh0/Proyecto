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
        Botones.focus(inputBorrarCc, "Cédula");
        Botones.focus(inputCcBuscar, "Cédula");
        Botones.focus(inputCcNuevo, "Cédula");
        Botones.focus(inputTelNuevo, "Teléfono");
        Botones.focus(inputNombreNuevo, "Nombre");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interfaz();
                dispose();
            }
        });

        botonCrarComprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = inputNombreNuevo.getText();
                String tel = inputTelNuevo.getText();
                String cc = inputCcNuevo.getText();
                try {

                    if (nombre.equals("Nombre") ||
                            tel.equals("Teléfono") ||
                            cc.equals("Cédula")
                    ) {
                        JOptionPane.showMessageDialog(null, "Campos vacios",
                                "Añadir usuario", JOptionPane.ERROR_MESSAGE);
                    }
                    //Si ya existe devuelve la posición, si no existe devuelve -1 y lo crea
                    else {
                        /*Almacen.buscarCliente(cc);
                        JOptionPane.showMessageDialog(null, "Este cliente ya existe",
                                "Añadir usuario", JOptionPane.ERROR_MESSAGE);*/
                        Almacen.addCliente(nombre, tel, cc);
                        JOptionPane.showMessageDialog(null, "Se añadió el usuario",
                                "Añadir usuario", JOptionPane.INFORMATION_MESSAGE);
                    }


                } catch (Exception e3) {

                }


            }
        });

        botonBuscarComprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException {
                try {
                    Cliente cliente = Almacen.getClientes()[Almacen.buscarCliente(inputCcBuscar.getText())];
                    if (inputCcBuscar.equals("Cédula")
                    ) {
                        JOptionPane.showMessageDialog(null, "Campos vacios",
                                "Añadir usuario", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Nombre: " + cliente.getNombre() +
                                        "\nCédula: " + cliente.getCedula(),
                                "Cliente", JOptionPane.INFORMATION_MESSAGE);
                        inputCcBuscar.setText("Cédula");
                    }
                } catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println(a);
                    inputCcBuscar.setText("Cédula");
                    JOptionPane.showMessageDialog(null,
                            "La cédula ingresada no coincide con ningún empleado registrado.",
                            "Empleado(a)", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        botonBorrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cc = inputBorrarCc.getText();
                try {

                    if (cc.equals("Cédula")
                    ) {
                        JOptionPane.showMessageDialog(null, "Campos vacios",
                                "Editar usuario", JOptionPane.ERROR_MESSAGE);
                    }
                    //Si ya existe devuelve la posición, si no existe devuelve -1 y lo crea
                    else {
                        Cliente a = Almacen.getClientes()[Almacen.buscarCliente(cc)];
                        Almacen.delCliente(cc);
                        JOptionPane.showMessageDialog(null, "El cliente hasido borrado",
                                "Editar usuario", JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (ArrayIndexOutOfBoundsException e3) {
                    JOptionPane.showMessageDialog(null, "La cédula no está registrada",
                            "Editar usuario", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });
    }
}
