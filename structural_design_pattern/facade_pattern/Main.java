package structural_design_pattern.facade_pattern;

class PaymentSystem{
    public void makePayment(double amount){
        System.out.println("Payment made for amount: " + amount);
    }
}
class RestaurauntNotify{
    public void notifyRestauraunt(String orderId){
        System.out.println("Restaurant notified successfully for orderId: " + orderId );
    }
}
class AssignRider{
    public void assignRider(){
        System.out.println("Rider Assigned Successfully");
    }
}

class GPSTracking{
    public void track(){
        System.out.println("GPS enabled successfully");
    }
}
class NotificationService{
    public void sendNotification(){
        System.out.println("Notification sent successfully");
    }
}

class ZomatoFacade{
    private PaymentSystem paymentSystem;
    private RestaurauntNotify restaurauntNotify;
    private GPSTracking gpsTracking;
    private AssignRider assignRider;
    private NotificationService notificationService;

    public ZomatoFacade(){
        this.paymentSystem = new PaymentSystem();
        this.restaurauntNotify = new RestaurauntNotify();
        this.assignRider = new AssignRider();
        this.gpsTracking = new GPSTracking();
        this.notificationService = new NotificationService();
    }

    public void placeOrder(String orderId , int amount) {
        paymentSystem.makePayment(amount);
        restaurauntNotify.notifyRestauraunt(orderId);
        assignRider.assignRider();
        gpsTracking.track();
        notificationService.sendNotification();

        System.out.println("Order placed! ");
    }
}
public class Main {
    public static void main(String[] args) {
        ZomatoFacade zomatoFacade = new ZomatoFacade();
        zomatoFacade.placeOrder("23242-adit-332",1000);
    }
}
