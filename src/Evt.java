import java.util.HashSet;

public class Evt {
    String type ;
    String attribut_Cond1;
    String attribut_Cond2;
    String cond;
    HashSet<Affectation> affectations;

    public Evt(String type, String attribut_Cond1, String attribut_Cond2, String cond, HashSet<Affectation> affectations) {
        this.type = type;
        this.attribut_Cond1 = attribut_Cond1;
        this.attribut_Cond2 = attribut_Cond2;
        this.cond = cond;
        this.affectations = affectations;
    }


}
