public class Path {//Class qui contient la transition d'avant et celle qui commence le bloque
    Etat avant;
    Etat avant_avant;

    public Path(Etat avant, Etat avant_avant) {
        this.avant = avant;
        this.avant_avant = avant_avant;
    }
}
