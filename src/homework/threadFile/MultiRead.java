package homework.threadFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiRead {
    public static String path = "/Users/Джоник/Desktop/java/sample.txt";
    public static AtomicInteger countOfKeyword = new AtomicInteger();

    public static void main(String[] args) throws IOException {
        long count = Files.lines(Paths.get(path)).count();
        String keyword = ";";

        MultithreadRead th = new MultithreadRead(path, 0, (int) (count / 3), keyword);
        MultithreadRead th1 = new MultithreadRead(path, (int) ((count/3) + 1), (int) (2 * (count / 3)), keyword);

        System.out.println("all lines:" + count);
        long currentTime = System.currentTimeMillis();


        List<String> strings = Files.readAllLines(Paths.get(path)).subList((int) (2 * (count / 3)), (int) count);
        for (String string : strings) {
            if (string.contains(keyword)) {
                countOfKeyword.incrementAndGet();
            }
        }
        try {
            th.t.join();
            th1.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("found lines: " + countOfKeyword);
        long finishTime = System.currentTimeMillis();
        System.out.println("time: " + (finishTime - currentTime));
    }
}
