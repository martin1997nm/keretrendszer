package RepulonNyilvantartas.exceptions;

public class NSzamMarLetezik extends Throwable {
    public NSzamMarLetezik(String rendszam) {
        super("A megadott N mar szerepel az adatbázisunkban:"+rendszam);
    }
}
