package com.mycompany.bodegaun;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.api.core.ApiFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;

public class ProductCRUD {

    // =================== CREATE ===================
    // Crea un nuevo producto en Firebase
    public static void createProduct(Producto producto) {
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
        // Se crea un nuevo nodo (con un ID único) en "productos"
        DatabaseReference newProductRef = databaseRef.child("productos").push();
        producto.setId(newProductRef.getKey());
        ApiFuture<Void> future = newProductRef.setValueAsync(producto);
        try {
            future.get();
            System.out.println("¡Producto creado correctamente!");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }
    }
    
    // =================== READ ===================
    // Lee la lista de productos de Firebase de forma asíncrona
    public static List<Producto> readProducts() {
        List<Producto> productos = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("productos");
        CountDownLatch latch = new CountDownLatch(1);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    Producto producto = child.getValue(Producto.class);
                    producto.setId(child.getKey());
                    productos.add(producto);
                }
                latch.countDown(); // Indica que ya terminó la lectura
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("Error al leer productos: " + error.getMessage());
                latch.countDown();
            }
        });
        try {
            latch.await(); // Espera hasta que se lean los datos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Ordenar los productos en forma ascendente por el nombre
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getNombre().compareToIgnoreCase(p2.getNombre());
            }
        });
        return productos;
    }
    
    // =================== DELETE ===================
    // Elimina un producto en Firebase usando su ID
    public static void deleteProduct(String id) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("productos").child(id);
        ApiFuture<Void> future = ref.removeValueAsync();
        try {
            future.get();
            System.out.println("Producto eliminado correctamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
    
    // =================== UPDATE ===================
    // Actualiza los datos de un producto en Firebase usando su ID
    public static void updateProduct(String id, Producto updatedProducto) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("productos").child(id);
        updatedProducto.setId(id);
        ApiFuture<Void> future = ref.setValueAsync(updatedProducto);
        try {
            future.get();
            System.out.println("Producto actualizado correctamente.");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        }
    }
}
