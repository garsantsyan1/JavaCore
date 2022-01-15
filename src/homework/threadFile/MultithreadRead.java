package homework.threadFile;


import java.util.List;


import static homework.threadFile.MultiRead.countOfKeyword;

public class MultithreadRead implements Runnable {

    Thread t;
    private List<String> lines;
    private String keyword;

    public MultithreadRead(List<String> lines, String keyword) {
        this.lines = lines;
        this.keyword = keyword;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (String string : lines) {
            if (string.contains(keyword)) {
                countOfKeyword.incrementAndGet();
            }
        }
    }
}
