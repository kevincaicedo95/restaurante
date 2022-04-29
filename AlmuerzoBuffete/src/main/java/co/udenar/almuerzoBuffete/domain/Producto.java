package co.udenar.almuerzoBuffete.domain;

public class Producto {
    private int id;
    private String name;
    private double precio;

    public Producto(int id, String name, double precio) {
        this.id = id;
        this.name = name;
        this.precio = precio;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return precio;
    }

    public void setPrice(double price) {
        this.precio = price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + precio + '}';
    }
}
