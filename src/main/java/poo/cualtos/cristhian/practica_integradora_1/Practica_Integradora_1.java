/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package poo.cualtos.cristhian.practica_integradora_1;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Cristhian German Ramirez Ruiz
 * @author Jose Manuel Rocha
 */
public class Practica_Integradora_1 {

    //Inventario de productos 
    static ArrayList<Producto> inventario = new ArrayList();
    
    // Función principal del programa
    public static void main(String[] args) {
    int eleccion; // Variable para almacenar la elección del usuario
    boolean salir = false; // Variable para controlar el bucle del menú

    // Bucle do-while para mostrar el menú hasta que el usuario decida salir
    do {
        eleccion = Funcion.menu(); // Mostrar el menú y obtener la elección del usuario
        
        // Estructura switch para manejar las diferentes opciones del menú
         switch (eleccion) {
            case 1 -> agragarProducto(); // Llamar a la función para agregar un producto
            case 2 -> eliminarProducto(); // Llamar a la función para eliminar un producto
            case 3 -> modificarProducto(); // Llamar a la función para modificar un producto
            case 4 -> buscarProducto(); // Llamar a la función para buscar un producto
            case 5 -> mostarInventario(); // Llamar a la función para mostrar el inventario
            case 6 -> {
                        System.out.println("    |Cerrando|"); // Mensaje de cierre del programa
                        salir = true; // Cambiar la variable para salir del bucle
                      }
            default -> System.err.println("    |Opción no válida|"); // Mensaje de error para opción no válida
        }
    } while (!salir); // Continuar el bucle mientras salir sea falso
}
    
    //Función para agregar un producto al inventario
    public static void agragarProducto(){
        String nombre;//Nombre del producto
        double precio;//Precio del producto
        int cantidad;//cantidad de productos
        
        //Titulo de la sección
        System.out.println();
        System.out.println("    ||Agregar producto al inventario||     ");
        System.out.print("Nombre del producto: ");//Solicitar el nombre del producto al usuario
        nombre = Funcion.validarNombre();//Verificar que el nombre ingresado por el usuario es correcto y guardarlo 
        System.out.print("Precio del producto: ");//Solicitar el precio del producto al usuario
        precio = Funcion.validarPrecio();//Verificar que el precio ingresado por el usuario es correcto y guardarlo
        System.out.print("Cantidad de Producto: ");//Solicitar la cantidad de productos al usuario
        cantidad = Funcion.validarCantidad();//Verificar que la cantidad de productos ingresada por el usuario es correcto y guardarlo
        
        Producto producto = new Producto(nombre,precio,cantidad);//Crea el nuevo producto en el sistema
        
        inventario.add(producto);//Guarda el producto en el inventario
        
        System.out.println("    |Producto agregado al inventario|");//Mensaje de confirmación
        System.out.println();
        
    }
    
    //Funcion para eliminar un producto del inventario
    public static void eliminarProducto() {
    String confirmacion; // Confirmación de eliminación
    String articulo; // Nombre del producto a eliminar
    int aux; // Elección en caso de búsqueda fallida

    // Título de la sección
    System.out.println("    ||Eliminar producto de inventario||     ");
    System.out.print("Nombre del producto: "); // Solicitar al usuario el nombre del producto a eliminar
    articulo = Funcion.validarNombre(); // Verificar que el nombre ingresado por el usuario es correcto y lo guarda

    // Usar un iterador para evitar ConcurrentModificationException
    Iterator<Producto> iterator = inventario.iterator();
    boolean productoEncontrado = false;//Confirmación de producto encontrado
    
    //Iterador que avarca todo el inventario 
    while (iterator.hasNext()) { //hasNext se utiliza para refererise al siguente termino, si lo hay
        Producto indice = iterator.next();//Obtener el siguiente producto del inventario
        if (articulo.equals(indice.getNombre())) {//comparar el nombre del producto con el nombre ingresado
            productoEncontrado = true; //Marcar que el producto ha sido encontrado
            System.out.println("¿Seguro que desea borrar este producto del inventario? (Y/n): ");
            confirmacion = Funcion.validarConfirmacion();//Validar la confirmacion del usuario

            if (confirmacion.equals("Y")) {//Si la confirmación es "Y" (si)
                iterator.remove();//Eliminar producto del inventario
                System.out.println("    |Producto Eliminado del inventario|");
                System.out.println();
            } else {//Si la confirmación es "n" (no)
                System.out.println("    |Operacion cancelada|");
                System.out.println();
            }
            break; // Salir del bucle una vez que el producto ha sido encontrado y procesado
        }
    }

    if (!productoEncontrado) {//Si el producto no fue encontrado
        System.err.println("Error: Producto no encontrado.");
        System.out.println();
        System.out.println("    ||Opciones||      ");
        System.out.println("1) Volver a intentar.");
        System.out.println("2) Cancelar");
        System.out.print("Opcion: ");

        aux = Funcion.validarAlternativa();//Validar la opcion ingresada por el usuario

        if (aux == 1) {//Si la opcion es 1 (Volver a intentar)
            eliminarProducto();//Llamar de nuevo a la función para intentar eliminar el producto.
        } else {//Si la opción es 2 ( cancelar)
            System.out.println("    |Operacion cancelada|");
            System.out.println();
        }
    }
}
    
    //Funcion para mostrar todo el inventario
    public static void mostarInventario(){
        System.out.println("    ||Inventario||  ");
        
        //Recorrer y mostrar cada producto en el inventario
        for(Producto producto: inventario){
            System.out.println(producto);//Imprimir la información del producto
        }
        System.out.println();
    }
    
    //Funcion para buscar productos por nombre
    public static void buscarProducto(){
        boolean productoEncontrado = false;
        int aux;
        String nombre;
        
        //Tituto de la sección
        System.out.println();
        System.out.println("    ||Buscador||    ");
        System.out.print("Nombre del producto: ");//Solicita al usuario el nombre del producto a buscar
        nombre = Funcion.validarNombre();//Verifica que el ingreso un nombre correcto y lo guarda.
        
        for(Producto articulo: inventario){ //Interacion sobre todo el inventario
            if(nombre.equals(articulo.getNombre())){//Si el nombre ingresado por el usuario coincide con el del producto en el inventario
                productoEncontrado = true; //El producto enncotrado pasa a ser verdadero
                System.out.println(articulo);//Imprimir los datos del producto
                System.out.println();
                break;//Terminar bucle
            }
        }
        
        //Si el producto no se encontro
        if(productoEncontrado == false){
            System.err.println("Error: Articulo no encontrado.");//Mostrar mensaje de error
            System.out.println();
                System.out.println("    ||Opciones||    ");//Mostrar menu de opciones secundario
                System.out.println("1) Volver a intentar.");
                System.out.println("2) Calcelar");
                System.out.print("Opcion: ");
                
                aux = Funcion.validarAlternativa();//Validar y guardar la elección del usuario.
                
                if(aux == 1){//Si la elección es 1
                    buscarProducto();//Volver a intentar la busqueda
                }else{//Si la elección es 2
                    System.out.println("    |Operacion cancelada|"); //Cancelar la busqueda
                    System.out.println();
                }
        }
    }
    
    //Funcion para modificar la informacion del producto
    public static void modificarProducto(){
        boolean confirmacion = false; //Indica si el cambio del producto se hizo.
        boolean productoEncontrado = false;//Indica si el producto fue encontrado
        String nombre;//Nombre del producto a modificar
        String nuevoNombre;//Nuevo nombre del producto
        double nuevoPrecio;//Nuevo precio del producto
        int nuevaCantidad;//Nueva cantidad del producto
        int auxiliar;//Variable auxiliar para opciones del usuario
        
        //Titulo de la sección
        System.out.println();
        System.out.println("    ||Modificar datos de producto||    ");
        System.out.print("Nombre del producto: ");//Solicitar al usuario el nombre del producto a modificar
        nombre = Funcion.validarNombre();//Validar y guardar el nombre ingresado por el usuario.
        
        //Recorrer el inventario para encontrar el producto
        for(Producto articulo: inventario){
            if(nombre.equals(articulo.getNombre())){//Comparar el nombre del producto con el nombre ingresado
                System.out.println("    |Producto enconctrado|");
                System.out.println();
                System.out.println(articulo);//Mostrar la información del producto
                System.out.println();
                productoEncontrado = true;//Marcar que el producto ha sido encontrado
                
                //solicitar al usuario qué dato desea cambiar
                System.out.println("¿Que dato desea cambiar?");
                System.out.println("1) Nombre.");
                System.out.println("2) Precio.");
                System.out.println("3) Catidad.");
                System.out.println("4) Cancelar.");
                System.out.print("Opcion: ");
                auxiliar = Funcion.validarEleccion();//Validar la elección del usuario
                
                while(!confirmacion){
                    switch(auxiliar){
                        case 1 -> {
                            System.out.print("Nombre: ");
                            nuevoNombre = Funcion.validarNombre();//Validar y guardar el nuevo nombre
                            articulo.setNombre(nuevoNombre);//Actualizar el nombre del producto
                            System.out.println("    |Dato modificado|");
                            System.out.println();
                            confirmacion = true;
                        }
                        case 2 -> {
                            System.out.print("Precio: ");
                            nuevoPrecio = Funcion.validarPrecio();//Validar y guardar el nuevo precio
                            articulo.setPrecio(nuevoPrecio);//Actualizar el precio del producto
                            System.out.println("    |Dato modificado|");
                            System.out.println();
                            confirmacion = true;
                        }
                        case 3 -> {
                            System.out.print("Cantidad:");//Validar y guardar la nueva cantidad
                            nuevaCantidad = Funcion.validarCantidad();//Actualizar la cantidad del producto
                            articulo.setCantidad(nuevaCantidad);
                            System.out.println("    |Dato modificado|");
                            System.out.println();
                            confirmacion = true;
                        }
                        case 4 -> {
                            System.out.println("    |Operacion cancelada|.");//Cancelar la operacion
                            System.out.println();
                            confirmacion = true;
                        }
                        default -> System.err.println("Error: Opcion no valida.");//manejar opción no válida
                    }
                }
                confirmacion = false;//restablecer la confirmacion de cambio
            }
        }
        
        //si el producto no fue encontrado
        if(productoEncontrado == false){
            System.err.println("Error: Articulo no encontrado.");
            System.out.println();
                System.out.println("    ||Opciones||    ");
                System.out.println("1) Volver a intentar.");
                System.out.println("2) Calcelar");
                System.out.print("Opcion: ");
                
                auxiliar = Funcion.validarAlternativa();//Validar la opción ingresada por el usuario
                
                if(auxiliar == 1){// Si la opción es 1 (volver a intentar)
                    modificarProducto();// Llamar de nuevo a la función para intentar modificar el producto
                }else{// Si la opción es 2 (cancelar)
                    System.out.println("    |Operacion cancelada|");
                    System.out.println();
                }
        }
    }
}
