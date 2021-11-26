package homework.dynamicArray;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();

        da.add(5);

        int[] numbers = {33, 44, 55};

        da.add(numbers);
        da.add(66, 2);
        da.delete(3);
        da.print();


    }
}
