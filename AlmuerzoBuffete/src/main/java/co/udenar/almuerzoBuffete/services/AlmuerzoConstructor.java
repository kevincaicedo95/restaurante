package co.udenar.almuerzoBuffete.services;

import co.udenar.almuerzoBuffete.buffete.AlmuerzoBuffete;
import co.udenar.almuerzoBuffete.domain.Almuerzo;

import java.io.IOException;

public abstract class AlmuerzoConstructor {
    protected Almuerzo myAlmuerzo;

    Almuerzo getAlmuerzo (){
        return myAlmuerzo;
    }

    public AlmuerzoConstructor init() {return this;}
    public AlmuerzoConstructor setSopa() {return this;}
    public AlmuerzoConstructor setSeco() {return this;}
    public AlmuerzoConstructor setPostre() {return this;}
    public boolean addPart() throws IOException {return false;}
 //   public AlmuerzoConstructor setSize() {return this;}
}
