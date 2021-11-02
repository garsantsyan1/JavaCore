package chapter6;

public class BoxDemo5 {
    public static void main(String[] args) {
        Box mybox1 = new Box(21, 22, 23);
        Box mybox2 = new Box(31, 32,33);
        double vol;

        mybox1.setDim(10, 20, 15);
        mybox2.setDim(3, 6, 9);

        vol = mybox1.volume();
        System.out.println("Объем равен " + vol);

        vol = mybox2.volume();
        System.out.println("Объем равен " + vol);
    }
}
