package homework.author;

public class AuthorStorage {
    private Author[] array = new Author[10];
    private int size = 0;

    void add(Author author) {
        if (size == array.length) {
            extend();
        }
        array[size++] = author;
    }

    void extend() {
        Author[] newArray = new Author[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }


    Author getByIndex(int index) {
        if (index > size || 0 > index) {
            System.err.println("invalid index: " + index);
        }
        return array[index];
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }


}
