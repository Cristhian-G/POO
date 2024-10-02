/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.cualtos.cristhian.practica_integradora_1;

/**
 *
 * @author ramir
 */
public class Producto {
    // Constructor de la clase Producto
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre; // Inicializar el nombre del producto
        this.precio = precio; // Inicializar el precio del producto
        this.cantidad = cantidad; // Inicializar la cantidad del producto
    }
    
    private String nombre; // Nombre del producto
    private double precio; // Precio del producto
    private int cantidad; // Cantidad del producto

    // Método para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método para establecer el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Método para establecer el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para obtener la cantidad del producto
    public int getCantidad() {
        return cantidad;
    }

    // Método para establecer la cantidad del producto
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // Método para representar el objeto Producto como una cadena de texto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Crear un StringBuilder para construir la cadena
        
        sb.append("\nNombre: ").append(nombre); // Añadir el nombre del producto a la cadena
        sb.append("\nPrecio: ").append(precio); // Añadir el precio del producto a la cadena
        sb.append("\nCantidad: ").append(cantidad); // Añadir la cantidad del producto a la cadena
        return sb.toString(); // Devolver la cadena construida
    }
}
