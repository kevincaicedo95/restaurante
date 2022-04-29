package co.udenar.almuerzoBuffete.acces;

import co.udenar.almuerzoBuffete.domain.Producto;

import java.util.List;

public interface IProductoRepository {
        List<Producto> findAll();
        Producto findById(Integer id);
        boolean create(Producto newProducto);
        boolean update(Producto newProducto);
        boolean delete(Integer id);
}
