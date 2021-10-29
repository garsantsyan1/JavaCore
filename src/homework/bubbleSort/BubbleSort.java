package homework.bubbleSort;

public class BubbleSort {

    int[] sort(int[] arr) {
        boolean sorted;
        for (int i = arr.length - 1; i > 0; i--) {
            sorted = true;
            for (int j = 0; j < i; j++) {
                int temp = arr[j];
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return arr;
    }
}

