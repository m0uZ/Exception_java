// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, 
// каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. 
// Если длины массивов не равны, необходимо как-то оповестить пользователя.

import java.util.Arrays;

public class task1 {
    public static int[] elementDifferenceArray(int[] array1, int[] array2){
        if(array1.length != array2.length){
            System.out.println("Массивы не равны!");
            return null;
        }
        int[] result = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {12,32,44};
        int[] arr1 = {2,43,55,65};
    
        int[] res = elementDifferenceArray(arr, arr1);
        System.out.println(Arrays.toString(res));
    }
}
