package proyecto;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.Arrays;

class EAlmacen extends Exception {
    public EAlmacen(String a) {
        super(a);
    }
}

public abstract class Almacen {
    private static Carro[] carros;
    private static Cliente[] clientes;
    private static Empleado[] empleados;
    private static Proveedor[] proveedores;
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

    public static Proveedor[] getProveedores() {
        return proveedores;
    }

    public static String getNombre() {
        return nombre;
    }

    public static String getDirreccion() {
        return dirreccion;
    }

    public static void addCliente(String nombre, String cedula, String tel) {
        if (clientes == null) {
            clientes = new Cliente[1];
            clientes[0] = new Cliente(nombre, cedula, tel);
        } else {
            clientes = Arrays.copyOf(clientes, clientes.length + 1);
            clientes[clientes.length - 1] = new Cliente(nombre, cedula, tel);
        }
    }

    public static void addEmpleado(String nombre, String cedula, String tel, double salario, boolean isVendedor) {
        if (empleados == null) {
            empleados = new Empleado[1];
            if (isVendedor) {
                empleados[0] = new Vendedor(nombre, cedula, tel, salario);
            } else {
                empleados[0] = new Empleado(nombre, cedula, tel, salario);
            }
        } else {
            empleados = Arrays.copyOf(empleados, empleados.length + 1);
            if (isVendedor) {
                empleados[empleados.length - 1] = new Vendedor(nombre, cedula, tel, salario);
            } else {
                empleados[empleados.length - 1] = new Empleado(nombre, cedula, tel, salario);
            }
        }
    }

    public static void addCarro(String marca, String modelo, String serial, Cilindraje tipo, boolean disponible, boolean estado) {//Ver cómo involucrar al proveedor
        if (carros == null) {
            carros = new Carro[1];
            carros[0] = new Carro(marca, modelo, serial, tipo, estado, disponible);
        } else {
            Carro carro = new Carro(marca, modelo, serial, tipo, disponible, estado);
            carros = Arrays.copyOf(carros, carros.length + 1);
            carros[carros.length - 1] = carro;
        }
    }

    public static void addProveedor(String nombre, String nit, String tel, String tipoCarro) {
        if (proveedores == null) {
            proveedores = new Proveedor[1];
            proveedores[0] = new Proveedor(nombre, nit, tel, tipoCarro);
        } else {
            proveedores = Arrays.copyOf(proveedores, proveedores.length + 1);
            proveedores[proveedores.length - 1] = new Proveedor(nombre, nit, tel, tipoCarro);
        }
    }

    public static void addCarro(String marca, String modelo, String serial, Cilindraje tipo, boolean disponible, boolean estado, String tipoCarro) {//Ver cómo involucrar al proveedor
        switch (tipoCarro.toLowerCase()) {
            case "campero":
                Campero campero = new Campero(marca, modelo, serial, tipo, disponible, estado);
                if (carros == null) {
                    carros = new Carro[1];
                    carros[0] = campero;
                } else {
                    carros = Arrays.copyOf(carros, carros.length + 1);
                    carros[carros.length - 1] = campero;
                }
                break;
            case "deportivo":
                Deportivo deportivo = new Deportivo(marca, modelo, serial, tipo, disponible, estado);
                if (carros == null) {
                    carros = new Carro[1];
                    carros[0] = deportivo;
                } else {
                    carros = Arrays.copyOf(carros, carros.length + 1);
                    carros[carros.length - 1] = deportivo;
                }
                break;
            case "automovil":
                Automovil automovil = new Automovil(marca, modelo, serial, tipo, disponible, estado);
                if (carros == null) {
                    carros = new Carro[1];
                    carros[0] = automovil;
                } else {
                    carros = Arrays.copyOf(carros, carros.length + 1);
                    carros[carros.length - 1] = automovil;
                    break;
                }
        }
    }

    public static void addVenta(Vendedor vendedor, Cliente cliente, Carro carro, LocalDate fecha, MP formaDePago) {
        cliente.registrarCompra(new Venta(vendedor, cliente, carro, fecha, formaDePago));
    }

    public static int buscarProveedor(String nit) {//ver cómo poner con personas
        int i = 0;

        if (proveedores == null) {//Si es null envía -1 para indicar que no existe
            return -1;
        } else {
            while (i < proveedores.length && !nit.equals(proveedores[i].getCedula())) {
                i++;
            }
            if (i >= proveedores.length) {
                return -1;//Si i es mayor que el arreglo entonces no encontró nada y envía -1 para indicar que no existe
            }
            return i;
        }
    }

    public static int buscarCliente(String cedula){//ver cómo poner con personas
        int i = 0;
        if (clientes == null) {//Si es null envía -1 para indicar que no existe
            return -1;
        } else {
            while (i < clientes.length && !cedula.equals(clientes[i].getCedula())) {
                i++;
            }
            if (i >= clientes.length) {
                return -1;//Si i es mayor que el arreglo entonces no encontró nada y envía -1 para indicar que no existe
            }
            return i;
        }
    }

    public static int buscarEmpleado(String cedula) throws ArrayIndexOutOfBoundsException {
        int i = 0;
        if (empleados == null) {//Si es null envía -1 para indicar que no existe
            return -1;
        } else {
            while (i < empleados.length && !cedula.equals(empleados[i].getCedula())) {
                i++;
            }
            if (i >= empleados.length) {
                return -1;//Si i es mayor que el arreglo entonces no encontró nada y envía -1 para indicar que no existe
            }
            return i;
        }
    }

    public static int buscarCarro(String marca, String serial) { //Buscar por marca y modelo y que muestre las cilindradas;
        int i = 0;
        if (carros == null) {//Si es null envía -1 para indicar que no existe
            return -1;
        } else {//Sino procede con búsqueda:  para detener el ciclo el index(i) debe ser mayor que el length del arreglo y, a su vez, los dos datos ingresados deben coincidir con algún carro del arreglo.
            while ((i < carros.length) && !(serial.equals(carros[i].getSerial()) && marca.equalsIgnoreCase(carros[i].getMarca()))) {
                i++;
            }
            if (i >= carros.length) {
                return -1;//Si i es mayor que el arreglo entonces no encontró nada y envía -1 para indicar que no existe
            }
            return i;
        }
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
        while (!cedula.equals(empleados[i].getCedula())) {
            i++;
        }

        System.arraycopy(empleados, i + 1, empleados, i, empleados.length - 1 - i);
        empleados = Arrays.copyOf(empleados, empleados.length - 1);
    }

    public static void delProveedor(String cedula) {
        int i = 0;
        while (!cedula.equals(proveedores[i].getCedula())) {
            i++;
        }

        System.arraycopy(proveedores, i + 1, proveedores, i, proveedores.length - 1 - i);
        proveedores = Arrays.copyOf(proveedores, proveedores.length - 1);
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

    public static boolean soloLetras(String texto) {
        boolean containsOnlyLetters = true;
        for (char c : texto.toCharArray()) {
            if (!Character.isLetter(c)) {
                containsOnlyLetters = false;
                break;
            }
        }

        if (containsOnlyLetters) {
            System.out.println("The string contains only letters.");
        } else {
            System.out.println("The string contains other characters as well.");
        }
        return containsOnlyLetters;
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

