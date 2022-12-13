package Console;

import java.util.Random;

public class Helper {

    public static String idGenerator(int length) {
        char[] chars = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray());
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int l = 0; l < length; l++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
