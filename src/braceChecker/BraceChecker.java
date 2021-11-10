package braceChecker;

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
        char openQuote = ' ';
        Stack stack = new Stack();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    openQuote = (char) stack.pop();
                    break;
            }


            if (openQuote == '(' && c != ')') {
                System.err.println("Error: opened " + openQuote + " but closed " + c + " at " + i);
            } else if (openQuote == '{' && c != '}') {
                System.err.println("Error: opened " + openQuote + " but closed " + c + " at " + i);
            } else if (openQuote == '[' && c != ']') {
                System.err.println("Error: opened " + openQuote + " but closed " + c + " at " + i);
            }
            openQuote = ' ';
        }

    }

}

