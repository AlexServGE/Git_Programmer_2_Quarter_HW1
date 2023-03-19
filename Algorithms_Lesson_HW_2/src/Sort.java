public class Sort {

    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;

            for (int i = 0; i < array.length - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;
                }
            }
        } while (!finish);

    }

    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            int minPosition = i;

            int temp;
            for (temp = i + 1; temp < array.length; ++temp) {
                if (array[temp] < array[minPosition]) {
                    minPosition = temp;
                }
            }

            if (i != minPosition) {
                temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }

    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
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
                ++leftPosition;
            }

            while (array[rightPosition] > pivot) {
                --rightPosition;
            }

            if (leftPosition <= rightPosition) {
                if (leftPosition < rightPosition) {
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }

                ++leftPosition;
                --rightPosition;
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


