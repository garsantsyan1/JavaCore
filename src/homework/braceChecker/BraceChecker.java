package homework.braceChecker;

public class BraceChecker {
    //սա հենց տեքստն է
    private String text;

    //կլասսի կոնստրուկտորն է, որը պետք է ընդունի String տիպի տեքստ, և վերագրի վերևի տեքստին
    //Որ չկարողանանք BraceChecker-ի օբյեկտը սարքենք առանց text-տալու կոնստրուկտորի միջոցով․
    public BraceChecker(String text) {
        this.text = text;
    }

    //սա հիմնական մեթոդն է, որի մեջ գրելու ենք ամբողջ լոգիկան․ աշխատելու ենք թե stack-ի հետ, թե վերևի text-ի
    public void check() {

        Stack stack = new Stack();
        char c;
        char openQuote;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);

            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        System.err.println("Error: closed " + c + " but didn't open at " + i);
                        break;
                    }
                    openQuote = (char) stack.pop();
                    if (openQuote != '(') {
                        System.err.println("Error: opened " + openQuote + " but close " + c + " at " + i);
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        System.err.println("Error: closed " + c + " but didn't open at " + i);
                        break;
                    }
                    openQuote = (char) stack.pop();
                    if (openQuote != '[') {
                        System.err.println("Error: opened " + openQuote + " but close " + c + " at " + i);
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        System.err.println("Error: closed " + c + " but didn't open at " + i);
                        break;
                    }
                    openQuote = (char) stack.pop();
                    if (openQuote != '{') {
                        System.err.println("Error: opened " + openQuote + " but close " + c + " at " + i);
                    }
                    break;
            }
        }

        if (!stack.isEmpty()) {
            for (int i = 0; i < text.length(); i++) {
                c = text.charAt(i);
                if ((c == '(' || c == '{' || c == '[') && !stack.isEmpty()) {
                    openQuote = (char) stack.pop();
                    System.err.println("Error: opened " + openQuote + " but didn't close at " + i);
                }
            }
        }

    }
}
