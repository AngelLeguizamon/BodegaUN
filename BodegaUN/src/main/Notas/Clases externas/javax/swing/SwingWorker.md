## #doInBackground
es un método **abstracto**, es decir que no tiene una implementación predeterminada y **tú** debes escribir el código que deseas que se ejecute en segundo plano

En este caso, sobrescribimos #doInBackground para indicarle que debe leer la lista de productos con ProductCRUD.readProducts().

```java
@Override
    protected List<Producto> doInBackground() throws Exception {
        // Esta operación se ejecuta en un hilo en segundo plano
        return ProductCRUD.readProducts();
```

La accion de sobreescribir se hace con 
``` java
@Override
```
antes del codigo a sobreescribir