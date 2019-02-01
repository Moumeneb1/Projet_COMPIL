import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ComposantGui {
  String id;
  String type;
  String parent;
  HashSet<Attribut> set_Attributs;
  ArrayList<Evt> set_events;

    public ComposantGui(String id, String type, String parent) {
        this.id = id;
        this.type = type;
        this.parent = parent;
        set_Attributs = new HashSet<>();
        set_events=new ArrayList<>();
    }

    public void add__set_attributs(HashSet<Attribut> attributs){//concatener une chaine d'attribut
        this.set_Attributs.addAll(attributs);

    }


    public  void add_set_event(Evt evt){
        this.set_events.add(evt);
    }

    public void afficherComposantGui(){
        System.out.println("id : "+id);
        System.out.println("parent : "+parent);
        System.out.println("type : "+type);
        Iterator it =set_Attributs.iterator();
        while (it.hasNext()){
            ((Attribut)it.next()).showAttribut();
        }
    }

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
