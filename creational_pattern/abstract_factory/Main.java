//design a multinational payments system

package creational_pattern.abstract_factory;

interface RegionFactory {
    public PaymentGateway selectPaymentGateway(String paymentGateway);

    public Invoice createInvoice();
}

class IndianFactory implements RegionFactory {
    @Override
    public PaymentGateway selectPaymentGateway(String paymentGateway) {
        if (paymentGateway == "razorpay")
            return new Razorpay();
        else
            return new PhonePe();
    }

    @Override
    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}

class USFactory implements RegionFactory {
    @Override
    public PaymentGateway selectPaymentGateway(String paymentGateway) {
        if (paymentGateway == "stripe")
            return new Stripe();
        else
            return new PayU();
    }

    @Override
    public Invoice createInvoice() {
        return new USInvoice();
    }
}

interface PaymentGateway {
    public void makePayment(double amount);
}

interface Invoice {
    public void generateInvoice();
}

class Razorpay implements PaymentGateway {
    @Override
    public void makePayment(double amount) {
        System.out.println(amount + "payment inititated via Razorpay");
    }
}

class PhonePe implements PaymentGateway {
    @Override
    public void makePayment(double amount) {
        System.out.println(amount + "payment inititated via PhonePe");
    }
}

class PayU implements PaymentGateway {
    @Override
    public void makePayment(double amount) {
        System.out.println(amount + "payment inititated via PayU");
    }
}

class Stripe implements PaymentGateway {
    @Override
    public void makePayment(double amount) {
        System.out.println(amount + "payment initiated via stripe");
    }
}

class GSTInvoice implements Invoice {
    @Override
    public void generateInvoice() {
        System.out.println("GST Invoice generated....");
    }
}

class USInvoice implements Invoice {
    @Override
    public void generateInvoice() {
        System.out.println("US Invoice generated....");
    }
}

class CheckoutService {
    private PaymentGateway pGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory region, String gatewayType) {
        this.pGateway = region.selectPaymentGateway(gatewayType);
        this.gatewayType = gatewayType;
        this.invoice = region.createInvoice();
    }

    public void completeOrder(double amount) {
        pGateway.makePayment(amount);
        invoice.generateInvoice();
    }
}

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService1 = new CheckoutService(new IndianFactory(), "razorpay");
        CheckoutService checkoutService2 = new CheckoutService(new USFactory(), "stripe");

        checkoutService1.completeOrder(1000);
        checkoutService2.completeOrder(10000);
    }
}
