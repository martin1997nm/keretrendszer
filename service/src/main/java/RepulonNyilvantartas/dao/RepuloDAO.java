package RepulonNyilvantartas.dao;

import RepulonNyilvantartas.exceptions.RepuloNemTalalhato;
import RepulonNyilvantartas.exceptions.NSzamMarLetezik;
import RepulonNyilvantartas.exceptions.RosszNszam;
import RepulonNyilvantartas.model.Repulo;

import java.util.Collection;

public interface RepuloDAO {

    public Collection<Repulo> readAllRepulo();

    public Repulo readRepulo(String nszam) throws RosszNszam, RepuloNemTalalhato;

    public void insertRepulo(Repulo repulo) throws NSzamMarLetezik, RosszNszam;

    public void updateRepulo(Repulo repulo) throws RepuloNemTalalhato;

    public void deleteRepulo(Repulo repulo) throws RepuloNemTalalhato;
}
