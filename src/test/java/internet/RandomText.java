package internet;

import java.security.SecureRandom;

public class RandomText {
    private static final String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(character.charAt(random.nextInt(character.length())));
        }
        return sb.toString();
    }
}
