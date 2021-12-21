package homework.file.fileUtil;

import java.io.*;

public class FileUtil {

    static void findLines(String txtPath, String keyword) {

        try (BufferedReader inputStream = new BufferedReader(new FileReader(txtPath))) {
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                if (line.contains(keyword)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printSizeOfPackage(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        double count = 0;

        for (File singleFile : files) {
            count += singleFile.length();
        }

        System.out.println(count /= (1024 * 1024));

    }

    static void createFileWithContent(String path, String fileName, String content) {
        File file = new File(path);
        File[] files = file.listFiles();
        String filePath = path + "/" + fileName;
        File newFile = new File(filePath);
        for (File singleFile : files) {
            if (!newFile.exists()) {
                try {
                    if (newFile.createNewFile()) {
                        System.out.println("File is created!");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(filePath))) {
            outputStream.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
