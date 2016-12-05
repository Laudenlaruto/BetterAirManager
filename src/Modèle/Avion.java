package Modèle;

/**
 * Created by ben_s on 29/11/2016.
 */
public class Avion {
    private TypeAvion typeAvion;
    private String ref;
    public Avion(TypeAvion typeAvion, String ref){
        this.typeAvion = typeAvion;
        this.ref = ref;
    }

    public TypeAvion getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(TypeAvion typeAvion) {
        this.typeAvion = typeAvion;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
