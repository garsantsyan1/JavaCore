package chapter6;

public class BoxDemo4 {
    public static void main(String[] args) {
        Box mybox1 = new Box(14, 41, 55);
        Box mybox2 = new Box(87, 79, 75);
        double vol;

        mybox1.width = 10;
        mybox1.height = 20;
        mybox1.depth = 15;

        mybox2.width = 3;
        mybox2.height = 6;
        mybox2.depth = 9;

        vol = mybox1.volume();
        System.out.println("Объем равен " + vol);

        vol = mybox2.volume();
        System.out.println("Объем равен " + vol);

    }
}
