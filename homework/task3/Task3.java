package homework.task3;

import homework.Utils;

public class Task3 {

    public static int task3() {     // find factorial(100),  then summarize all the numbers obtained in the number
        String factorial =  Utils.factorial(100).toString();
        int result = 0;
        for (int i = 0; i < factorial.length(); i++) {
            String temp = String.valueOf(factorial.charAt(i));
            result += Integer.parseInt(temp);
        }
        return result;
    }

}
