package model;

public class Robot {

    private int x;

    private int y;

    private int codice;

    //Costruttore della classe Robot per impostare i valori inziali di X e Y
    public Robot(int codice, int x, int y) {
        this.x = x;
        this.y = y;
        this.codice= codice;
    }

    public void nord(){
        this.x++;
    } // x crescente muove verso nord

    public void sud(){
        this.x--;
    } // x decrescente muove verso sud

    public void est(){
        this.y++;
    } // y crescente muove verso est

    public void ovest(){
        this.y--;
    } // y decrescente muove verso ovest

    public int getCodice() {
        return codice;
    }

    // stampa delle coordinate
    @Override
    public String toString() {
        return "Codice robot: " + codice + " -> " + "Coordinate{" + x + "," + y + '}';
    }
}
