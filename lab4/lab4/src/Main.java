import java.util.LinkedList;
import java.util.Scanner;

class Stack<T> {
    private final LinkedList<T> stack = new LinkedList<>();

    // Додавання елементу до стеку
    public void push(T item) {
        stack.addLast(item);
    }

    // Видалення та повернення верхнього елементу стеку
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек порожній");
        }
        return stack.removeLast();
    }

    // Перевірка, чи стек порожній
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть послідовність символів: ");
        String input = scanner.nextLine(); // Отримуємо введення користувача

        // Додаємо символи до стеку
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        System.out.print("Результат у зворотному порядку: ");

        // Виводимо символи у зворотному порядку
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
