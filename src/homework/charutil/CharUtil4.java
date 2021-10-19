package homework.charutil;

public class CharUtil4 {
    public static void main(String[] args) {
        // տպել true եթե տեքստը պարունակում է bob բառը, o-ի տեղը կարող է լինել ցանկացած սիմվոլ հակառակ դեպքում false
        char[] bolola = {'l', 'l', '8', 'b', 'i', 'b'};
        boolean word = false;

        for (int i = 0; i < bolola.length - 2; i++) {
            if (bolola[i] == 'b' && bolola[i + 2] == 'b') {
                word = true;
                break;
            }
        }
        System.out.println(word);

    }
}
