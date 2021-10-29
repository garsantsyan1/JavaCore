package homework.bubbleSort;

public class BubbleSortTest {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {5, 3, 7, 87, 15};
        for (int x : bubbleSort.sort(array)) {
            System.out.print(x + " ");
        }

    }
}
