abstract class Transport {
    protected String trackingId;

    public Transport(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract void dispatch();
}

interface GPS {
    void getCoordinates();
}

class DeliveryDrone extends Transport implements GPS {

    public DeliveryDrone(String trackingId) {
        super(trackingId);
    }

    public void dispatch() {
        System.out.println("Drone " + trackingId + " taking off...");
    }

    public void getCoordinates() {
        System.out.println("40.7128° N...");
    }
}

class Truck extends Transport {

    public Truck(String trackingId) {
        super(trackingId);
    }

    public void dispatch() {
        System.out.println("Truck " + trackingId + " leaving warehouse...");
    }
}

public class SmartLogisticsSystem {
    public static void main(String[] args) {

    
        Transport t = new DeliveryDrone("D101");
        t.dispatch();

        
        GPS g = new DeliveryDrone("D101");
        g.getCoordinates();

        
        if (t instanceof GPS) {
            System.out.println("True for Drone");
        }

        Transport t2 = new Truck("T201");
        if (!(t2 instanceof GPS)) {
            System.out.println("False for Truck");
        }
    }
}