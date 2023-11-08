import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int loop = 0;
        String text = "ABCDEFG";
        char[] chars = text.toCharArray();
        while (loop < 4) {
            loop++;
            char temp = chars[loop];
            chars[loop] = chars[loop + 2];
            chars[loop + 2] = temp;
        }
        String result = new String(chars);
        System.out.println(result);
    }
}