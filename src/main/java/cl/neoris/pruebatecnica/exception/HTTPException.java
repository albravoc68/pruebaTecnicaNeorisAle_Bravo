package cl.neoris.pruebatecnica.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HTTPException extends Exception {

    private HttpStatus status;

    public HTTPException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

}
