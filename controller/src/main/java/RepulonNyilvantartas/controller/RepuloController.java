package RepulonNyilvantartas.controller;

import RepulonNyilvantartas.exceptions.*;
import RepulonNyilvantartas.model.Repulo;
import RepulonNyilvantartas.service.RepuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class RepuloController {
    RepuloService service;

    public RepuloController(@Autowired(required = true) RepuloService service) {
        this.service = service;
    }




    @RequestMapping(value = "test")
    @ResponseBody
    public String testService(){
        return String.valueOf(service.listAllRepulo().size());
    }

    @RequestMapping(value = "/getRepuloData/{Nszam}")
    @ResponseBody
    public Repulo getRepuloByNszam(@PathVariable(value = "nszam") String nszam) throws RepuloNemTalalhato, RosszNszam {

        return service.getNszam(nszam);
    }

    @RequestMapping(value ="addRepulo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void addRepulo(@RequestBody Repulo repulo) throws RosszDatum, RosszEvjarat, RosszNszam, NSzamMarLetezik {
        service.addRepulo(repulo);

    }

    @RequestMapping(value = "/listRepulo", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Repulo> listRepulo(){
        return service.listAllRepulo();

    }

    @RequestMapping(value = "/deleteRepulo", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteRepulo(@RequestBody Repulo repulo) throws RepuloNemTalalhato {
        service.deleteRepulo(repulo);
    }

    @RequestMapping(value = "/updateRepulo", method= RequestMethod.POST)
    @ResponseBody
    public void updateRepulo(@RequestBody Repulo repulo) throws RepuloNemTalalhato {
        service.updateRepulo(repulo);
    }


}
