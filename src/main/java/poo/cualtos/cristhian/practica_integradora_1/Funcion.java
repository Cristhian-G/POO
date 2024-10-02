/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.cualtos.cristhian.practica_integradora_1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ramir
 */
public final class Funcion {
    static Scanner sc = new Scanner(System.in);
    
    // Menú principal de la aplicación
public static int menu() {
    int eleccion; // Variable para almacenar la elección del usuario
    
    // Mostrar las opciones del menú
    System.out.println("    ||Inventario||  ");
    System.out.println("1) Agregar producto al inventario.");
    System.out.println("2) Eliminar Producto.");
    System.out.println("3) Modificar informacion de producto.");
    System.out.println("4) Buscar producto.");
    System.out.println("5) Mostrar inventario.");
    System.out.println("6) Salir.");
    System.out.print("Opcion: ");
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            eleccion = sc.nextInt(); // Leer la elección del usuario
            sc.nextLine(); // Limpiar el buffer del scanner
            if (eleccion <= 0) { // Verificar que la elección sea un número positivo
                throw new InputMismatchException("Opción no valida."); // Lanzar excepción si la elección no es válida
            }
            return eleccion; // Devolver la elección válida
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Seleccione una opcion valida."); // Solicitar una opción válida al usuario
            sc.next();
        }catch(Exception e){
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Seleccione una opcion valida."); // Solicitar una opción válida al usuario
            sc.next();
        }
    }
}
    
    // Función para validar el nombre del producto
public static String validarNombre() {
    String nombre; // Variable para almacenar el nombre del producto
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            nombre = sc.nextLine(); // Leer el nombre ingresado por el usuario
            // Verificar que el nombre no esté vacío y que solo contenga letras y espacios
            if (nombre.isEmpty() || !nombre.matches("[a-zA-Z ]+")) {
                throw new InputMismatchException("Error de formato"); // Lanzar excepción si el formato es incorrecto
            }
            return nombre; // Devolver el nombre válido
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e.getMessage()); // Mostrar mensaje de error
            System.err.println("Por favor ingrese el dato solicitado (solo letras y espacios)."); // Solicitar una entrada válida
        }catch (Exception e){
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Por favor ingrese el dato solicitado (solo letras y espacios)."); // Solicitar una entrada válida
        }
    }
}
    
    // Función para validar la cantidad de productos
public static int validarCantidad() {
    int cantidad; // Variable para almacenar la cantidad de productos
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            cantidad = sc.nextInt(); // Leer la cantidad ingresada por el usuario
            sc.nextLine(); // Limpiar el buffer del scanner
            if (cantidad <= 0) { // Verificar que la cantidad sea un número positivo
                throw new InputMismatchException("Cantidad no valida"); // Lanzar excepción si la cantidad no es válida
            }
            return cantidad; // Devolver la cantidad válida
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Ingrese una cantidad valida (en números naturales)."); // Solicitar una entrada válida
            sc.next(); // Limpiar la entrada no válida del scanner
        } catch (Exception e) { // Capturar cualquier otra excepción
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Favor de volver a intentarlo."); // Solicitar al usuario que intente nuevamente
            sc.next();
        }
    }
}
    
    // Función para validar el precio del producto
public static double validarPrecio() {
    double precio; // Variable para almacenar el precio del producto
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            precio = sc.nextDouble(); // Leer el precio ingresado por el usuario
            sc.nextLine(); // Limpiar el buffer del scanner
            if (precio <= 0.0) { // Verificar que el precio sea mayor a 0.0
                throw new InputMismatchException("Precio no valido"); // Lanzar excepción si el precio no es válido
            }
            return precio; // Devolver el precio válido
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Ingrese un numero mayor a 0.0"); // Solicitar una entrada válida
            sc.next(); // Limpiar la entrada no válida del scanner
        } catch (Exception e) { // Capturar cualquier otra excepción
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Favor de intentarlo nuevamente."); // Solicitar al usuario que intente nuevamente
            sc.next();
        }
    }
}
    
// Función para validar la confirmación del borrado de un producto
public static String validarConfirmacion() {
    String eleccion; // Variable para almacenar la elección del usuario
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            eleccion = sc.nextLine().trim(); // Leer la elección ingresada por el usuario
            // Verificar que la elección sea 'Y' o 'n'
            if (!eleccion.equals("Y") && !eleccion.equals("n")) {
                throw new InputMismatchException("Opción no válida."); // Lanzar excepción si la elección no es válida
            }
            return eleccion; // Devolver la elección válida
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Favor de ingresar una opcion valida. (Y/n)"); // Solicitar una entrada válida
        } catch (Exception e) { // Capturar cualquier otra excepción
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Favor de volverlo a intentar."); // Solicitar al usuario que intente nuevamente
        }
    }
}
    
// Función para validar la elección del usuario en caso de elemento no encontrado
public static int validarAlternativa() {
    int eleccion; // Variable para almacenar la elección del usuario
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            eleccion = sc.nextInt(); // Leer la elección ingresada por el usuario
            sc.nextLine(); // Limpiar el buffer del scanner
            // Verificar que la elección esté entre 1 y 2
            if (eleccion < 1 || eleccion > 2) {
                throw new InputMismatchException("Opcion no valida"); // Lanzar excepción si la elección no es válida
            }
            return eleccion; // Devolver la elección válida
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Seleccione una opcion valida."); // Solicitar una entrada válida
            sc.next(); // Limpiar la entrada no válida del scanner
        }catch(Exception e){
           System.err.println("Error: " + e); // Mostrar mensaje de error
           System.err.println("Seleccione una opcion valida."); // Solicitar una entrada válida
           sc.next();
        }
    }
}
    
    // Función para validar la elección de modificación de dato
public static int validarEleccion() {
    int opcion; // Variable para almacenar la opción del usuario
    
    // Bucle infinito para asegurar una entrada válida del usuario
    while (true) {
        try {
            opcion = sc.nextInt(); // Leer la opción ingresada por el usuario
            sc.nextLine(); // Limpiar el buffer del scanner
            // Verificar que la opción esté entre 1 y 4
            if (opcion < 1 || opcion > 4) {
                throw new InputMismatchException("Opcion no valida."); // Lanzar excepción si la opción no es válida
            }
            return opcion; // Devolver la opción válida
        } catch (InputMismatchException e) { // Capturar excepción de entrada no válida
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Seleccione una opcion valida"); // Solicitar una entrada válida
            sc.next(); // Limpiar la entrada no válida del scanner
        }catch(Exception e){
            System.err.println("Error: " + e); // Mostrar mensaje de error
            System.err.println("Seleccione una opcion valida"); // Solicitar una entrada válida
            sc.next();
        }
    }
}
}
