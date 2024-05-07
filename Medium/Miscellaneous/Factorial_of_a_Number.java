package Medium.Miscellaneous;

import java.util.Scanner;

public class Factorial_of_a_Number {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();

        long mul = 1;
        if (number > 0) {
            while (number > 0) {
                mul = mul * number;
                number = number - 1;
            }
            System.out.print(mul);
        } else if (number == 0) {
            mul = 1;
            System.out.print(mul);
        } else {
            System.out.println("Error");
            mul = 0;
        }

    }
}
