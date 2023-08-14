package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class Interfaz extends JFrame {
    private JPanel Principal;
    private JLabel Titulo;
    private JButton botonInventario;
    private JButton botonPersonal;
    private JButton botonVentas;
    private JButton botonUsuarios;

    public Interfaz() {
        setContentPane(Principal);
        setTitle(Titulo.getText());
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        botonInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InventarioGeneral();
                dispose();
            }
        });
        botonPersonal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Almacen.getEmpleados() == null) {
                    JOptionPane.showMessageDialog(null,"Aún no existen empleados registrados. Redirigiendo al formulario de ingreso de personal.");
                    new AdicionarTrabajadores();
                    dispose();
                }else{
                    new DatosTrabajadores();
                    dispose();
                }
            }
        });
        botonVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ventas();
                dispose();
            }
        });
        botonUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Compradores();
                dispose();
            }
        });
    }


    public static void main(String[] args) {
        Almacen.addCliente("Maria","123","123");
        Almacen.addCarro("Re","32","C09H",Cilindraje.ALTO,true,true);
        Almacen.addEmpleado("Juan","378","83",389);
        Vendedor v1=new Vendedor("Juan","3432","334",1400,1);
        Empleado em=Almacen.getEmpleados()[0];
        Cliente e1=Almacen.getClientes()[0];
        Carro c1=Almacen.getCarros()[0];
        LocalDate de=LocalDate.now();
        Almacen.addVenta(v1,e1,c1,de,MP.CREDITO);
        Almacen.addCliente("Germán","1234","1234");
        Almacen.addCarro("Ren","32","C0F9H",Cilindraje.ALTO,true,true);
        Almacen.addEmpleado("Juan","378","83",389);
        e1=Almacen.getClientes()[1];
        c1=Almacen.getCarros()[1];
        Almacen.addVenta(v1,e1,c1,de,MP.EFECTIVO);
        new Interfaz();
    }
}
