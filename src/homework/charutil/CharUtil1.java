package homework.charutil;

public class CharUtil1 {
    public static void main(String[] args) {
        // հաշվել քանի հատ c-փոփոխականից կա մեր մասիվի մեջ, ու տպել այդ քանակը
        char[] bolola = {'b', 'o', 'l', 'o', 'l', 'a'};
        char c = 'o';
        int count = 0;

        for (char symbol : bolola) {
            if (symbol == c) {
                count++;
            }
        }
        System.out.println(count);
    }


}
