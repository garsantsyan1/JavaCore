package homework.file.fileUtil;

import java.io.*;

public class FileUtil {

    static void findLines(String txtPath, String keyword) {
        File file = new File(txtPath);
        boolean isExist = false;

        if (file.isFile()) {
            try (BufferedReader inputStream = new BufferedReader(new FileReader(txtPath))) {
                String line = "";
                while ((line = inputStream.readLine()) != null) {
                    if (line.contains(keyword)) {
                        System.out.println(line);
                        isExist = true;
                    }
                }
                if (!isExist) {
                    System.out.println("There isn't this word in the file");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("The file path is invalid!");
        }


    }

    static void printSizeOfPackage(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            double count = 0;

            for (File singleFile : files) {
                count += singleFile.length();
            }

            System.out.println(count /= (1024 * 1024));
        } else {
            System.err.println("The file path is invalid!");
        }


    }

    static void createFileWithContent(String path, String fileName, String content) {
        String filePath = path + "/" + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                    try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(filePath))) {
                        outputStream.write(content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists");
        }


    }

}
