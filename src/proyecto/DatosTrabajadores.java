package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatosTrabajadores extends JFrame {
    private JLabel tituloDatosTrabajadores;
    private JLabel tituloBuscarEmpleado;
    private JLabel tituloBuscarProveedor;
    private JTextField inputCcEmpleado;
    private JTextField inputCcProveedor;
    private JButton botonEditarTrabajador;
    private JPanel datosTrabajadores;
    private JButton buscarEmpleado;
    private JButton buscarProveedor;
    private JButton atrasButton;

    public DatosTrabajadores() {
        setContentPane(datosTrabajadores);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Almacen.focus(inputCcEmpleado,"Cédula");
        Almacen.focus(inputCcProveedor,"NIT");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Interfaz();
                dispose();
            }
        });
        botonEditarTrabajador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdicionarTrabajadores();
                dispose();
            }
        });
        buscarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Nombre: "+ Almacen.getEmpleados()[Almacen.buscarEmpleado(inputCcEmpleado.getText())].getNombre()+
                                "\nCargo: ¿Lo ponemos?",
                        "Empleado(a)", JOptionPane.INFORMATION_MESSAGE);
                inputCcEmpleado.setText("");
            }
        });
        buscarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Método aún no implemnentado.",
                        "Proveedor", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
