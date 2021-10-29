package homework.figurePainter;

import java.sql.SQLOutput;

public class FigurePainter {

    void firstFigure(int size, char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; i > j; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println(symbol);
        }

        System.out.println();
    }

    void secondFigure(int size, char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                System.out.print("  ");
            }
            for (int m = 0; i >= m; m++) {
                System.out.print(" " + symbol);
            }
            System.out.println(" ");
        }

        System.out.println();
    }

    void thirdFigure(int size, char symbol) {
        for (int i = size; i > 0; i--) {
            for (int j = 0; i > j; j++) {
                System.out.print(symbol + " ");
            }
            System.out.println(" ");
        }

        System.out.println();
    }

    void fourthFigure(int size, char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = size; j > i; j--) {
                System.out.print(symbol + " ");
            }
            System.out.println(" ");
            for (int m = 0; i >= m; m++) {
                System.out.print("  ");
            }
        }

        System.out.println();
    }

    void fifthFigure(int size, char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                System.out.print(" ");

            }
            for (int m = 0; m <= i; m++) {
                System.out.print(" " + symbol);
            }

            System.out.println(" ");


        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int m = size - 1; m > i; m--) {
                System.out.print(" " + symbol);
            }

            System.out.println(" ");
        }

        System.out.println();
    }

}
