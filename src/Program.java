import java.util.HashMap;
import java.util.Map;

public class Program {

    HashMap<String,ComposantGui> composantGuis;

    public Program(HashMap<String,ComposantGui> composantGuis) {
        this.composantGuis = composantGuis;
    }

    public ComposantGui getComposant_Gui(String composant_id){
            return this.composantGuis.get(composant_id);
    }

    public Program(Program program) {//Un program represente un etat;
        this.composantGuis=new HashMap<>();
        for (Map.Entry<String, ComposantGui> entry : program.composantGuis.entrySet()) {
            ComposantGui composantGui=new ComposantGui((ComposantGui) entry.getValue());//Create a new clone of the attribute
            this.composantGuis.put(((ComposantGui)entry.getValue()).id,composantGui);
        }
    }

    public void AfficherEtat(){
        for (Map.Entry<String, ComposantGui> entry : this.composantGuis.entrySet()) {
            ((ComposantGui)entry.getValue()).afficherAttributs();
        }
    }
}
