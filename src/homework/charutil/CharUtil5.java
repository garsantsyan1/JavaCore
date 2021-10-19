package homework.charutil;

public class CharUtil5 {
    public static void main(String[] args) {
        // text մասիվից ստանալ result մասիվ որը կլինի նույն տեքստը առանց բացատների
        char[] text = {' ', ' ', ' ', 'b', ' ', 'a', 'r', 'e', ' ', 'v', ' ', ' ', ' '};

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

        for (char val : result) {
            System.out.print(val);
        }
    }
}
