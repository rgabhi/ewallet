package Learning.utilities;

import java.util.Random;

public class AccountNumberGenerator {
    private static Long i = 1L;

    public static Long generateAccountNumber() {
        return i++;
    }
}
