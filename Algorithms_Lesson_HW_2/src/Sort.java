public class Sort {

    public static void bubbleSort(int[] array) {
        boolean finish;
        do {                                                //цикл сортировки
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {   //один проход по массиву
                if (array[i] > array[i + 1]) {              //i < array.length-1 нужен для того, чтобы не получить IndexOutOfBound Exception
                    int temp = array[i];                //обмен нашего тяжелого значения со следующим менее тяжелым соседом
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);
    }

    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {        //цикл сортировки
            int minPosition = i;
            for (int j = i + 1; j < array.length; j++) {    //один проход по массиву
                if (array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];                //за один проход массива может быть не более 1 обмена
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];
        while (leftPosition <= rightPosition) {
            while (array[leftPosition] < pivot) {
                leftPosition++;
            }
            while (array[rightPosition] > pivot) {
                rightPosition--;
            }
            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        }

        if (leftPosition < endPosition) {
            quickSort(array, leftPosition, endPosition);
        }
        if (rightPosition > startPosition) {
            quickSort(array, startPosition, rightPosition);
        }
    }
}

