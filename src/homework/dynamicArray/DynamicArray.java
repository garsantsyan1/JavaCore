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

    public void add(int[] numbers) {
        for (int number : numbers) {
            add(number);
        }
    }

    public void add(int value, int index) {
        if (index < 0 || index > size) {
            System.err.println("invalid index: " + index);
        } else {
            if (size == array.length) {
                extend();
            }
            for (int i = size; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = value;
            size++;
        }
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
            System.err.println("Array doesn't include such element");
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

    public void delete(int index) {
        if (index < 0 || index > size) {
            System.err.println("invalid index: " + index);
        } else {
            for (int i = index + 1; i < size; i++) {
                array[i - 1] = array[i];
            }
            size--;
        }
    }

    public void set(int value, int index) {
        if (index < 0 || index > size) {
            System.err.println("invalid index: " + index);
        } else {
            array[index] = value;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean isExists(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
