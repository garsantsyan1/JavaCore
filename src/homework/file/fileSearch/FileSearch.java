package homework.file.fileSearch;

import java.io.File;
import java.util.Scanner;

public class FileSearch {

    private final static Scanner scanner = new Scanner(System.in);
    private static boolean isExist = false;

    static boolean fileSearch(String path, String fileName) {
        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File singleFile : files) {
                if (singleFile.isDirectory()) {
                    fileSearch(singleFile.getAbsolutePath(), fileName);
                } else if (singleFile.getName().equals(fileName)) {
                    isExist = true;
                }
            }
        }

        return isExist;
    }

    public static void main(String[] args) {
        System.out.println("please input path ");
        String path = scanner.nextLine();
        System.out.println("please input file name ");
        String fileName = scanner.nextLine();
        System.out.println(fileSearch(path, fileName));
    }

}

