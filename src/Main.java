

public class Main {
    public static int arrayIn(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException() {
            super("Массив должен быть размерностью 4 на 4");
        }
    }

    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(int i, int j) {
            super("Ошибка в ячейке (" + i + ", " + j + ")");
        }
    }


    public static void main(String[] args) {
        String[][] array1 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "3"}, {"13", "14", "12", "11"}};
        int result = 0;
        try {
            result = arrayIn(array1);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Сумма элементов массива равна " + result);
        }
    }
}

