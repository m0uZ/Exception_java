// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, 
// которое пользователь может увидеть - RuntimeException, т.е. ваше.

import java.util.Arrays;

public class task2 {
    public static int[] elementDivideArray(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Длинны массивов не равны!");
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            if (array2[i] == 0) {
                throw new RuntimeException("Делить на 0 нельзя!");
            }
            result[i] = array1[i] / array2[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {12,32,44,45};
        int[] arr1 = {2,43,43,65};
    
        int[] res = elementDivideArray(arr, arr1);
        System.out.println(Arrays.toString(res));
    }
}
