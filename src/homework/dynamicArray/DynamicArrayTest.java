package homework.dynamicArray;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(4);
        da.add(1);
        da.add(-2);
        da.add(64);
        da.add(6);
        da.add(10);
        da.add(9);
        da.add(8);
        da.add(7);
        da.add(1);
        da.add(909);


        da.print();
        System.out.println(da.getByIndex(11));
    }
}
