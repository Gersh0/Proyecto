package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.Arrays;

public abstract class Almacen {
    private static Carro[] carros;
    private static Cliente[] clientes;
    private static Empleado[] empleados;
    private static String nombre;
    private static String dirreccion;

    //Carro[] carros, Cliente[] clientes, Empleado[] empleados, Ventas[] ventas,
   /* public Almacen(String nombre, String dirreccion) {
        carros = new Carro[0];
        clientes = new Cliente[0];
        empleados = new Empleado[0];
        this.nombre = nombre;
        this.dirreccion = dirreccion;
    }*/

    public static Carro[] getCarros() {
        return carros;
    }

    public static Cliente[] getClientes() {
        return clientes;
    }

    public static Empleado[] getEmpleados() {
        return empleados;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getDirreccion() {
        return dirreccion;
    }

    public static void addCliente(String nombre, String cedula, String tel) {
        if (clientes[0] == null) {
            clientes = new Cliente[1];
            clientes[0] = new Cliente(nombre, cedula, tel);
        } else {
            clientes = Arrays.copyOf(clientes, clientes.length + 1);
            clientes[clientes.length - 1] = new Cliente(nombre, cedula, tel);
        }
    }

    public static void addEmpleado(String nombre, String cedula, String tel, double salario) {
        if (empleados == null) {
            empleados = new Empleado[1];
            empleados[0] = new Empleado(nombre, cedula, tel, salario);
        } else {
            empleados = Arrays.copyOf(empleados, empleados.length + 1);
            empleados[empleados.length - 1] = new Empleado(nombre, cedula, tel, salario);
        }
    }

    public static void addCarro(String marca, String modelo, String serial, Cilindraje tipo, boolean disponible, boolean estado) {//Ver cómo involucrar al proveedor
        Carro carro = new Carro(marca, modelo, serial, tipo, disponible, estado);
        carros = Arrays.copyOf(carros, carros.length + 1);
        carros[carros.length - 1] = carro;
    }

    public static void addVenta(Vendedor vendedor, Cliente cliente, Carro carro, LocalDate fecha, MP formaDePago) {
        cliente.registrarCompra(new Venta(vendedor, cliente, carro, fecha, formaDePago));
    }

    public static int buscarCliente(String cedula) {//ver cómo poner con personas
        int i = 0;
        while (!cedula.equals(clientes[i].getCedula()) && i < clientes.length) {
            i++;
            if (i == clientes.length) {
                System.out.println("El usuario no existe");
            }
        }
        return i;
    }

    public static int buscarEmpleado(String cedula) {
        int i = 0;
        while (!cedula.equals(empleados[i].getCedula()) && i < empleados.length) {
            i++;
            if (i == empleados.length) {
                System.out.println("El usuario no existe");

            }
        }

        return i;
    }

    public static int buscarCarro(String marca, String modelo) { //Buscar por marca y modelo y que muestre las cilindradas;
        int i = 0;
        while (!marca.equals(carros[i].getMarca()) && !modelo.equals(carros[i].getModelo()) && i < carros.length) {
            i++;
            if (i == carros.length) {
                System.out.println("El carro no existe");

            }
        }

        return i;
    }

    public static void delCliente(String cedula) {//ver cómo poner con personas
        int i = 0;
        while (!cedula.equals(clientes[i].getCedula())) {
            i++;
        }

        System.arraycopy(clientes, i + 1, clientes, i, clientes.length - 1 - i);
        clientes = Arrays.copyOf(clientes, clientes.length - 1);
    }

    public static void delEmpleado(String cedula) {
        int i = 0;
        while (!cedula.equals(clientes[i].getCedula())) {
            i++;
        }

        System.arraycopy(empleados, i + 1, empleados, i, empleados.length - 1 - i);
        empleados = Arrays.copyOf(empleados, empleados.length - 1);
    }

    public static void delCarro(String marca, String modelo) {
        int i = 0;
        while (!marca.equals(carros[i].getMarca()) && !modelo.equals(carros[i].getModelo())) {
            i++;
        }

        System.arraycopy(carros, i + 1, carros, i, carros.length - 1 - i);
        carros = Arrays.copyOf(carros, carros.length - 1);
    }

    public static int CantidadVentasRealizasHastaAhora() {
        int cont = 0;
        for (Cliente c : clientes)
            cont += c.getCantVentas();
        return cont;
    }

    public static int CantidadClientesHastaAhora() {
        return clientes.length;
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


/*
    public static void main(String[] args) {
        Automovil carro = new Automovil("Samsung", "GalaxyS11", "3312123", Cilindraje.ALTO, true, true);

        carro.setPlaca("ABC123");//Ya se hizo una compra.

        System.out.println(carro.getPlaca());

        new Interfaz();
    }
    */
}

