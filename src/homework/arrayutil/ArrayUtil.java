package homework.arrayutil;

public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = {5, 17, 18, 3, 2, 24, 10, 9, 7, 1};

        //Տպել մասիվի բոլոր էլեմենտները
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        //Մասիվի ամենամեծ թիվը
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Max = " + max);

        //Մասիվի ամենափոքր թիվը
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Min = " + min);

        //Մասիվի բոլոր զույգ էլեմենտները
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println();

        //Մասիվի բոլոր կենտ էլեմենտները
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.println();

        //Զույգերի քանակը
        int amtEven = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                amtEven++;
            }
        }
        System.out.println("Amount even - " + amtEven);

        //Կենտերի քանակը
        int amtOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                amtOdd++;
            }
        }
        System.out.println("Amount odd - " + amtOdd);

        //Մասիվի բոլոր թվերի միջին թվաբանականը
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Average = " + sum / arr.length);

        //Մասիվի էլեմենտների գումարը
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
        }
        System.out.println("Sum = " + sumArr);

    }

}
