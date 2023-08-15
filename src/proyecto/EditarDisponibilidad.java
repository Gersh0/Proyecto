package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarDisponibilidad extends JFrame{
    private JLabel tituloEstado;
    private JLabel tituloDisponibilidad;
    private JTextField inputEstadoMarca;
    private JTextField inputDisponibilidadMarca;
    private JTextField inputEstadoModelo;
    private JTextField inputDisponibilidadModelo;
    private JCheckBox isEstado;
    private JCheckBox isDisponible;
    private JPanel editarDisponibilidad;
    private JButton botoneditarEstado;
    private JButton botonEditarDisponibilidad;
    private JButton atrasButton;

    public EditarDisponibilidad(){
        setContentPane(editarDisponibilidad);
        setTitle("Hola");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Botones.focus(inputEstadoMarca,"Marca");
        Botones.focus(inputDisponibilidadModelo,"Modelo");
        Botones.focus(inputEstadoModelo,"Modelo");
        Botones.focus(inputDisponibilidadMarca,"Marca");
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InventarioGeneral();
                dispose();
            }
        });
    }
}
