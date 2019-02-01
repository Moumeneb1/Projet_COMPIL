import java.util.Iterator;
import java.util.TreeSet;

public class Attribut {
    String id;
    String type;
    String values;//a transformer aprés en un treemap

    public void setType(String type) {
        this.type = type;
    }

    public Attribut(String id) {
        this.id = id;

    }

    public void updateValue(String value){
        this.values=value;
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
}
