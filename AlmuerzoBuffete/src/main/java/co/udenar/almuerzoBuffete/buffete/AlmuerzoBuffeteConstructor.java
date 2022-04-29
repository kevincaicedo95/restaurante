package co.udenar.almuerzoBuffete.buffete;

import co.udenar.almuerzoBuffete.acces.ProductRepositoryImpleArrays;
import co.udenar.almuerzoBuffete.domain.Producto;
import co.udenar.almuerzoBuffete.services.AlmuerzoConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AlmuerzoBuffeteConstructor extends AlmuerzoConstructor {
    ProductRepositoryImpleArrays myRepository;
    AlmuerzoBuffete myAlmuerzoBuffete;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Producto> allProductos;
    List<Producto>  sopa;
    List<Producto>  seco;
    List<Producto>  postre;

    private Producto read(List<Producto> myProducts, String foodPart) {
        String input = "";
        try {
            int i =1;
            System.out.println("Seleccione: "+foodPart);
            for (Producto each: myProducts){
                System.out.println(""+i+". "+ each.getName() + ":"+each.getPrice());
                i++;
            }
            System.out.println("Ingrese opcion: "+ foodPart);
            input = br.readLine();
        } catch (IOException e) {
        }
        return myProducts.get(Integer.parseInt(input)-1);
    }

    private String read(String message) {
        String input = "";
        try {
            System.out.println(message);
            input = br.readLine();
        } catch (IOException e) {
        }
        return input;
    }

     // Corregir para adicionar sopa, seco y postre
    @Override
    public AlmuerzoConstructor init() {
        myRepository = new ProductRepositoryImpleArrays();
        myAlmuerzo = new AlmuerzoBuffete(0.0);
        myAlmuerzoBuffete = (AlmuerzoBuffete) myAlmuerzo;
        //Obtenemos todos los productos
        allProductos = myRepository.findAll();
        // Obtenemos las bases y las opciones
        sopa = new ArrayList<>();
        seco = new ArrayList<>();
        postre = new ArrayList<>();
        for(Producto each: allProductos){
            if(each.getId()<4)
                sopa.add(each);
            else if (each.getId()>3 && each.getId()<7)
                seco.add(each);
            else
                postre.add(each);
        }
        return this ;
    }

    @Override
    public AlmuerzoConstructor setSopa() {
        myAlmuerzoBuffete.setSopa(read(sopa, "Sopa"));
        return this;
    }
    @Override
    public AlmuerzoConstructor setSeco() {
        myAlmuerzoBuffete.setSeco(read(seco, "Seco"));
        return this;
    }

    @Override
    public AlmuerzoConstructor setPostre() {
        myAlmuerzoBuffete.setPostre(read(postre, "postre"));
        return this;
    }


    @Override
    public boolean addPart() throws IOException {
        if ("S".equals(read("Presione S para más opciones"))){
            myAlmuerzoBuffete.addCarne(read(seco, "Carne"));
            return true;
        }
        else return false;
    }

    @Override
    public AlmuerzoConstructor setSize() {
        String tamano = read("Elija la cantidad de almuerzos que desea pagar");
        int tamanoInt = Integer.parseInt(tamano);
        return this;
    }



}
