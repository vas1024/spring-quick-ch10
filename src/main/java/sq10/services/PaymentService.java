package sq10.services;

import org.springframework.stereotype.Service;
import sq10.exceptions.NotEnoughMoneyException;
import sq10.model.PaymentDetails;

@Service
public class PaymentService {
  public PaymentDetails processPayment(){
    throw new NotEnoughMoneyException();
  }
}
