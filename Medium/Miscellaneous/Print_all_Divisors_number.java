package Medium.Miscellaneous;

import java.util.*;

public class Print_all_Divisors_number {
    public static List<Integer> printDivisors(int n) {

        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {

            if ((n % i) == 0) {

                arrList.add(i);

                if (n / i != i) {

                    arrList.add(n / i);

                }

            }

        }

        Collections.sort(arrList);

        return arrList;

    }
}
