package homework.education.model;

import Author2.util.DateUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Student implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;
    private Date registeredDate;
    private Lesson[] lessons;


    public Student(String name, String surname, int age, String email, String phone, Date registeredDate, Lesson[] lessons) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.registeredDate = registeredDate;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registeredDate=" + DateUtil.dateToString(registeredDate) +
                ", lessons=" + Arrays.toString(lessons) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && name.equals(student.name) && surname.equals(student.surname) && email.equals(student.email) && phone.equals(student.phone) && registeredDate.equals(student.registeredDate) && Arrays.equals(lessons, student.lessons);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, age, email, phone, registeredDate);
        result = 31 * result + Arrays.hashCode(lessons);
        return result;
    }

}