import java.util.*;

class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    Vehicle(int id, String name, double rent) {
        vehicleId = id;
        modelName = name;
        baseRent = rent;
    }

    double calculateRent() {
        return baseRent;
    }
}

class Car extends Vehicle {
    int seats;

    Car(int id, String name, double rent, int seats) {
        super(id, name, rent);
        this.seats = seats;
    }

    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

class Bike extends Vehicle {
    int engineCapacity;

    Bike(int id, String name, double rent, int cap) {
        super(id, name, rent);
        this.engineCapacity = cap;
    }

    double calculateRent() {
        return baseRent + (engineCapacity * 2);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Vehicle> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);

            if (type == 'C') {
                list.add(new Car(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt()));
            } else {
                list.add(new Bike(sc.nextInt(), sc.next(), sc.nextDouble(), sc.nextInt()));
            }
        }

        for (Vehicle v : list) {
            System.out.println("Vehicle ID: " + v.vehicleId +
                    ", Model: " + v.modelName +
                    ", Total Rent: " + v.calculateRent());
        }
    }
}