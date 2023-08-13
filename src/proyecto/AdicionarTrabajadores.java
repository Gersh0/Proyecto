package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarTrabajadores extends JFrame {
    private JLabel tituloAddEmpleado;
    private JTextField inputNombreEmpleado;
    private JTextField inputCcEmpleado;
    private JTextField inputTelefonoEmpleado;
    private JCheckBox isVendedor;
    private JLabel titulAddProveedor;
    private JTextField inputNombreProveedor;
    private JTextField inputCcProveedor;
    private JTextField inputTelProveedor;
    private JPanel adicionarTrabajadores;
    private JButton botonCrearEmpleado;
    private JButton botonCrearProveedor;
    private JLabel tituloBorrarEmpleado;
    private JTextField inputBorrarEmpleado;
    private JButton botonBorrarEmpleado;
    private JLabel tituloBorrarProveedor;
    private JTextField inputBorrarProveedor;
    private JButton botonBorrarProveedor;
    private JButton atrasButton;

    public AdicionarTrabajadores() {
        setContentPane(adicionarTrabajadores);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Almacen.focus(inputNombreProveedor, "Nombre");
        Almacen.focus(inputNombreEmpleado, "Nombre");
        Almacen.focus(inputCcProveedor, "NIT");
        Almacen.focus(inputCcEmpleado, "Cédula");
        Almacen.focus(inputTelProveedor, "Teléfono");
        Almacen.focus(inputTelefonoEmpleado, "Teléfono");
        Almacen.focus(inputBorrarProveedor, "NIT");
        Almacen.focus(inputBorrarEmpleado, "Cédula");

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Almacen.getEmpleados()==null){
                    new Interfaz();
                    dispose();
                }else{
                    new DatosTrabajadores();
                    dispose();
                }
            }
        });

        botonCrearEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Almacen.addEmpleado(inputNombreEmpleado.getText(), inputCcEmpleado.getText(), inputTelefonoEmpleado.getText(), 0);
                JOptionPane.showMessageDialog(null, "Empleado añadido",
                        "Añadir empleado", JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null, Almacen.getCarros().length);
            }
        });

    }
}
