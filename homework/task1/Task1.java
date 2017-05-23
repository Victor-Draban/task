package homework.task1;

import homework.Utils;

import java.math.BigDecimal;

public class Task1 {

    public static BigDecimal task1(int n) {      // i used formula C(n) = (2n)!/n!(n+1)!  to find  Catalan numbers
        BigDecimal numerator = Utils.factorial(2 * n);
        BigDecimal denominator1 = Utils.factorial(n);
        BigDecimal denominator2 = Utils.factorial(n + 1);
        return numerator.divide(denominator1.multiply(denominator2));
    }

}
