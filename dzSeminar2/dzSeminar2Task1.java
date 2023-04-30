package dzSeminar2;
// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class dzSeminar2Task1 {
    public static float FloatInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        while (!scanner.hasNextFloat()) {
            System.out.print("Некорректный ввод. Попробуйте еще: ");
            scanner.next();
        }
        float input = scanner.nextFloat();
        scanner.close();
        return input;
    }

    public static void main(String[] args) {
        float userInput = dzSeminar2Task1.FloatInput();
        System.out.println("Введенное пользователем число: " + userInput);
    }
}
