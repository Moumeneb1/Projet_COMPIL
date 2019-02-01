public class Affectation {
    String attribut_src;
    String attribut_dest;

    public Affectation(String attribut_dest, String attribut_src) {
        this.attribut_src = attribut_src;
        this.attribut_dest = attribut_dest;
    }

    public void afficher(){
        System.out.println(this.attribut_dest+":="+this.attribut_src);
    }
}
