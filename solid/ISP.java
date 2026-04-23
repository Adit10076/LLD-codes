package solid;


interface RiderInterface{
    public void acceptRide();
    public void endRide();
}
interface UserInterface{
    public void bookRide();
    public void payForRide();
}

class Rider implements RiderInterface{
    @Override
    public void acceptRide(){
        System.out.println("Ride Accepted");
    }

    @Override
    public void endRide(){
        System.out.println("Ride Ended");
    }
}

class User implements UserInterface{
    @Override
    public void bookRide(){
        System.out.println("Ride Booked");
    }
    @Override
    public void payForRide(){
        System.out.println("Payment Done");
    }
}
public class ISP {
    public static void main(String[] args) {
        Rider rider = new Rider();
        User user = new User();

        user.bookRide();
        rider.acceptRide();
        rider.endRide();
        user.payForRide();
    }
}
