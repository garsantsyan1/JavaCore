package homework.threadFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import static homework.threadFile.SingleRead.countOfKeyword;

public class MultithreadRead implements Runnable {

    String path;
    int startLine;
    int endLine;
    String keyword;
    Thread t;

    MultithreadRead(String path, int startLine, int endLine, String keyword) {
        this.path = path;
        this.startLine = startLine;
        this.endLine = endLine;
        this.keyword = keyword;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        List<String> strings = null;
        try {
            strings = Files.readAllLines(Paths.get(path)).subList(startLine, endLine);
            for (String string : strings) {
                if (string.contains(keyword)) {
                    countOfKeyword.incrementAndGet();
                }
            }

            System.out.println("found lines: " + countOfKeyword);
            long finishTime = System.currentTimeMillis();
            System.out.println("time: " + (finishTime - currentTime));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
