package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public abstract class Botones {

    public static void enviarBuscar(JButton b, JTextField inputBuscarMarca, JTextField inputBuscarSerial, String tipoCarro) {

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = Almacen.buscarCarro(inputBuscarMarca.getText(), inputBuscarSerial.getText());
                try {
                    JOptionPane.showMessageDialog(null,
                            "Marca: " + Almacen.getCarros()[index].getMarca() +
                                    "\nModelo: " + Almacen.getCarros()[index].getModelo() +
                                    "\nPrecio: $" + Almacen.getCarros()[index].getPrecio(),
                            tipoCarro, JOptionPane.INFORMATION_MESSAGE);
                    inputBuscarMarca.setText("Marca");
                    inputBuscarSerial.setText("Serial");
                } catch (ArrayIndexOutOfBoundsException a) {
                    inputBuscarSerial.setText("Marca");
                    inputBuscarSerial.setText("Serial");
                    System.out.println(a);
                    JOptionPane.showMessageDialog(null,
                            "Los datos ingresados no coinciden con ningún " + tipoCarro.toLowerCase() + " registrado.",
                            tipoCarro, JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }

    public static void enviarCrear(JButton b, JComboBox inputAddCilindraje, JTextField inputAddMarca, JTextField inputAddSerial, JTextField inputAddModelo, String tipoCarro) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textoCilindraje = inputAddCilindraje.getSelectedItem().toString();
                Cilindraje cilindraje = textoCilindraje.equalsIgnoreCase("alto") ? Cilindraje.ALTO :
                        (textoCilindraje.equalsIgnoreCase("medio")) ? Cilindraje.MEDIO : Cilindraje.BAJO;
                String marca = inputAddMarca.getText();
                String modelo = inputAddSerial.getText();
                String serial = inputAddModelo.getText();
                if (Almacen.buscarCarro(marca, serial) != -1) { //Si al buscar no obtiene -1 significa que existe y no agrega nada.
                    JOptionPane.showMessageDialog(null, "Ya existe un " + tipoCarro.toLowerCase() + " de la marca " + marca + " ingresado con el serial indicado.", "Añadir Vehículo", JOptionPane.ERROR_MESSAGE);
                    inputAddMarca.setText("Marca");
                    inputAddSerial.setText("Serial");
                    inputAddModelo.setText("Modelo");
                    inputAddCilindraje.setSelectedItem("Cilindraje");
                    //Sino entonces verifica que los campos estén llenos para crear un empleado (Los campos no pueden ser los que están por defecto).
                } else if ((Almacen.soloLetras(marca) && !marca.equalsIgnoreCase("Marca")) &&
                        (!Almacen.soloLetras(serial) && !serial.equalsIgnoreCase("Serial"))
                        && (!Almacen.soloLetras(modelo) && !modelo.equalsIgnoreCase("Modelo"))
                        && !cilindraje.toString().equalsIgnoreCase("Cilindraje")) {
                    Almacen.addCarro(inputAddMarca.getText(), inputAddModelo.getText(), inputAddSerial.getText(), cilindraje, true, true, tipoCarro);
                    JOptionPane.showMessageDialog(null, tipoCarro + " creado correctamente.",
                            tipoCarro, JOptionPane.INFORMATION_MESSAGE);
                    inputAddMarca.setText("Marca");
                    inputAddSerial.setText("Serial");
                    inputAddModelo.setText("Modelo");
                    inputAddCilindraje.setSelectedItem("Cilindraje");

                } else {
                    JOptionPane.showMessageDialog(null, "No se ingresaron todos los datos solicitados.",
                            "Añadir Vehículo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void enviarBorrar(JButton b, JTextField inputBorrarMarca, JTextField inputBorrarSerial, String tipoCarro) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscarMarca = inputBorrarMarca.getText();
                String buscarSerial = inputBorrarSerial.getText();
                if (Almacen.buscarCarro(buscarMarca, buscarSerial) == -1) {
                    JOptionPane.showMessageDialog(null, "No existe un " + tipoCarro + " de la marca " + buscarMarca + " con el serial ingresado.",
                            tipoCarro, JOptionPane.ERROR_MESSAGE);
                    inputBorrarMarca.setText("Marca");
                    inputBorrarSerial.setText("Serial");
                } else {
                    Almacen.delCarro(buscarMarca, buscarSerial);
                    inputBorrarMarca.setText("Marca");
                    inputBorrarSerial.setText("Serial");
                    JOptionPane.showMessageDialog(null, "Automóvil borrado correctamente.",
                            tipoCarro, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void enviarEditar(JButton b, JTextField inputEditarMarca, JTextField inputEditarSerial, JTextField inputEditarModelo, JTextField inputEditarPrecio, String tipoCarro) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String editarMarca = inputEditarMarca.getText();
                String editarSerial = inputEditarSerial.getText();
                int indexEditar = Almacen.buscarCarro(editarMarca, editarSerial);
                try {
                    switch (tipoCarro) {
                        case "Automovil":
                            Automovil a = (Automovil) Almacen.getCarros()[indexEditar];
                            a.setModelo(inputEditarModelo.getText());
                            a.setPrecio(inputEditarPrecio.getText());
                            JOptionPane.showMessageDialog(null, tipoCarro + " editado correctamente.",
                                    tipoCarro, JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Campero":
                            Campero c = (Campero) Almacen.getCarros()[indexEditar];
                            c.setModelo(inputEditarModelo.getText());
                            c.setPrecio(inputEditarPrecio.getText());
                            JOptionPane.showMessageDialog(null, tipoCarro + " editado correctamente.",
                                    tipoCarro, JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case "Deportivo":
                            Deportivo d = (Deportivo) Almacen.getCarros()[indexEditar];
                            d.setModelo(inputEditarModelo.getText());
                            d.setPrecio(inputEditarPrecio.getText());
                            JOptionPane.showMessageDialog(null, tipoCarro + " editado correctamente.",
                                    tipoCarro, JOptionPane.INFORMATION_MESSAGE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "No existe un " + tipoCarro + " de la marca " + editarMarca + " con el serial ingresado.",
                                    tipoCarro, JOptionPane.ERROR_MESSAGE);
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "No existe un " + tipoCarro + " de la marca " + editarMarca + " con el serial ingresado.",
                            tipoCarro, JOptionPane.ERROR_MESSAGE);
                }
                inputEditarMarca.setText("Marca");
                inputEditarPrecio.setText("Precio");
                inputEditarModelo.setText("Modelo");
                inputEditarSerial.setText("Serial");
            }
        });
    }

    public static void botonEstado(JButton b, JFrame f) {
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditarDisponibilidad();
                f.dispose();
            }
        });
    }


    public static void focus(JTextField c, String texto) {
        c.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (c.getText().contains(texto)) {
                    c.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!c.getText().equals("")) {

                } else {
                    c.setText(texto);
                }
            }
        });
    }
}

