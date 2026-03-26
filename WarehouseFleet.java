abstract class Robot {
    private String batteryId;
    protected double chargeLevel;

    public Robot(String batteryId, double chargeLevel) {
        this.batteryId = batteryId;
        this.chargeLevel = chargeLevel;
    }

    public String getBatteryId() {
        return batteryId;
    }

    public void reportStatus() {
        System.out.println("Charge: " + chargeLevel + "%");
    }

    public abstract void performTask();
}

class DroneRobot extends Robot {
    public DroneRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    public void performTask() {
        if (chargeLevel < 15) {
            System.out.println("Low battery!");
        } else {
            chargeLevel -= 15;
            reportStatus();
        }
    }
}

class GroundRobot extends Robot {
    public GroundRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    public void performTask() {
        if (chargeLevel < 5) {
            System.out.println("Low battery!");
        } else {
            chargeLevel -= 5;
            reportStatus();
        }
    }
}

public class WarehouseFleet {
    public static void main(String[] args) {

        Robot[] fleet = {
            new DroneRobot("D-1", 20.0),
            new GroundRobot("G-5", 10.0),
            new DroneRobot("D-2", 10.0)
        };

        for (Robot r : fleet) {
            r.performTask();
        }
    }
}