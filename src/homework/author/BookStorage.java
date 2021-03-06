package homework.author;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size = 0;

    public void add(Book book) {
        if (size == books.length) {
            extend();
        }
        books[size++] = book;
    }

    private void extend() {
        Book[] tmp = new Book[books.length + 10];
        System.arraycopy(books, 0, tmp, 0, books.length);
        books = tmp;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i] + " ");
        }
        System.out.println();
    }


    public void searchBookByTitle(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            } else {
                System.out.println("There isn't book for this title");
            }
        }
    }

    public void searchBooksByAuthor(String email) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().getEmail().equals(email)) {
                System.out.println(books[i]);
            }
        }
    }

    public void countBooksByAuthor(String email) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().getEmail().equals(email)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public Book getByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            books[i - 1] = books[i];
        }
        size--;
    }

    public void deleteByAuthor(String email) {
        boolean delete = true;
        int i = 0;
        while (i < size) {
            if (books[i].getAuthor().getEmail().equals(email)) {
                for (int j = i + 1; j < size; j++) {
                    books[j - 1] = books[j];
                }
                size--;
                delete = false;
            }
            if (delete) {
                i++;
            }
            delete = true;
        }
    }

    public void deleteBook(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                deleteByIndex(i);
            }
        }
    }
}
