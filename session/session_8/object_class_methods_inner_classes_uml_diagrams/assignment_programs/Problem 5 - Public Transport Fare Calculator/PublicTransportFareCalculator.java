abstract class Transport {
    double distance;
    public Transport(double distance) { this.distance = distance; }
    abstract double calculateFare();
    abstract String getType();
}
class Bus extends Transport {
    public Bus(double distance) { super(distance); }
    double calculateFare() { return Math.min(10.0, 2.0 + 0.10 * distance); }
    String getType() { return "BUS"; }
}
class Train extends Transport {
    public Train(double distance) { super(distance); }
    double calculateFare() { return 3.0 + 0.15 * distance; }
    String getType() { return "TRAIN"; }
}
class Metro extends Transport {
    double peakHourFactor;
    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    double calculateFare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    String getType() { return "METRO"; }
}
public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Transport[] transports = {
            new Bus(15),
            new Train(50),
            new Metro(10, 1.5)
        };
        double total = 0;
        for (Transport t : transports) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f\n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
