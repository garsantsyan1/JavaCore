package homework.education;

public class StudentStorage {
    private Student[] students = new Student[10];
    private int size = 0;

    public void add(Student student) {
        if (size == students.length) {
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] tmp = new Student[students.length + 10];
        System.arraycopy(students, 0, tmp, 0, students.length);
        students = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i] + " ");
        }
        System.out.println();
    }

    public Student getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                return students[i];
            }
        }
        return null;
    }

    public void printStudentsByLesson(String name) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < students[i].getLessons().length; j++) {
                if (students[i].getLessons()[j].getName().equals(name)) {
                    System.out.println(students[i] + " ");
                }
            }
        }
        System.out.println();
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            students[i - 1] = students[i];
        }
        size--;
    }

    public void deleteStudentByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (students[i].getEmail().equals(email)) {
                deleteByIndex(i);
                break;
            }
        }
    }
}

