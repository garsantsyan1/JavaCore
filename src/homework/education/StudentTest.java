package homework.education;

import java.util.Scanner;

public class StudentTest {

    static Scanner scanner = new Scanner(System.in);
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();

    private static final String EXIT = "0";
    private static final String ADD_LESSON = "1";
    private static final String ADD_STUDENT = "2";
    private static final String PRINT_STUDENTS = "3";
    private static final String PRINT_STUDENTS_BY_LESSON = "4";
    private static final String PRINT_LESSONS = "5";
    private static final String DELETE_LESSON_BY_NAME = "6";
    private static final String DELETE_STUDENT_BY_EMAIL = "7";


    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        }
    }

    private static void deleteStudentByEmail() {
        System.out.println("please input email for delete student by email");
        String email = scanner.nextLine();
        if (studentStorage.getByEmail(email) != null) {
            studentStorage.deleteStudentByEmail(email);
            System.out.println("student successfully deleted");
        } else {
            System.err.println("There isn't student by this email");
        }
    }

    private static void deleteLessonByName() {
        System.out.println("please input lesson name for delete lesson by name");
        String name = scanner.nextLine();
        if (lessonStorage.getByName(name) != null) {
            lessonStorage.deleteLessonByName(name);
            System.out.println("lesson successfully deleted");
        } else {
            System.err.println("lesson doesn't exist");
        }

    }

    private static void printStudentsByLesson() {
        System.out.println("please input lesson name");
        String name = scanner.nextLine();
        if (lessonStorage.getByName(name) != null) {
            studentStorage.printStudentsByLesson(name);
        } else {
            System.out.println("lesson doesn't exist, add lesson");
            addLesson();
        }

    }

    private static void addStudent() {

        System.out.println("Please input name, surname, age, email, phone, lesson(name)");
        String studentDataStr = scanner.nextLine();
        String[] studentData = studentDataStr.split(" ");

        if (!lessonStorage.lessonsIsEmpty()) {
            if (studentData.length == 6) {
                if (studentStorage.getByEmail(studentData[3]) == null) {
                    if (lessonStorage.getByName(studentData[5]) != null) {
                        Lesson lesson = lessonStorage.getByName(studentData[5]);
                        int age = Integer.parseInt(studentData[2]);
                        Student student = new Student(studentData[0], studentData[1], age, studentData[3], studentData[4],
                                lesson);
                        studentStorage.add(student);
                    } else {
                        System.out.println("lesson by this name doesn't exist, add lesson");
                        addLesson();
                        addStudent();
                    }
                } else {
                    System.out.println("The student already exist by this email");
                    addStudent();
                }
            } else {
                System.err.println("Invalid Date");
            }
        } else {
            System.out.println("lesson doesn't exist, add lesson");
            addLesson();
        }


    }

    private static void addLesson() {
        System.out.println("Please input name, duration, lecturerName, price");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(" ");

        if (lessonData.length == 4) {
            if (lessonStorage.getByName(lessonData[0]) == null) {
                Lesson lesson = new Lesson(lessonData[0], lessonData[1], lessonData[2], Integer.parseInt(lessonData[3]));
                lessonStorage.add(lesson);
            } else {
                System.out.println("lesson by this name already exist");
            }
        } else {
            System.err.println("Invalid Date");
        }

    }

    private static void printCommands() {
        System.out.println("please input " + EXIT + " for EXIT");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student ");
        System.out.println("please input " + PRINT_STUDENTS + " for print students");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lessons ");
        System.out.println("please input " + DELETE_LESSON_BY_NAME + " for delete lesson by name");
        System.out.println("please input " + DELETE_STUDENT_BY_EMAIL + " for delete student by email");
    }

}
