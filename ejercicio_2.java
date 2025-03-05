package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicio_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    
		System.out.print("Ingrese 1 para ingresar empleados: \n"
				+ "Ingrese 2 para seleccionar un vehiculo y acelerar \n"
				+ "Ingrese 3 para realizar pago por transferencia o tarjeta de credito");
        int numero = scanner.nextInt();
        
        if(numero == 1) {
        	Empresa empresa = new Empresa();
            empresa.registrarEmpleados();

            System.out.println("El salario promedio de los empleados es: " + empresa.calcularSalarioPromedio());
    	
        }else if(numero == 2) {
        	System.out.println("Seleccione el tipo de vehículo (carro/moto):");
            String tipo = scanner.nextLine().toLowerCase();

            Vehiculo vehiculo;
            if ("carro".equals(tipo)) {
                vehiculo = new Carro();
            } else if ("moto".equals(tipo)) {
                vehiculo = new Moto();
            } else {
                System.out.println("Tipo de vehículo no reconocido. Saliendo...");
                scanner.close();
                return;
            }

            vehiculo.acelerar();
        }else if(numero == 3) {
        	 System.out.println("Seleccione el método de pago (tarjeta/transferencia):");
             String metodo = scanner.nextLine().toLowerCase();

             System.out.println("Ingrese el monto a pagar:");
             double cantidad = scanner.nextDouble();

             scanner.nextLine();

             System.out.println("Ingrese su clave:");
             String clave = scanner.nextLine();

             Pagable metodoPago;
             if ("tarjeta".equals(metodo)) {
                 metodoPago = new TarjetaCredito();
             } else if ("transferencia".equals(metodo)) {
                 metodoPago = new TransferenciaBancaria();
             } else {
                 System.out.println("Método de pago no reconocido. Saliendo...");
                 scanner.close();
                 return;
             }

             metodoPago.procesarPago(cantidad, clave);
        }
	}
	
	public static class Empleado {
	    private String nombre;
	    private double salario;
	    private String cargo;

	    public Empleado(String nombre, double salario, String cargo) {
	        this.nombre = nombre;
	        this.salario = salario;
	        this.cargo = cargo;
	    }

	    public double getSalario() {
	        return salario;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getCargo() {
	        return cargo;
	    }
	}

	public static class Empresa {
	    private List<Empleado> empleados = new ArrayList<>();

	    public void agregarEmpleado(Empleado empleado) {
	        empleados.add(empleado);
	    }

	    public double calcularSalarioPromedio() {
	        if (empleados.isEmpty()) return 0.0;
	        double suma = 0.0;
	        for (Empleado e : empleados) {
	            suma += e.getSalario();
	        }
	        return suma / empleados.size();
	    }

	    public void registrarEmpleados() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Ingrese la cantidad de empleados a registrar:");
	        int cantidad = scanner.nextInt();
	        scanner.nextLine(); 

	        for (int i = 0; i < cantidad; i++) {
	            System.out.println("Ingrese el nombre del empleado:");
	            String nombre = scanner.nextLine();

	            System.out.println("Ingrese el salario del empleado:");
	            double salario = scanner.nextDouble();
	            scanner.nextLine(); 

	            System.out.println("Ingrese el cargo del empleado:");
	            String cargo = scanner.nextLine();

	            agregarEmpleado(new Empleado(nombre, salario, cargo));
	        }
	    }
	}
	
	public static class Vehiculo {
	    public void acelerar() {
	        System.out.println("El vehículo está acelerando.");
	    }
	}

	public static class Carro extends Vehiculo {
	    @Override
	    public void acelerar() {
	        System.out.println("El carro acelera rápidamente.");
	    }
	}

	public static class Moto extends Vehiculo {
	    @Override
	    public void acelerar() {
	        System.out.println("La moto acelera ágilmente.");
	    }
	}

	public interface Pagable {
	    void procesarPago(double cantidad, String clave);
	}

	
	public static class TarjetaCredito implements Pagable {
	    @Override
	    public void procesarPago(double cantidad, String clave) {
	        System.out.println("Pago de " + cantidad + " realizado con tarjeta de crédito. Clave: " + clave);
	    }
	}

	
	public static class TransferenciaBancaria implements Pagable {
	    @Override
	    public void procesarPago(double cantidad, String clave) {
	        System.out.println("Pago de " + cantidad + " realizado mediante transferencia bancaria. Clave: " + clave);
	    }
	}


}	
