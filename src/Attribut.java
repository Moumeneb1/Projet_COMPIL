import java.util.Iterator;
import java.util.TreeSet;

public class Attribut {
    String id;
    String type;
    String value="NULL";//a transformer aprés en un treemap

    public void setType(String type) {
        this.type = type;
    }

    public Attribut(String id) {
        this.id = id;

    }

    public void updateValue(String value){
        this.value=value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribut attribut = (Attribut) o;

        return id.equals(attribut.id);
    }

    public void showAttribut(){
        System.out.println("id :"+this.id+","+this.type);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Attribut(Attribut attribut) {//Fonction pour cloner un nouveau etat
        this.id=new String(attribut.id);
        this.type=new String(attribut.type);
        this.value=new String(attribut.value);
    }
}
