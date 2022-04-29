package co.udenar.almuerzoBuffete.buffete;

import co.udenar.almuerzoBuffete.domain.Almuerzo;
import co.udenar.almuerzoBuffete.services.AlmuerzoConstructor;
import co.udenar.almuerzoBuffete.services.DirectorAlmuerzo;

import java.io.IOException;

public class MainRestaurante {
    public static void main(String[] args) throws IOException {
        DirectorAlmuerzo director = new DirectorAlmuerzo(new AlmuerzoBuffeteConstructor());
        director.create();
        Almuerzo myDish = director.getAlmuerzo();
        System.out.println("El plato le cuesta: "+ myDish.getPrecio());
    }
}
