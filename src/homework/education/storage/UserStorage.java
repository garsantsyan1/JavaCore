package homework.education.storage;

import homework.education.model.Student;
import homework.education.model.User;

public class UserStorage {
    private User[] users = new User[10];
    private int size = 0;


    public void add(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i] + " ");
        }
        System.out.println();
    }


    public User getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    public boolean checkPassword(String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public String getByType(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i].getType();
            }
        }
        return null;
    }


}
