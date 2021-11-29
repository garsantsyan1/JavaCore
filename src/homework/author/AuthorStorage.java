package homework.author;

public class AuthorStorage {
    private Author[] authors = new Author[10];
    private int size = 0;

    public void add(Author author) {
        if (size == authors.length) {
            extend();
        }
        authors[size++] = author;
    }

    private void extend() {
        Author[] tmp = new Author[authors.length + 10];
        System.arraycopy(authors, 0, tmp, 0, authors.length);
        authors = tmp;
    }


    public Author getByIndex(int index) {
        if (index > size || 0 > index) {
            System.err.println("invalid index: " + index);
        }
        return authors[index];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(authors[i] + " ");
        }
        System.out.println();
    }


    public void searchByName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getName().contains(keyword) || authors[i].getSurname().contains(keyword)) {
                System.out.println(authors[i]);
            }
        }
    }

    public void searchByAge(int minAge, int maxAge) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getAge() >= minAge && authors[i].getAge() <= maxAge) {
                System.out.println(authors[i]);
            }
        }

    }

    public Author getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getEmail().equals(email)) {
                return authors[i];
            }
        }
        return null;
    }

    public void changeAuthor(String email, String name, String surname, String gender, int age) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getEmail().equals(email)) {
                if (!name.equals("")) {
                    authors[i].setName(name);
                }
                if (!surname.equals("")) {
                    authors[i].setSurname(surname);
                }
                if (!gender.equals("")) {
                    authors[i].setGender(gender);
                }
                if (age != 0) {
                    authors[i].setAge(age);
                }
            }
        }
    }


    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            authors[i - 1] = authors[i];
        }
        size--;
    }

    public void deleteAuthor(String email) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getEmail().equals(email)) {
                deleteByIndex(i);
            }
        }
    }

}
