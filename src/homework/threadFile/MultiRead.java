package homework.threadFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiRead {
    public static String path = "/Users/Джоник/Desktop/java/sample.txt";
    public static AtomicInteger countOfKeyword = new AtomicInteger();

    public static void main(String[] args) throws IOException, InterruptedException {
        //long count = Files.lines(Paths.get(path)).count();
        //String keyword = ";";
        List<String> lines = Files.readAllLines(Paths.get(path));
        System.out.println("all lines: " + lines.size());
        long currentTime = System.currentTimeMillis();


        MultithreadRead th1 = new MultithreadRead(lines.subList(0, 1149544), ";");
        MultithreadRead th2 = new MultithreadRead(lines.subList(1149545, 2299088), ";");
        MultithreadRead th3 = new MultithreadRead(lines.subList(2299089, lines.size()), ";");


        th1.t.join();
        th2.t.join();
        th3.t.join();


        System.out.println("found lines: " + countOfKeyword);
        long finishTime = System.currentTimeMillis();
        System.out.println("time: " + (finishTime - currentTime));
    }
}
