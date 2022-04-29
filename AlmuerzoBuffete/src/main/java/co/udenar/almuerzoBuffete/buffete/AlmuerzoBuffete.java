package co.udenar.almuerzoBuffete.buffete;

import co.udenar.almuerzoBuffete.domain.Almuerzo;
import co.udenar.almuerzoBuffete.domain.Producto;

import java.util.List;
import java.util.Vector;

public class AlmuerzoBuffete extends Almuerzo {
    private Producto sopa;
    private Producto seco;
    private Producto postre;
    private List<Producto> myOptions;
    

    AlmuerzoBuffete(double p) {
        this.precio = p;
        myOptions = new Vector<>();
    }

    void setSopa(Producto sopa) {
        this.sopa= sopa;
    }
    void setSeco(Producto seco) {
        this.seco= seco;
    }
    void setPostre(Producto postre) { this.postre= postre;}



    void addCarne(Producto option) {
        getMyOptions().add(option);
    }

    public Producto getSopa() {
        return sopa;
    }
    public Producto getSeco() {
        return seco;
    }
    public Producto getPostre() {
        return postre;
    }
   

    public List<Producto> getMyOptions() {
        return myOptions;
    }


    //public Size getSize() {
    //    return size;
    //}


    //public void setSize(Size size) {
    //    this.size = size;
    //}

    // Modificar para extraer sopa, seco y postre y la cantidad de pedidos
    @Override
    public double getPrecio(){
        precio = sopa.getPrice();
        precio += seco.getPrice();
        precio += postre.getPrice();
        for(Producto each: myOptions){
            precio= precio + each.getPrice();
        }
        return precio;
    }

}
