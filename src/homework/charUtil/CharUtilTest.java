package homework.charUtil;

public class CharUtilTest {
    public static void main(String[] args) {
        CharUtil charUtil = new CharUtil();
        char[] arr = {' ', ' ', 's', 'l', 'y', ' ', ' '};
        for(char x : charUtil.trim(arr)) {
            System.out.print(x +  " ");
        }
    }
}
