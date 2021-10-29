package homework.charUtil;

public class CharUtil {

    void printMiddleELem(char[] array) {
        // տպել մեջտեղի երկու սիմվոլները

        System.out.println(array[array.length / 2 - 1] + " " + array[array.length / 2]);
    }

    boolean endsWith(char[] array) {
        // տպել true եթե մասիվը վերջանում է ly-ով, եթե ոչ false

        if (array[array.length - 1] == 'y' && array[array.length - 2] == 'l') {
            return true;
        } else {
            return false;
        }
    }

    char[] trim(char[] text) {
        // text մասիվից ստանալ result մասիվ որը կլինի նույն տեքստը առանց բացատների

        boolean left = true;
        boolean right = true;
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0, j = text.length - 1; i < text.length; i++, j--) {
            if (text[i] != ' ' && left) {
                leftIndex = i;
                left = false;
            }

            if (text[j] != ' ' && right) {
                rightIndex = j;
                right = false;
            }

            if (!left && !right) {
                break;
            }
        }

        char[] result = new char[rightIndex + 1 - leftIndex];

        for (int i = leftIndex, j = 0; i < rightIndex + 1; i++, j++) {
            result[j] = text[i];
        }

        return result;
    }

    int count(char[] array, char c) {
        // հաշվել քանի հատ c-փոփոխականից կա մեր մասիվի մեջ, ու տպել այդ քանակը
        int count = 0;

        for (char symbol : array) {
            if (symbol == c) {
                count++;
            }
        }
        return count;
    }

    boolean includes(char[] array, char symbol) {
        // տպել true եթե տեքստը պարունակում է bob բառը, o-ի տեղը կարող է լինել ցանկացած սիմվոլ հակառակ դեպքում false

        boolean isWord = false;

        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] == symbol && array[i + 2] == symbol) {
                isWord = true;
                break;
            }
        }
        return isWord;
    }

}
