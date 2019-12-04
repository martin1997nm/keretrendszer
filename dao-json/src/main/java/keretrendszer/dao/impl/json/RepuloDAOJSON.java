package keretrendszer.dao.impl.json;

import RepulonNyilvantartas.dao.RepuloDAO;
import RepulonNyilvantartas.exceptions.NSzamMarLetezik;
import RepulonNyilvantartas.exceptions.RepuloNemTalalhato;
import RepulonNyilvantartas.exceptions.RosszNszam;
import RepulonNyilvantartas.model.Repulo;
import RepulonNyilvantartas.model.Repulo;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RepuloDAOJSON implements RepuloDAO {

    File jsonfile;

    ObjectMapper mapper;

    public RepuloDAOJSON(String filepath) {
        jsonfile = new File(filepath);
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        if (!jsonfile.exists()) {
            try {
                jsonfile.createNewFile();
                FileWriter writer = new FileWriter(jsonfile);
                writer.write("[]");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Collection<Repulo> readAllRepulo() {
        Collection<Repulo> result = new ArrayList<Repulo>();
        try {
            result = mapper.readValue(jsonfile, new TypeReference<ArrayList<Repulo>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Repulo readRepulo(String nszam) throws RosszNszam, RepuloNemTalalhato {
        try {
            Repulo repulo = new Repulo();
            repulo.setNszam(nszam);
        }
        catch (RosszNszam rosszNszam) {
            throw rosszNszam;
        }
        Collection<Repulo> autos = readAllRepulo();
        for(Repulo auto: autos){
            if (auto.getNszam().equalsIgnoreCase(nszam)){
                return auto;
            }
        }
        throw new RepuloNemTalalhato();
}



    public void insertRepulo(Repulo repulo) throws NSzamMarLetezik, RosszNszam {
        try{
            readRepulo(repulo.getNszam());
            throw new NSzamMarLetezik(repulo.getNszam());
        } catch (RepuloNemTalalhato repuloNemTalalhato) {
            Collection<Repulo> autos = readAllRepulo();
            autos.add(repulo);
            try {
                mapper.writeValue(jsonfile, autos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;


        }

    }

    public void updateRepulo(Repulo repulo) throws RepuloNemTalalhato {
        Collection<Repulo> repulok = readAllRepulo();
        try {
            Repulo repulotorlendo = readRepulo(repulo.getNszam());
            repulok.remove(repulotorlendo);
            repulok.add(repulo);
            mapper.writeValue(jsonfile, repulok);
        } catch (RosszNszam rosszNszam) {
            rosszNszam.printStackTrace();
        } catch (RepuloNemTalalhato nem_talalhato){
            throw nem_talalhato;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void deleteRepulo(Repulo auto) throws RepuloNemTalalhato {
        Collection<Repulo> repulok = readAllRepulo();
        try {
            Repulo repulotorlendo = readRepulo(auto.getNszam());
            repulok.remove(repulotorlendo);
            mapper.writeValue(jsonfile, repulok);
        } catch (RosszNszam rosszNszam) {
            rosszNszam.printStackTrace();
        } catch (RepuloNemTalalhato nem_talalhato){
            throw nem_talalhato;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
