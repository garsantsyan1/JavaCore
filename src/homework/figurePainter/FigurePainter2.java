package homework.figurePainter;

public class FigurePainter2 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > i; j--) {
                System.out.print("  ");
            }
            for (int m = 0; i >= m; m++) {
                System.out.print(" *");
            }
            System.out.println(" ");
        }
    }
}
