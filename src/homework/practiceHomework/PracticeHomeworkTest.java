package homework.practiceHomework;

public class PracticeHomeworkTest {
    public static void main(String[] args) {
        int[] arr1 = {5, 3, 40, 45};
        int[] arr2 = {1, 78, 17};
        PracticeHomework practiceHomework = new PracticeHomework();
        System.out.println(practiceHomework.convert(2));
        System.out.println(practiceHomework.calcAge(1));
        System.out.println(practiceHomework.nextNumber(-7));
        System.out.println(practiceHomework.isSameNum(5, 5));
        System.out.println(practiceHomework.lessThanOrEqualToZero(5));
        System.out.println(practiceHomework.reverseBool(false));
        System.out.println(practiceHomework.maxLength(arr1, arr2));

    }
}



