package homework;

import java.math.BigDecimal;

public class Utils {

    public static BigDecimal factorial(int n) {   // find factorial for number {n}
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}
