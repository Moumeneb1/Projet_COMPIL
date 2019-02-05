import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Automate {

    HashMap<Etat,HashMap<Etat,ArrayList<String>>> tableDeTransition;


    public Automate() {
        tableDeTransition=new HashMap<>();
    }

    public void afficher(){
        for (Map.Entry<Etat, HashMap<Etat,ArrayList<String>>> entry : tableDeTransition.entrySet()) {
            Etat etat = entry.getKey();
            System.out.println("Etat "+etat.id);
            HashMap<Etat,ArrayList<String>> list_depuis_source=entry.getValue();//Create a new clone of the attribute
            for(Map.Entry<Etat,ArrayList<String>> entry1 : list_depuis_source.entrySet()){
                System.out.println("goes to "+entry1.getKey().id);
                entry1.getValue().forEach(e->{
                    System.out.println("With "+e+" transition");
                });
            }

        }
    }

    void addTransition(Etat etatSource, Etat etatDestination,String declancheur){
        HashMap<Etat,ArrayList<String>> list_depuis_source;
        ArrayList<String> transtion;
        if((list_depuis_source=tableDeTransition.get(etatSource))!=null){//etat existe déja
                if((transtion=list_depuis_source.get(etatDestination))!=null){//la liste n'est pas vide
                    transtion.add(declancheur);
            }else{//on a jamais atteint la destination depuis la source
                    transtion=new ArrayList<>();
                    transtion.add(declancheur);
                    list_depuis_source.put(etatDestination,transtion);
            }
        }else{
            transtion=new ArrayList<>();
            transtion.add(declancheur);
            list_depuis_source=new HashMap<>();
            list_depuis_source.put(etatDestination,transtion);
            tableDeTransition.put(etatSource,list_depuis_source);

        }
    }

}
