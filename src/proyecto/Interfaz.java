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
        Almacen.addEmpleado("Andres","1","3333333", 5000000,false);
        Almacen.addEmpleado("Julio","2","444444444", 2000000,true);
        Almacen.addEmpleado("Gullermo","3","55555555", 2000000,true);
        Almacen.addEmpleado("Mateo","4","8888888", 8000000,false);
        Almacen.addEmpleado("Camilo","5","3331333", 4000000,false);
        Almacen.addProveedor("Pepitos","111","3232323","Deportivos");
        Almacen.addProveedor("Pepitos","222","3232323","Automóviles");
        Almacen.addProveedor("Pepitos","333","3232323","Deportivos");
        Almacen.addProveedor("Pepitos","444","3232323","Camperos");
        Almacen.addCliente("Johnny","22","1231213");
        Almacen.addCliente("Johnny","33","1231213");
        Almacen.addCliente("Johnny","44","1231213");
        Almacen.addCliente("Johnny","55","1231213");
        Almacen.addCliente("Johnny","66","1231213");
        Almacen.addCarro("Volvo", "2023", "0", Cilindraje.MEDIO, true, true, "Deportivo");
        Almacen.addCarro("Suzuki","2023","0",Cilindraje.MEDIO,true,true, "Automovil");
        Almacen.addCarro("BMW","2023","0",Cilindraje.ALTO,true,true, "Deportivo");
        Almacen.addCarro("BMW","2023","0",Cilindraje.ALTO,true,true, "Automovil");
        Almacen.addCarro("BMW","2023","0",Cilindraje.BAJO,true,true, "Campero");
        Almacen.addCarro("Volvo","2023","0",Cilindraje.MEDIO,true,true, "Campero");
        Almacen.addCarro("BMW","2023","0",Cilindraje.BAJO,true,true, "Automovil");
    }

}
