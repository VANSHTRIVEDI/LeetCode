package Medium.recursion_backtrack;

//https://leetcode.com/problems/powx-n/

class power {

    public static long Pow(int X, int N) {
        return solve((long) X, (long) N);
    }

    public static long solve(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        } else if (n < 0) {
            return solve(1 / x, -n);
        }

        long ans = solve(x, n / 2);

        if (n % 2 == 0) {
            return ans * ans;
        } else {
            return x * ans * ans;
        }
    }
}

// same solution using while loop
class power2 {
    public double myPow(double x, int n) {
        return solve(x, (long) n);
    }

    public double solve(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double result = 1.0;
        double base = x;
        long power = Math.abs(n);

        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base);
            }
            base = (base * base);
            power = power / 2;
        }

        if (n < 0) {
            return 1 / result;
        }

        return result;
    }
}

// similar question
// https://www.geeksforgeeks.org/problems/power-of-numbers-1587115620/1
class mod {

    long power(int N, int R) {
        return solve(N, R, 1000000007);
    }

    public static long solve(long x, long n, long mod) {
        if (n == 0) {
            return 1 % mod; // Return 1 modulo mod
        }
        if (n == 1) {
            return x % mod; // Return x modulo mod
        } else if (n < 0) {
            return solve(1 / x, -n, mod);
        }

        long ans = solve(x, n / 2, mod); // Calculate ans modulo mod

        if (n % 2 == 0) {
            return (ans * ans) % mod; // Return (ans * ans) modulo mod
        } else {
            return (((x % mod) * ans % mod) * ans) % mod; // Return ((x * ans * ans) modulo mod)
        }
    }
}

class mod2 {

    long power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        long result = 1;
        long base = x;
        long power = Math.abs(n);
        long mod = 1000000007; // Modulo 10^9 + 7

        while (power > 0) {
            if (power % 2 == 1) {
                result = (result * base) % mod; // Update result modulo mod in each step
            }
            base = (base * base) % mod; // Update base modulo mod in each step
            power /= 2;
        }

        return result;
    }
}
