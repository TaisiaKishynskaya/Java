import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TaxiPark {
    protected final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public double calculateTotalCost(int distance, double fuelPrice) {
        double totalCost = 0;
        for (Car car : cars) {
            totalCost += car.calculateCost(distance, fuelPrice);
        }
        return totalCost;
    }

    public void sortCarsByFuelConsumption() {
        cars.sort(Comparator.comparingDouble(Car::getFuelConsumption));
    }

    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            // Припустимо, що в нас є метод getSpeed() для визначення швидкості авто
            int speed = getSpeed();
            if (speed >= minSpeed && speed <= maxSpeed) {
                result.add(car);
            }
        }
        return result;
    }

    // Метод для визначення швидкості авто (приклад)
    private int getSpeed() {
        return (int) (Math.random() * 200);  // Наприклад, повертаємо випадкове значення
    }
}
