package Ejercicios;

import java.util.*;
import java.util.stream.Collectors;

public class ejercicio_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        List<String> nombres = new ArrayList<>();

        System.out.println("Ingrese nombres (escriba 'fin' para terminar):");
        while (true) {
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;
            nombres.add(nombre);
        }

        
        List<String> nombresConA = nombres.stream()
            .filter(nombre -> nombre.startsWith("A"))
            .collect(Collectors.toList());
        System.out.println("Nombres que comienzan con 'A': " + nombresConA);

        
        List<String> nombresMayusculas = nombres.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Nombres en mayúsculas: " + nombresMayusculas);

       
        long cuentaMasDe5Letras = nombres.stream()
            .filter(nombre -> nombre.length() > 5)
            .count();
        System.out.println("Cantidad de nombres con más de 5 letras: " + cuentaMasDe5Letras);

        
        Map<String, Long> conteoPalabras = nombres.stream()
            .collect(Collectors.groupingBy(nombre -> nombre, Collectors.counting()));
        System.out.println("Conteo de palabras: " + conteoPalabras);

        scanner.close();
	}

}
