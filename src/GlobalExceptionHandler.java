import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception ex){
        ex.printStackTrace();  // prints the full error stack
        return ResponseEntity.status(500).body("Error: " + ex.getMessage());
    }
}
