package RepulonNyilvantartas.service;

import RepulonNyilvantartas.exceptions.*;
import RepulonNyilvantartas.model.Repulo;

import java.util.Collection;

public interface RepuloService {
    public Collection<Repulo> listAllRepulo();

    public Repulo getNszam(String nszam) throws RosszNszam, RepuloNemTalalhato;

    public void addRepulo(Repulo repulo) throws RosszDatum, RosszEvjarat, RosszNszam, NSzamMarLetezik;

    public Repulo deleteRepulo(Repulo nszam) throws RepuloNemTalalhato;

    public Collection<Repulo> listAllRepuloByManufacturer(String manufacturer);


    public void updateRepulo(Repulo repulo) throws RepuloNemTalalhato;

}
