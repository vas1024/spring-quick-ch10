package sq10.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sq10.model.ErrorDetails;
import sq10.model.PaymentDetails;
import sq10.services.PaymentService;
import sq10.exceptions.NotEnoughMoneyException;

import java.util.logging.Logger;


@RestController
public class PaymentController {

  private static Logger logger = Logger.getLogger(PaymentController.class.getName());

  private final PaymentService paymentService;
  public PaymentController( PaymentService paymentService ){
    this.paymentService = paymentService;
  }

  @PostMapping("/payment")
  public ResponseEntity<PaymentDetails> makePayment(){
    PaymentDetails paymentDetails = paymentService.processPayment();
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
  }

  @PostMapping("/paymentWithBody")
  public ResponseEntity<PaymentDetails> makePaymentWithBody(
            @RequestBody PaymentDetails paymentDetails ) {
    logger.info( "received payment " + paymentDetails.getAmount());
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
  }
}
