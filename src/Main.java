import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSum(5, 15);
        checkNumber(10);
        checkNumberBool(10);
        printString("Привет ", 5);
        checkYear(400);
        changeArr();
        pullArr();
        multiplyArr();
        diagonalArr();
        createArr(2, 4);
    }

    //1)//
    public static void printThreeWords() {
        System.out.println("Orange\n" + "Banana\n" + "Apple");
    }

    //2)//
    public static void checkSumSign() {
        int a, b;
        a = 37;
        b = 27;
        int c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3)//
    public static void printColor() {
        int value;
        value = 15;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4)//
    public static void compareNumbers() {
        int a, b;
        a = 37;
        b = 27;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    //5)//
    public static boolean checkSum(int a, int b) {
        boolean result = false;
        int c = a + b;
        if (c > 10 && c <= 20) {
            result = true;
        }
        System.out.println(result);
        return result;
    }

    //6)//
    public static void checkNumber(int a) {
        if (a >= 0) {
            System.out.println("Передано положительное число");
        } else {
            System.out.println("Передано отрицательное число");
        }
    }

    //7)//
    public static boolean checkNumberBool(int a) {
        boolean result = false;
        if (a >= 0) {
            result = true;
        }
        System.out.println(result);
        return result;
    }

    //8)//
    public static void printString(String a, int b) {
        for (int i = 1; i <= b; i++) {
            System.out.print(a);
        }
        System.out.println();
    }

    //9)//
    public static boolean checkYear(int year) {
        boolean result;
        if ((year > 0 && year % 4 == 0) || (year > 0 && year % 400 == 0)) {
            result = true;
            if (year % 100 == 0 && year % 400 != 0) {
                result = false;
            }
        } else {
            result = false;
        }
        System.out.println(result);
        return result;
    }

    //10)//
    public static void changeArr() {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    //11)//
    public static void pullArr() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    //12)//
    public static void multiplyArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //13)//
    public static void diagonalArr() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i] == arr[j]) {
                    arr[i][j] = 1;
                }

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //14)//
    public static void createArr(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}