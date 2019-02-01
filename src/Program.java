import java.util.HashMap;

public class Program {

    HashMap<String,ComposantGui> composantGuis;

    public Program(HashMap<String,ComposantGui> composantGuis) {
        this.composantGuis = composantGuis;
    }

    public ComposantGui getComposant_Gui(String composant_id){
            return this.composantGuis.get(composant_id);
    }
}
