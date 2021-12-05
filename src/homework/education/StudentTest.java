package homework.education;


import homework.education.model.Lesson;
import homework.education.model.Student;
import homework.education.storage.LessonStorage;
import homework.education.storage.StudentStorage;
import homework.education.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class StudentTest implements StudentBookCommands {

    static Scanner scanner = new Scanner(System.in);
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();

    public static void main(String[] args) throws ParseException {
        boolean isRun = true;
        while (isRun) {
            StudentBookCommands.printCommands();
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

    private static void addStudent() throws ParseException {

        System.out.println("Please input name, surname, age, email, phone, date, lessons(name)");
        String studentDataStr = scanner.nextLine();
        String[] studentData = studentDataStr.split(" ");

        if (!lessonStorage.lessonsIsEmpty()) {
            if (studentData.length >= 7) {
                if (studentStorage.getByEmail(studentData[3]) == null) {
                    Lesson[] lessons = new Lesson[studentData.length - 6];
                    for (int i = 6, j = 0; i < studentData.length; i++, j++) {
                        if (lessonStorage.getByName(studentData[i]) != null) {
                            lessons[j] = lessonStorage.getByName(studentData[i]);
                        } else {
                            System.out.println("lesson by this name doesn't exist, add lesson");
                            addLesson();
                        }
                    }
                    int age = Integer.parseInt(studentData[2]);
                    Date date = DateUtil.stringToDate(studentData[5]);
                    Student student = new Student(studentData[0], studentData[1], age, studentData[3], studentData[4],
                            date, lessons);
                    studentStorage.add(student);
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


}
