package services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

import java.util.HashMap;
import java.util.Map;

public class StripeService {

    private static final String SECRET_KEY = "pk_test_51QxnFtFjdr7TgGjOATvNs8MHVvQHlcCeQvJj68xbCXmVQfzBVDIggqwB6e4mVSSOCQua9o2woCQBzBqvKdm2AkVC00kye0OHZQ";

    public StripeService() {
        Stripe.apiKey = SECRET_KEY;
    }
    public PaymentIntent createPaymentIntent(double amount, String currency, String description) throws StripeException {
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount((long) (amount * 100))
                        .setCurrency(currency)
                        .setDescription(description)
                        .build();

        return PaymentIntent.create(params);
    }
    public Charge createCharge(String token, double amount, String currency, String description) throws StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (long) (amount * 100));
        chargeParams.put("currency", currency);
        chargeParams.put("description", description);
        chargeParams.put("source", token);

        return Charge.create(chargeParams);
    }
}
