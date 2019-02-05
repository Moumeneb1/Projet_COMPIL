public class Etat {
    static int id_gen;
    int id;

    public Etat() {
        this.id = id_gen;
        id_gen++;
    }
}
