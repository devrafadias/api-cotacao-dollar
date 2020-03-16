package br.com.bb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.bb.gateway.json.RespostaCotacaoDolar;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(CotacaoDolarException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RespostaCotacaoDolar process(RuntimeException ex) {
        return new RespostaCotacaoDolar(ex.getMessage());
    }
    
}
