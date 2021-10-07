package homework;

public class FigurePainter2 {
    public static void main(String[] args) {
        for (int i = 7; i > 0; i = i - 2) {
            for (int j = 1; i > j; j++) {
                System.out.print(" ");
            }
            for (int m = 7; i <= m; m = m - 2) {
                System.out.print(" *");
            }
            System.out.println(" ");
        }
    }
}
