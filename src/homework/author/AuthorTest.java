package homework.author;

import java.util.Scanner;

public class AuthorTest {

    static Scanner scanner = new Scanner(System.in);
    static AuthorStorage authorStorage = new AuthorStorage();
    static BookStorage bookStorage = new BookStorage();


    private static final String EXIT = "0";
    private static final String ADD_AUTHOR = "1";
    private static final String ADD_BOOK = "2";
    private static final String SEARCH_AUTHORS = "3";
    private static final String SEARCH_AUTHORS_BY_AGE = "4";
    private static final String SEARCH_BOOKS_BY_TITLE = "5";
    private static final String SEARCH_BOOKS_BY_AUTHOR = "6";
    private static final String COUNT_BOOKS_BY_AUTHOR = "7";
    private static final String CHANGE_AUTHOR = "8";
    private static final String CHANGE_BOOK_AUTHOR = "9";
    private static final String PRINT_AUTHORS = "10";
    private static final String PRINT_BOOK = "11";
    private static final String DELETE_BY_AUTHOR = "12";
    private static final String DELETE_AUTHOR = "13";
    private static final String DELETE_BOOK = "14";

    public static void main(String[] args) {
        Author poxos = new Author("Poxos", "Poxosyan", "poxos@mail.com", 22, "male");
        Author armen = new Author("Armen", "Manukyan", "arm@mail.com", 45, "male");
        Author davit = new Author("Davit", "Hakobyan", "dav@mail.com", 28, "male");
        authorStorage.add(poxos);
        authorStorage.add(armen);
        authorStorage.add(davit);
        bookStorage.add(new Book("Poxosi patmvacqner", "sadasd", 55, 2, poxos));
        bookStorage.add(new Book("Poxosi girq", "sadasd", 78, 2, poxos));
        bookStorage.add(new Book("Poxosi girq2", "sadasd", 14, 2, poxos));
        bookStorage.add(new Book("Armeni girq", "sadasd", 45, 7, armen));
        bookStorage.add(new Book("Daviti girq", "sadasd", 108, 9, davit));

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
                case SEARCH_BOOKS_BY_AUTHOR:
                    searchBookByAuthor();
                    break;
                case COUNT_BOOKS_BY_AUTHOR:
                    countBooksByAuthor();
                    break;
                case CHANGE_AUTHOR:
                    changeAuthor();
                    break;
                case CHANGE_BOOK_AUTHOR:
                    changeBookAuthor();
                    break;
                case DELETE_BY_AUTHOR:
                    deleteByAuthor();
                    break;
                case DELETE_AUTHOR:
                    deleteAuthor();
                    break;
                case DELETE_BOOK:
                    deleteBook();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }


    }

    private static void deleteBook() {
        System.out.println("please input book title");
        String title = scanner.nextLine();
        if (bookStorage.getByTitle(title) == null) {
            System.out.println("\u001B[31m" + "There isn't book by that title");
        } else {
            bookStorage.deleteBook(title);
            System.out.println("\u001B[33m" + "The book by that title is deleted successfully");
        }

    }

    private static void deleteAuthor() {
        System.out.println("please input email");
        String email = scanner.nextLine();
        if (authorStorage.getByEmail(email) == null) {
            System.out.println("\u001B[31m" + "Sorry that email doesn't exist");
        } else {
            authorStorage.deleteAuthor(email);
            System.out.println("\u001B[33m" + "Author deleted successfully");
        }

    }

    private static void deleteByAuthor() {
        System.out.println("please input email");
        String email = scanner.nextLine();
        if (authorStorage.getByEmail(email) == null) {
            System.out.println("\u001B[31m" + "Sorry that email doesn't exist");
        } else {
            bookStorage.deleteByAuthor(email);
            System.out.println("\u001B[33m" + "This author's books is deleted successfully");
        }

    }

    private static void changeBookAuthor() {
        System.out.println("please input book title");
        String title = scanner.nextLine();
        Book book = bookStorage.getByTitle(title);
        if (book != null) {
            System.out.println("please input email");
            String email = scanner.nextLine();
            if (authorStorage.getByEmail(email) != null) {
                book.setAuthor(authorStorage.getByEmail(email));
            } else {
                System.out.println("invalid email!");
                addAuthor();
                System.out.println("please input email for changing book author");
                email = scanner.nextLine();
                book.setAuthor(authorStorage.getByEmail(email));
            }
        } else {
            System.out.println("There isn't book by that title");
        }

    }

    private static void changeAuthor() {
        System.out.println("please input email for changing author date");
        String email = scanner.nextLine();
        System.out.println("please input author name for changing");
        String name = scanner.nextLine();
        System.out.println("please input author surname for changing");
        String surname = scanner.nextLine();
        System.out.println("please input author gender for changing");
        String gender = scanner.nextLine();
        System.out.println("please input author age for changing");
        String strAge = scanner.nextLine();
        int age;
        if (strAge.equals("")) {
            age = 0;
        } else {
            age = Integer.parseInt(strAge);
        }
        authorStorage.changeAuthor(email, name, surname, gender, age);

    }

    private static void countBooksByAuthor() {
        System.out.println("please input email for getting count books by author ");
        String email = scanner.nextLine();
        bookStorage.countBooksByAuthor(email);
    }

    private static void searchBookByAuthor() {
        System.out.println("please input email for searching author");
        String email = scanner.nextLine();
        bookStorage.searchBookByAuthor(email);
    }

    private static void searchBookByTitle() {
        System.out.println("please input keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchBookByTitle(keyword);
    }

    private static void addBook() {

        System.out.println("please choose author's email");
        System.out.println("--------");
        System.out.println();
        System.out.println("--------");
        String email = scanner.nextLine();
        Author author = authorStorage.getByEmail(email);
        if (author != null) {
            System.out.println("please input book title");
            String bookTitle = scanner.nextLine();
            System.out.println("please input book description");
            String bookDescription = scanner.nextLine();
            System.out.println("please input book price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("please input book count");
            int count = Integer.parseInt(scanner.nextLine());

            Book book = new Book(bookTitle, bookDescription, price, count, author);
            bookStorage.add(book);
        } else {
            System.out.println("invalid email! please try again");
            addBook();
        }


    }


    private static void searchByAge() {
        System.out.println("please input min age");
        int minAge = Integer.parseInt(scanner.nextLine());
        System.out.println("please input max age");
        int maxAge = Integer.parseInt(scanner.nextLine());
        authorStorage.searchByAge(minAge, maxAge);
    }

    private static void printCommands() {
        System.out.println("\u001B[34m" + "please input " + EXIT + " for EXiT");
        System.out.println("please input " + ADD_AUTHOR + " for add author");
        System.out.println("please input " + ADD_BOOK + " for add book");
        System.out.println("please input " + SEARCH_AUTHORS + " for search author by name");
        System.out.println("please input " + SEARCH_AUTHORS_BY_AGE + " for search author by age");
        System.out.println("please input " + SEARCH_BOOKS_BY_TITLE + " for search book by title");
        System.out.println("please input " + SEARCH_BOOKS_BY_AUTHOR + " for search book by author");
        System.out.println("please input " + COUNT_BOOKS_BY_AUTHOR + " for getting count books by author");
        System.out.println("please input " + CHANGE_AUTHOR + " for changing author");
        System.out.println("please input " + CHANGE_BOOK_AUTHOR + " for changing book author");
        System.out.println("please input " + PRINT_AUTHORS + " for print authors");
        System.out.println("please input " + PRINT_BOOK + " for print books");
        System.out.println("please input " + DELETE_BY_AUTHOR + " for delete books");
        System.out.println("please input " + DELETE_AUTHOR + " for delete author");
        System.out.println("please input " + DELETE_BOOK + " for delete book by title");
    }

    private static void searchByName() {
        System.out.println("please input keyword");
        String keyword = scanner.nextLine();
        authorStorage.searchByName(keyword);

    }

    private static void addAuthor() {
        System.out.println("please input author name ");
        String name = scanner.nextLine();
        System.out.println("please input author surname ");
        String surname = scanner.nextLine();
        System.out.println("please input author email ");
        String email = scanner.nextLine();
        System.out.println("please input author gender ");
        String gender = scanner.nextLine();
        System.out.println("please input author age ");
        int age = Integer.parseInt(scanner.nextLine());


        Author author = new Author(name, surname, email, age, gender);
        if (authorStorage.getByEmail(author.getEmail()) != null) {
            System.out.println("invalid email. Author with this emil already exists");
        } else {
            authorStorage.add(author);
            System.out.println("Thank you, author was added");
        }
    }
}
