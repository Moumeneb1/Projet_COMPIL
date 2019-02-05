import java.util.HashMap;

public class Affectation {
    String attribut_src;
    String attribut_dest;

    public Affectation(String attribut_dest, String attribut_src) {
        this.attribut_src = attribut_src;
        this.attribut_dest = attribut_dest;
    }

    public void executeAffectation(HashMap<String,Attribut> set_Attributs){//Cas simple
        Attribut tmp_attribut=set_Attributs.get(attribut_src);
        if(tmp_attribut==null){
            set_Attributs.get(attribut_dest).value=attribut_src;//Ce n'est pas une variable
        }else {
            set_Attributs.get(attribut_dest).value=tmp_attribut.value;//c'est une variable donc on reçoit la valeur
        }



    }
    public void afficher(){
        System.out.println(this.attribut_dest+":="+this.attribut_src);
    }
}
