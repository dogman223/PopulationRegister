package PopulationRegistrationSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AppExceptionHandler {

    public ResponseEntity handleCitizenNotFoundException(){return new ResponseEntity(HttpStatus.NOT_FOUND);}
}
