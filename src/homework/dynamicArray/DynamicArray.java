package homework.dynamicArray;

public class DynamicArray {

    private int[] array = new int[10];

    private int size = 0;

    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }


    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }


    public int getByIndex(int index) {
        if (size > index && index >= 0) {
            return array[index];
        } else {
            System.out.println("Array doesn't include such element");
            return -1;
        }
    }

    // տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
