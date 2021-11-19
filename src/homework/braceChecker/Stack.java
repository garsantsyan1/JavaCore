package homework.braceChecker;

public class Stack {

    private int[] array;
    private int index;

    public Stack() {
        array = new int[10];
        index = -1;
    }

    Stack(int length) {
        array = new int[length];
        index = -1;
    }

    public void push(int value) {
        if (index == array.length - 1) {
            System.out.println("stack-ը վերջացավ");
        } else {
            array[++index] = value;
        }
    }

    public int pop() {
        if (index < 0) {
            System.out.println("stack-ը դատարկ է");
            return 0;
        } else {
            return array[index--];
        }
    }

    public boolean isEmpty() {
        return index == -1;
    }


}
