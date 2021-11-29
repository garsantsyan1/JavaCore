package homework.education;

public class LessonStorage {
    private Lesson[] lessons = new Lesson[10];
    private int size = 0;

    public void add(Lesson lesson) {
        if (size == lessons.length) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] tmp = new Lesson[lessons.length + 10];
        System.arraycopy(lessons, 0, tmp, 0, lessons.length);
        lessons = tmp;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i] + " ");
        }
        System.out.println();
    }

    Lesson getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(name)) {
                return lessons[i];
            }
        }
        return null;
    }

    public boolean lessonsIsEmpty() {
        return size == 0;
    }

    private void deleteByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            lessons[i - 1] = lessons[i];
        }
        size--;
    }

    public void deleteLessonByName(String name) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(name)) {
                deleteByIndex(i);
                break;
            }
        }
    }
}
