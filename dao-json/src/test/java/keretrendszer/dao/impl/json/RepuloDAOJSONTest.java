package keretrendszer.dao.impl.json;

import RepulonNyilvantartas.dao.RepuloDAO;
import RepulonNyilvantartas.exceptions.NSzamMarLetezik;
import RepulonNyilvantartas.exceptions.RosszDatum;
import RepulonNyilvantartas.exceptions.RosszEvjarat;
import RepulonNyilvantartas.exceptions.RosszNszam;
import RepulonNyilvantartas.model.Allapot;
import RepulonNyilvantartas.model.Repulo;
import RepulonNyilvantartas.model.Repulo;
import org.junit.Test;

import java.time.LocalDate;

public class RepuloDAOJSONTest {

    @Test
    public void test() {
        RepuloDAO dao = new RepuloDAOJSON("src/main/resources/jsonfile.json");
        try {
            Repulo repulo = new Repulo("Boeing","737","N12345",LocalDate.of(1998, 10, 11),1300,50000,2,280,34,1998,"#FFFFFF", Allapot.RONCS);
            dao.insertRepulo(repulo);
            System.out.println(dao.readAllRepulo());
        } catch (RosszDatum rosszDatum) {
            rosszDatum.printStackTrace();
        } catch (RosszNszam rosszNszam) {
            rosszNszam.printStackTrace();
        } catch (RosszEvjarat rosszEvjarat) {
            rosszEvjarat.printStackTrace();
        } catch (NSzamMarLetezik NSzamMarLetezik) {
            NSzamMarLetezik.printStackTrace();
        }

    }


}