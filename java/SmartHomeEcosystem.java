abstract class Device {
    protected String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public abstract void turnOn();
}

interface RemoteControllable {
    void connectToWifi();
}

class SmartTV extends Device implements RemoteControllable {

    public SmartTV(String brand) {
        super(brand);
    }

    public void turnOn() {
        System.out.println(brand + " TV is booting up...");
    }

    public void connectToWifi() {
        System.out.println("Connecting to Home_5G...");
    }
}

public class SmartHomeEcosystem {
    public static void main(String[] args) {

        Device d = new SmartTV("Sony");
        d.turnOn();

        RemoteControllable r = new SmartTV("LG");
        r.connectToWifi();

        // r.turnOn(); // ❌ Compile-time error (DO NOT UNCOMMENT)
    }
}