package BINARY_TREE.MEDIUM;

import java.util.*;;

public class Sum_of_even_odd {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int sumOfEven = 0, sumOfOdd = 0;

        while (N != 0) {

            int digit = N % 10;

            N = N / 10;

            if (digit % 2 == 0) {

                sumOfEven += digit;

            } else {

                sumOfOdd += digit;

            }

        }

        System.out.println(sumOfEven + " " + sumOfOdd);

    }
}
