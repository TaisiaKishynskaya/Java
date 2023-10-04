class Car {
    private final String make;
    private final String model;
    private final int year;
    private final double fuelConsumption;  // Росход палива (л/100 км)

    public Car(String make, String model, int year, double fuelConsumption) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
    }

    public double calculateCost(int distance, double fuelPrice) {
        return (distance / 100.0) * fuelConsumption * fuelPrice;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + ")";
    }
}