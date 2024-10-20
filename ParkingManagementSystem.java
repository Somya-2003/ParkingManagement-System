
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Vehicle {
    String licensePlate;
    String location;

    public Vehicle(String licensePlate, String location) {
        this.licensePlate = licensePlate;
        this.location = location;
    }
}

public class ParkingManagementSystem {
    private Map<String, Vehicle> vehicles;
    private Scanner scanner;

    public ParkingManagementSystem() {
        this.vehicles = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void parkVehicle() {
        System.out.println("Enter license plate: ");
        String licensePlate = scanner.nextLine();
        System.out.println("Enter location (e.g., A1, B2, etc.): ");
        String location = scanner.nextLine();
        vehicles.put(licensePlate, new Vehicle(licensePlate, location));
        System.out.println("Vehicle parked successfully!");
    }

    public void locateVehicle() {
        System.out.println("Enter license plate: ");
        String licensePlate = scanner.nextLine();
        if (vehicles.containsKey(licensePlate)) {
            Vehicle vehicle = vehicles.get(licensePlate);
            System.out.println("Vehicle located at: " + vehicle.location);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Park Vehicle");
            System.out.println("2. Locate Vehicle");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    parkVehicle();
                    break;
                case 2:
                    locateVehicle();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public static void main(String[] args) {
        ParkingManagementSystem system = new ParkingManagementSystem();
        system.run();
    }
}
