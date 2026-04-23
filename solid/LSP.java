package solid;

class Notification{
    void sendNotification(){
        System.out.println("Text Notification Sent");
    }
}
class WappNotification extends Notification{
    @Override
    void sendNotification() {
        System.out.println("Whatsapp Notification Sent");
    }
}

public class LSP {
    public static void main(String[] args) {
        Notification notification = new Notification();
        Notification notification1 = new WappNotification();
        notification1.sendNotification(); //sends whatsapp notification
        notification.sendNotification(); //sends text notification
    }
}
