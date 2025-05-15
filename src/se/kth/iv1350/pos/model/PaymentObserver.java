package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.model.Payment;

public interface PaymentObserver {


    void newPayment(Payment payment);

}
