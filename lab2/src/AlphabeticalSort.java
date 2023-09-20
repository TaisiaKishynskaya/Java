import java.util.Arrays;

public class AlphabeticalSort {
    public static void main(String[] args) {
        String inputString = "hello world";

        String sortedString = sortStringAlphabetically(inputString);

        System.out.println("Initial string: " + inputString);
        System.out.println("Sorted string: " + sortedString);
    }

    public static String sortStringAlphabetically(String input) {
        char[] charArray = input.toCharArray();  // Преобразуем строку в массив символов

        Arrays.sort(charArray);  // Сортируем массив символов

        return new String(charArray);  // Возвращаем новую строку из отсортированных символов
    }
}
