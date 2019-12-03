package RepulonNyilvantartas.service.impl;

import RepulonNyilvantartas.dao.RepuloDAO;
import RepulonNyilvantartas.exceptions.NSzamMarLetezik;
import RepulonNyilvantartas.exceptions.RepuloNemTalalhato;
import RepulonNyilvantartas.exceptions.RosszDatum;
import RepulonNyilvantartas.exceptions.RosszEvjarat;
import RepulonNyilvantartas.exceptions.RosszNszam;
import RepulonNyilvantartas.model.Repulo;
import RepulonNyilvantartas.model.Repulo;
import RepulonNyilvantartas.service.RepuloService;

import java.util.ArrayList;
import java.util.Collection;

public class RepuloServiceImpl implements RepuloService {
    private RepuloDAO dao;

    public RepuloServiceImpl(RepuloDAO dao) {
        this.dao = dao;
    }

    public Collection<Repulo> listAllRepulo() {
        return dao.readAllRepulo();
    }

    public Repulo getNszam(String nszam) throws RosszNszam, RepuloNemTalalhato {
        return dao.readRepulo(nszam);
    }

    public void addRepulo(Repulo repulo) throws RosszDatum, RosszEvjarat, RosszNszam, NSzamMarLetezik {

        dao.insertRepulo(repulo);
    }

    public void deleteRepulo(Repulo repulo) throws RepuloNemTalalhato {
        dao.deleteRepulo(repulo);

    }

    public Collection<Repulo> listAllAutosByManufacturer(String manufacturer) {
        Collection<Repulo> allRepulo = dao.readAllRepulo();

        Collection<Repulo> result = new ArrayList<Repulo>();
        for (Repulo a: allRepulo){
            if(a.getGyarto().equalsIgnoreCase(manufacturer)){
                result.add(a);
            }

        }
        return result;
    }

    @Override
    public void updateRepulo(Repulo repulo) throws RepuloNemTalalhato {
        dao.updateRepulo(repulo);
    }
}
