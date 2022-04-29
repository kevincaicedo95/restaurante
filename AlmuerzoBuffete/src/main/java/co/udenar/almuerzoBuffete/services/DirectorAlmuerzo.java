package co.udenar.almuerzoBuffete.services;

import co.udenar.almuerzoBuffete.domain.Almuerzo;

import java.io.IOException;

public class DirectorAlmuerzo {
    private AlmuerzoConstructor builder;

    public DirectorAlmuerzo(AlmuerzoConstructor builder) {
        this.builder = builder;
    }

    public Almuerzo getAlmuerzo () {
        return builder.getAlmuerzo();
    }

    public void create () throws IOException {
        boolean adicion = true;
        builder.setSize();
        builder.init();
        builder.setSopa();
        builder.setSeco();
        builder.setPostre();
        while (adicion){
            adicion=builder.addPart();
        }
    }
}
