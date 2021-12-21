package homework.file.fileUtil;

public class FileUtilTest {
    public static void main(String[] args) {
        FileUtil.findLines("C:/Users/Джоник/Desktop/java/yes.txt", "football");
        FileUtil.printSizeOfPackage("C:/Users/Джоник/Desktop/java");
        FileUtil.createFileWithContent("C:/Users/Джоник/Desktop/java", "Martin.txt", "s");
    }
}
