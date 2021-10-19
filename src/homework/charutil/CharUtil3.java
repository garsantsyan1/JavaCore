package homework.charutil;

public class CharUtil3 {
    public static void main(String[] args) {
        // տպել true եթե մասիվը վերջանում է ly-ով, եթե ոչ false
        char[] bolola = {'b', 'o', 'l', 'o', 'l', 'a'};

        if (bolola[bolola.length - 1] == 'y' && bolola[bolola.length - 2] == 'l') {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
