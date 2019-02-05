import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ComposantGui {
  String id;
  String type;
  String parent;
  HashMap<String,Attribut> set_Attributs;
  ArrayList<Evt> set_events;//j'ai utilisé une liste car il peut avoir plusieur click mais sur des objets différents


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

    public Evt getEvt(String type){//returns the event
        Evt tmp_evt = null;
        Iterator<Evt> it=set_events.iterator();
        while (it.hasNext()){
            tmp_evt=it.next();
            //System.out.println(tmp_evt.type);
            if(tmp_evt.type.equals(type)){
                return tmp_evt;
            }
        }
        return null;
    }

    public void add__set_attributs(HashMap<String,Attribut> attributs){//concatener une chaine d'attribut
        this.set_Attributs.putAll(attributs);

    }



    public  void add_set_event(Evt evt){
        this.set_events.add(evt);
    }

    public ArrayList<Evt> getSet_events() {
        return set_events;
    }

    public ComposantGui(ComposantGui composantGui) {//utilsé pour cloner un nouveau composant gui
        this.id=composantGui.id;
        this.type=composantGui.type;
        this.parent=composantGui.parent;
        this.set_events=composantGui.set_events;
        this.set_Attributs=new HashMap<>();
        for (Map.Entry<String, Attribut> entry : composantGui.set_Attributs.entrySet()) {
            Attribut attribut=new Attribut((Attribut)entry.getValue());//Create a new clone of the attribute
            this.set_Attributs.put(((Attribut)entry.getValue()).id,attribut);
        }
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
    public void appliquerEvent(Evt evt){//Cas simple affecation d'un boolean et entier berk pour le moment
        Attribut attribut_cond1=this.getAttribut(evt.attribut_Cond1);
        Attribut attribut_cond2=this.getAttribut(evt.attribut_Cond2);
        System.out.println("*********************");
        System.out.println(evt.cond);
        System.out.println(evt.type);
        System.out.println(attribut_cond1.id);
        System.out.println(attribut_cond1.value);
        System.out.println(evt.attribut_Cond2);
        System.out.println("*********************");
        String comparabale_value;
        if (attribut_cond2!=null){//c'est une valeur exacte ce n'est pas une variable
            comparabale_value=attribut_cond2.value;
        }else {
            comparabale_value=evt.attribut_Cond2;
        }
        if(evt.cond.equals("=") && attribut_cond1.value.equals(comparabale_value)){//Cas d'egalité berk
            System.out.println("we are doing it"+attribut_cond1.id+attribut_cond1.value);
            Iterator<Affectation> it =evt.affectations.iterator();
            while (it.hasNext()){
                it.next().executeAffectation(this.set_Attributs);
            }
        }

    }

    public void afficherAttributs(){
        System.out.println("Composant "+this.id);
        for (Map.Entry<String, Attribut> entry : this.set_Attributs.entrySet()) {
            System.out.println("Attribut:"+((Attribut)entry.getValue()).id+" a la valeur "+((Attribut)entry.getValue()).value);
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
