package homework.author;

import java.util.Scanner;

public class AuthorTest {

    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();
    static Scanner scanner = new Scanner(System.in);

    private static final String EXIT = "0";
    private static final String ADD_AUTHOR = "1";
    private static final String SEARCH_AUTHORS = "2";
    private static final String SEARCH_AUTHORS_BY_AGE = "3";
    private static final String PRINT_AUTHORS = "4";
    private static final String ADD_BOOK = "5";
    private static final String PRINT_BOOK = "6";
    private static final String SEARCH_BOOKS_BY_TITLE = "7";

    public static void main(String[] args) {
        // authorStorage.add(new Author("Poxos", "Poxosyan", "poxos22@mail.com", 22, "male"));
        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case SEARCH_AUTHORS:
                    searchByName();
                    break;
                case SEARCH_AUTHORS_BY_AGE:
                    searchByAge();
                    break;
                case PRINT_AUTHORS:
                    authorStorage.print();
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_BOOK:
                    bookStorage.print();
                    break;
                case SEARCH_BOOKS_BY_TITLE:
                    searchBookByTitle();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }


    }

    private static void searchBookByTitle() {
        System.out.println("please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByTitle(keyword);
    }

    private static void addBook() {
        System.out.println("please input book title");
        String bookTitle = scanner.nextLine();
        System.out.println("please input book description");
        String bookDescription = scanner.nextLine();
        System.out.println("please input book price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("please input book count");
        int count = Integer.parseInt(scanner.nextLine());

        Book book = new Book(bookTitle, bookDescription, price, count);
        bookStorage.add(book);
    }

    private static void searchByAge() {
        System.out.println("please input min age");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.println("please input max age");
        int maxAge = Integer.parseInt(scanner.nextLine());
        authorStorage.searchByAge(minAge, maxAge);
    }

    private static void printCommands() {
        System.out.println("please input" + EXIT + " for EXiT");
        System.out.println("please input " + ADD_AUTHOR + " for add author");
        System.out.println("please input " + SEARCH_AUTHORS + " for search author by name");
        System.out.println("please input " + SEARCH_AUTHORS_BY_AGE + " for search author by age");
        System.out.println("please input " + PRINT_AUTHORS + " for print authors");
        System.out.println("please input " + ADD_BOOK + " for add book");
        System.out.println("please input " + PRINT_BOOK + " for print books");
        System.out.println("please input " + SEARCH_BOOKS_BY_TITLE + " for search book by title");

    }

    private static void searchByName() {
        System.out.println("please input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchByName(keyword);

    }

    private static void addAuthor() {
        System.out.println("Write author name ");
        String name = scanner.nextLine();
        System.out.println("Write author surname ");
        String surname = scanner.nextLine();
        System.out.println("Write author email ");
        String email = scanner.nextLine();
        System.out.println("Write author age ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Write author gender ");
        String gender = scanner.nextLine();

        Author author = new Author(name, surname, email, age, gender);
        authorStorage.add(author);
    }
}
