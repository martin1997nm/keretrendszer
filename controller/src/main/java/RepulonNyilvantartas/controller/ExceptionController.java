package RepulonNyilvantartas.controller;

import RepulonNyilvantartas.exceptions.NSzamMarLetezik;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NSzamMarLetezik.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.IM_USED)
    public String duplikalt(NSzamMarLetezik e){
        return e.getMessage()+", frissíteni kellene a meglévő elemet "+e.toString();

    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public String unsupoorted(){
        return "elfogadhato media tipusok:"+ MediaType.APPLICATION_JSON_VALUE;
    }
}
