package co.udenar.almuerzoBuffete.acces;

import co.udenar.almuerzoBuffete.domain.Producto;

import java.util.ArrayList;
import java.util.List;


public class ProductRepositoryImpleArrays implements IProductoRepository{

    public static List<Producto> productos;

    public ProductRepositoryImpleArrays(){
        productos = new ArrayList<>();
        initialize();
    }
    private void initialize() {
        productos.add(new Producto(1, "Consome", 7000));
        productos.add(new Producto(2, "Sancocho", 10000));
        productos.add(new Producto(3, "sopa de verduras", 8000));
        productos.add(new Producto(4, "cerdo", 3000));
        productos.add(new Producto(5, "Res", 4000));
        productos.add(new Producto(6, "Pollo", 3500));
        productos.add(new Producto(7, "Pie limon", 3000));
        productos.add(new Producto(8, "Tres leches", 3000));
        productos.add(new Producto(9, "Cholate", 3000));
    }

    @Override
    public List<Producto> findAll() {return productos;}

    @Override
    public Producto findById(Integer id) {
        for(Producto prod:productos){
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public boolean create(Producto newProducto) {
        Producto prod = this.findById(newProducto.getId());
        if (prod != null) {
            //Ya existe
            return false;
        }
        productos.add(newProducto);
        return true;
    }

    @Override
    public boolean update(Producto newProducto) {
        Producto prod = this.findById(newProducto.getId());
        if (prod != null) {
            prod.setName(newProducto.getName());
            prod.setPrice(newProducto.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        for (Producto prod : productos) {
            if (prod.getId() == id) {
                productos.remove(prod);
                return true;
            }
        }
        return false;
    }
}
