package homework.arrayUtil;

public class ArrayUtil {

    void even(int[] arr) {
        //Մասիվի բոլոր զույգ էլեմենտները
        for (int val : arr) {
            if (val % 2 == 0) {
                System.out.print(val + ",");
            }
        }
    }

    void odd(int[] arr) {
        //Մասիվի բոլոր կենտ էլեմենտները
        for (int val : arr) {
            if (val % 2 != 0) {
                System.out.print(val + ",");
            }
        }
    }

    int countEven(int[] arr) {
        //Զույգերի քանակը
        int amtEven = 0;
        for (int val : arr) {
            if (val % 2 == 0) {
                amtEven++;
            }
        }
        return amtEven;
    }

    int countOdd(int[] arr) {
        //Կենտերի քանակը
        int amtOdd = 0;
        for (int val : arr) {
            if (val % 2 != 0) {
                amtOdd++;
            }
        }
        return amtOdd;
    }

    int sum(int[] arr) {
        //Մասիվի էլեմենտների գումարը
        int sumArr = 0;
        for (int val : arr) {
            sumArr += val;
        }
        return sumArr;
    }

    double average(int[] arr) {
        //Մասիվի բոլոր թվերի միջին թվաբանականը
        double sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum / arr.length;
    }

    void print(int[] arr) {
        //Տպել մասիվի բոլոր էլեմենտները
        for (int val : arr) {
            System.out.print(val + ",");
        }
        System.out.println();
    }

    int max(int[] arr) {
        //Մասիվի ամենամեծ թիվը
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    int min(int[] arr) {
        //Մասիվի ամենափոքր թիվը
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

}
