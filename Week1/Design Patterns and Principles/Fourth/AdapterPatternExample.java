package Fourth;

interface PaymentProcessor {
    void processPayment(double amount);
}

class PayPalGateway {
    void sendMoney(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via PayPal");
    }
}

class StripeGateway {
    void makePayment(double amount) {
        System.out.println("Processing payment of ₹" + amount + " via Stripe");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPal;

    PayPalAdapter(PayPalGateway payPal) {
        this.payPal = payPal;
    }

    public void processPayment(double amount) {
        payPal.sendMoney(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripe;

    StripeAdapter(StripeGateway stripe) {
        this.stripe = stripe;
    }

    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(1000);
        stripeProcessor.processPayment(2500);
    }
}
