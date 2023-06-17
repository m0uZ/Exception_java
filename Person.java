import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки
// дата_рождения - строка формата dd.mm.yyyy
// номер_телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, 
// обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, 
// нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. 
// Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, 
// в него в одну строку должны записаться полученные данные, вида<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
// пользователь должен увидеть стектрейс ошибки.

// Первым делом нужно создать класс, который будет принимать данные от пользователя и записывать их в файл. 
// Пусть этот класс будет называться Person и будет иметь следующие поля:

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    // Теперь нужно создать метод, который будет принимать данные от пользователя и
    // проверять их на правильность.

    public void collectData(String input) throws Exception {
        String[] inputs = input.split(" ");

        if (inputs.length != 6) {
            throw new Exception("Неверное количество параметров");
        }

        String lastName = inputs[0];
        String firstName = inputs[1];
        String middleName = inputs[2];
        String birthDate = inputs[3];
        long phoneNumber = Long.parseLong(inputs[4]);
        char gender = inputs[5].charAt(0);

        if (gender != 'f' && gender != 'm') {
            throw new Exception("Неверный пол");
        }

        String[] parts = birthDate.split("\\.");
        if (parts.length != 3) {
            throw new Exception("Неверный формат даты");
        }

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        LocalDate date = LocalDate.of(year, month, day);
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    // Метод collectData() принимает строку input, разделяет её на части по пробелу,
    // проверяет количество элементов в массиве inputs. Если элементов не 6,
    // бросается исключение с сообщением "Неверное количество параметров".
    // Затем поля класса заполняются значениями из массива inputs.
    // Далее проверяется пол. Если он не равен 'f' или 'm',
    // бросается исключение с сообщением "Неверный пол".
    // Проверяется формат даты рождения.
    // Если формат не совпадает с ожидаемым, бросается исключение с сообщением
    // "Неверный формат даты".
    // Затем дата преобразуется в формат dd.MM.yyyy и сохраняется в поле birthDate.

    // Теперь нужно создать метод, который будет записывать данные в файл.
    

    public void saveData() throws Exception {
        File file = new File(this.lastName + ".txt");
        FileWriter writer = new FileWriter(file, true);
        writer.write(this.lastName + this.firstName + this.middleName + this.birthDate + " " + this.phoneNumber
                + this.gender + "\n");
        writer.close();
    }
    // Метод saveData() создает объект класса File с именем, равным фамилии,
    // переданной в поле lastName. Затем создается объект FileWriter, который будет
    // записывать данные в файл.
    // Данные записываются в формате <Фамилия><Имя><Отчество><дата рождения> <номер
    // телефона><пол>.
    // После записи данных файл закрывается.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
                String input = scanner.nextLine();
                Person person = new Person();
                person.collectData(input);
                person.saveData();
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

