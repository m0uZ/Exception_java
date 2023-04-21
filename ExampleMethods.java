public class ExampleMethods {

    // Метод, который вызывает NullPointerException
    public void methodWithNull() {
        String str = null;
        int length = str.length();
    }

    // Метод, который вызывает ArrayIndexOutOfBoundsException
    public void methodWithArray() {
        int[] arr = {1, 2, 3};
        int num = arr[5];
    }

    // Метод, который вызывает ArithmeticException
    public void methodWithMath() {
        int x = 5;
        int y = 0;
        int result = x / y;
    }

}