import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ComposantGui {
  String id;
  String type;
  String parent;
  HashMap<String,Attribut> set_Attributs;
  ArrayList<Evt> set_events;

    public String getId() {
        return id;
    }

    public Attribut getAttribut(String id){
        return this.set_Attributs.get(id);
    }
    public ComposantGui(String id, String type, String parent) {
        this.id = id;

        this.type = type;
        this.parent = parent;
        set_Attributs = new HashMap<>();
        set_events=new ArrayList<>();
    }

    public void add__set_attributs(HashMap<String,Attribut> attributs){//concatener une chaine d'attribut
        this.set_Attributs.putAll(attributs);

    }



    public  void add_set_event(Evt evt){
        this.set_events.add(evt);
    }

    /*public void afficherComposantGui(){
        System.out.println("id : "+id);
        System.out.println("parent : "+parent);
        System.out.println("type : "+type);
        Iterator it =set_Attributs.iterator();
        while (it.hasNext()){
            ((Attribut)it.next()).showAttribut();
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComposantGui that = (ComposantGui) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
