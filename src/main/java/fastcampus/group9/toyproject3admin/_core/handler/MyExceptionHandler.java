package fastcampus.group9.toyproject3admin._core.handler;

import fastcampus.group9.toyproject3admin._core.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException iae){
        return ResponseEntity.badRequest().body(iae.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleServerException(RuntimeException re){
        re.printStackTrace();
        log.error(re.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}
