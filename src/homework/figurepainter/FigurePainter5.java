package homework.figurepainter;

public class FigurePainter5 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > i; j--) {
                System.out.print(" ");

            }
            for (int m = 0; m <= i; m++) {
                System.out.print(" *");
            }

            System.out.println(" ");


        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int m = 3; m > i; m--) {
                System.out.print(" *");
            }

            System.out.println(" ");
        }

    }
}
