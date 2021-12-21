package homework.file.contentSearch;

import java.io.*;
import java.util.Scanner;

public class ContentSearch {

    private final static Scanner scanner = new Scanner(System.in);

    static void contentSearch(String path, String word) {
        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File singleFile : files) {
                if (singleFile.getName().endsWith(".txt") && singleFile.isFile()) {
                    try (BufferedReader inputStream = new BufferedReader(new FileReader(singleFile.getAbsolutePath()))) {
                        String line = "";
                        while ((line = inputStream.readLine()) != null) {
                            if (line.contains(word)) {
                                System.out.println(singleFile.getName());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (singleFile.isDirectory()) {
                    contentSearch(singleFile.getAbsolutePath(), word);
                }
            }
        }


    }


    public static void main(String[] args) {
        System.out.println("please input path ");
        String path = scanner.nextLine();
        System.out.println("please input word ");
        String word = scanner.nextLine();
        contentSearch(path, word);
    }

}

