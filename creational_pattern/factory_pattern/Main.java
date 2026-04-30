package creational_pattern.factory_pattern;

interface Logistics {
    public void send();
}

class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending By Road.....");
    }
}

class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending By Air....");
    }
}

// class LogisticService {
// public void send(String mode) {
// if (mode == "Road") {
// Road road = new Road();
// road.send();
// } else if (mode == "Air") {
// Air air = new Air();
// air.send();
// }
// }
// }

class LogisticsFactory {
    public static Logistics getLogistics(String mode) {
        if (mode == "Road")
            return new Road();
        else
            return new Air();
    }
}

class LogisticService {
    public void send(String mode) {
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

public class Main {
    public static void main(String[] args) {
        // LogisticService service1 = new LogisticService();
        // service1.send("Road");

        // LogisticService service2 = new LogisticService();
        // service2.send("Air");

        LogisticService service = new LogisticService();
        service.send("Road");
        service.send("Air");
    }
}
