package Ejercicios;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ejercicio_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    
		System.out.print("Ingrese 1 para determinar si un número es primo o no: \n"
				+ "Ingrese 2 para ingresar una lista de enteros y retornar el mayor y menor número \n"
				+ "Ingrese 3 para determinar si una palabra es un palindromo");
        int numero = scanner.nextInt();
        
        if(numero == 1) {
        	ingresarNumero();
        }else if(numero == 2) {
        	listaNumeros();
        }else if(numero == 3) {
        	ingresarPalabra();
        }
        
    }

	public static void ingresarNumero() {
	    Scanner scanner = new Scanner(System.in);
	        
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();
        
        if (esPrimo(numero)) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }
        
        scanner.close();
	}
	
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void listaNumeros() {
    	 Scanner scanner = new Scanner(System.in);
         List<Integer> numeros = new ArrayList<>();

         System.out.println("Ingrese números enteros (escriba 'fin' para terminar):");

        
         while (scanner.hasNext()) {
             if (scanner.hasNextInt()) {
                 numeros.add(scanner.nextInt());
             } else if (scanner.next().equalsIgnoreCase("fin")) {
                 break;
             } else {
                 System.out.println("Entrada no válida. Por favor, ingrese un número entero o 'fin'.");
             }
         }

         if (numeros.isEmpty()) {
             System.out.println("No se ingresaron números.");
         } else {
             int[] resultado = encontrarMinMax(numeros);
             System.out.println("El número más pequeño es: " + resultado[0]);
             System.out.println("El número más grande es: " + resultado[1]);
         }

         scanner.close();
    }
    
    public static int[] encontrarMinMax(List<Integer> numeros) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : numeros) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return new int[]{min, max};
    }
    
    public static void ingresarPalabra() {
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();

        if (esPalindromo(palabra)) {
            System.out.println("\"" + palabra + "\" es un palíndromo.");
        } else {
            System.out.println("\"" + palabra + "\" no es un palíndromo.");
        }

        scanner.close();
    }
    
    public static boolean esPalindromo(String palabra) {
       
        palabra = palabra.replaceAll("\\s+", "").toLowerCase();
        
        int inicio = 0;
        int fin = palabra.length() - 1;

        while (inicio < fin) {
            if (palabra.charAt(inicio) != palabra.charAt(fin)) {
                return false;
            }
            inicio++;
            fin--;
        }
        return true;
    }
}
