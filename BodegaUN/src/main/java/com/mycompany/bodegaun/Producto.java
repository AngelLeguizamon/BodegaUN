package com.mycompany.bodegaun;

// Esta clase permite crear objetos tipo producto
public class Producto {
    private String id;       // Identificador único del producto
    private String nombre;   // Nombre del producto
    private double precio;   // Precio del producto
    private int cantidad;    // Cantidad disponible

    // Constructor vacío (necesario para Firebase)
    public Producto() {
    }

    // Constructor para crear un producto fácilmente
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos para obtener y modificar los atributos
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
