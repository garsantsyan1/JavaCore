package homework.author;

import java.util.Scanner;

public class AuthorTest {
    public static void main(String[] args) {
        AuthorStorage authorStorage = new AuthorStorage();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many authors do we have ?");
        int countOfAuthors = scanner.nextInt();

        String name;
        String surname;
        String email;
        int age;
        String gender;

        for (int i = 1; i <= countOfAuthors; i++) {
            System.out.println("Write author name " + i);
            name = scanner.next();
            System.out.println("Write author surname " + i);
            surname = scanner.next();
            System.out.println("Write author email " + i);
            email = scanner.next();
            System.out.println("Write author age " + i);
            age = scanner.nextInt();
            System.out.println("Write author gender " + i);
            gender = scanner.next();

            Author author = new Author(name, surname, email, age, gender);
            authorStorage.add(author);
        }


        authorStorage.print();

    }
}
