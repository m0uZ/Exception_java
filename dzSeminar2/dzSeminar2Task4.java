// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

package dzSeminar2;

import java.util.Scanner;

public class dzSeminar2Task4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput = scanner.nextLine();
            if(userInput.isEmpty()) {
                throw new RuntimeException("пустые строки вводить нельзя");
            }
            System.out.println(userInput);
        }
    }

}
