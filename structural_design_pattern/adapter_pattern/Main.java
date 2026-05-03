package structural_design_pattern.adapter_pattern;
//used when there are incompatible structures

interface PaymentGateway{
    public void pay(double amount);
}

class PayU implements PaymentGateway{
    @Override
    public void pay(double amount){
        System.out.println("paid amount via payu"+ amount);
    }
}
class RazorpayAPI{
    public void makePayment(double amount){
        System.out.println("Paid via razorpay: "+ amount );
    }
}
class RazorpayAdapter implements PaymentGateway{
    private RazorpayAPI razorpayAPI;

    public RazorpayAdapter(){
        this.razorpayAPI = new RazorpayAPI();
    }
    @Override
    public void pay(double  amount){
        razorpayAPI.makePayment(amount);
    }
}
class CheckoutService{
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void checkout(double amount){
        paymentGateway.pay(amount);
    }
}
public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService1 = new CheckoutService(new PayU());
        checkoutService1.checkout(100);

        CheckoutService checkoutService2 = new CheckoutService(new RazorpayAdapter());
        checkoutService2.checkout(1000);
    }
}
