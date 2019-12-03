package RepulonNyilvantartas.service;

import RepulonNyilvantartas.exceptions.*;
import RepulonNyilvantartas.model.Repulo;

import java.util.Collection;

public interface RepuloService {
    public Collection<Repulo> listAllRepulo();

    public Repulo getNszam(String nszam) throws RosszNszam, RepuloNemTalalhato;

    public void addRepulo(Repulo repulo) throws RosszDatum, RosszEvjarat, RosszNszam, NSzamMarLetezik;

    public void deleteRepulo(Repulo repulo) throws RepuloNemTalalhato;

    public Collection<Repulo> listAllAutosByManufacturer(String manufacturer);


    public void updateRepulo(Repulo repulo) throws RepuloNemTalalhato;

}
