package homework;

public class FigurePainter3 {
    public static void main(String[] args) {
        for (int i = 4; i > 0; i--) {
            for (int j = 0; i > j; j++) {
                System.out.print("* ");
            }
            System.out.println(" ");
        }
    }
}
