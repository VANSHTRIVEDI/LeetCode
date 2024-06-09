package Medium.Miscellaneous;

/**
 * LCM_And_GCD
 */
public class LCM_And_GCD {

    static Long[] lcmAndGcd(Long A, Long B) {

        Long[] arr = new Long[2];
        arr[1] = gcd(A, B);
        arr[0] = (A * B) / arr[1];

        return arr;

    }

    // first calculate the gcd
    // euclidian distance

    // a should be larger and b should be small

    // gcd(a,b)=gcd(a-b,b)
    // gcd(a-b,b)=gcd(a-b-b,b)

    // and if b is greater we will do it b and we will minus a

    // so instead of doing minus everytime we will do mod

    public static long gcd(Long A, Long B) {
        while (A > 0 && B > 0) {
            if (A > B) {
                A = A % B;
            } else {
                B = B % A;
            }
        }
        if (A > 0) {
            return A;
        } else {
            return B;
        }
    }
}