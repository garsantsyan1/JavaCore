package homework;

public class FigurePainter4 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println(" ");
            for (int m = 0; i >= m; m++) {
                System.out.print("  ");
            }
        }
    }
}
