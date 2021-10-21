package homework.bubblesort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 3, 1, 5, 8, 44, 63, 21};
        int temp;
        boolean sorted;

        for (int i = arr.length - 1; i > 0; i--) {
            sorted = true;
            for (int j = 0; j < i; j++) {
                temp = arr[j];
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


        for (int val : arr) {
            System.out.print(val + " ");
        }


    }
}

