package sq10.controllers.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sq10.exceptions.NotEnoughMoneyException;
import sq10.model.ErrorDetails;

@RestControllerAdvice
public class ExceptionControllerAdvice {
  @ExceptionHandler(NotEnoughMoneyException.class)
  public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
    ErrorDetails errorDetails = new ErrorDetails();
    errorDetails.setMessage("Not enough money to make the payment");
    return ResponseEntity.badRequest().body(errorDetails);
  }
}
