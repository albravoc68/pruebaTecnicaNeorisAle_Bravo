package cl.neoris.pruebatecnica.controller.advice;

import cl.neoris.pruebatecnica.dto.ErrorDTO;
import cl.neoris.pruebatecnica.exception.HTTPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerExceptionHandler {

    @ExceptionHandler(value = HTTPException.class)
    protected ResponseEntity<ErrorDTO> handleError(HTTPException e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), e.getStatus());
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<ErrorDTO> handleError(Exception e) {
        return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
