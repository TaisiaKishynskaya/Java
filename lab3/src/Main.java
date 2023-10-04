import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TaxiPark taxiPark = new TaxiPark();

        taxiPark.addCar(new Car("Toyota", "Camry", 2020, 7.5));
        taxiPark.addCar(new Car("Honda", "Civic", 2019, 6.8));
        taxiPark.addCar(new Car("Ford", "Focus", 2021, 8.0));

        // Вводимо параметри подорожі
        int distance = getInputValue(scanner, "Введіть відстань (км): ", Integer.class);
        double fuelPrice = getInputValue(scanner, "Введіть вартість палива (грн/л): ", Double.class);

        // Розраховуємо та виводимо вартість подорожі
        double totalCost = taxiPark.calculateTotalCost(distance, fuelPrice);
        System.out.println("Стоимость поездки: " + totalCost + " грн");

        // Сортуємо авто за росходом палива
        taxiPark.sortCarsByFuelConsumption();

        // Виводимо відсортований список авто
        System.out.println("Автомобілі, відсортовані за росходом палива:");
        for (Car car : taxiPark.cars) {
            System.out.println(car + " - Росход: " + car.getFuelConsumption() + " л/100 км");
        }

        // Шукаємо авто в заданному діапазоні швидкості
        int minSpeed = getInputValue(scanner, "Введіть мінімальну швидкість (км/г): ", Integer.class);
        int maxSpeed = getInputValue(scanner, "Введіть максимальну швидкість (км/г): ", Integer.class);

        List<Car> carsInSpeedRange = taxiPark.findCarsBySpeedRange(minSpeed, maxSpeed);

        // Виводимо
        System.out.println("Автомобілі в заданому діапазоні швидкості:");
        for (Car car : carsInSpeedRange) {
            System.out.println(car);
        }
    }

    private static <T> T getInputValue(Scanner scanner, String message, Class<T> type) {
        T value = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                if (type == Integer.class) {
                    value = type.cast(Integer.parseInt(input));
                } else if (type == Double.class) {
                    value = type.cast(Double.parseDouble(input));
                }

                if (Double.parseDouble(input) >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Помилка: Введіть додатнє число.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Помилка: Введіть коректне числове значення.");
            }
        }

        return value;
    }
}
