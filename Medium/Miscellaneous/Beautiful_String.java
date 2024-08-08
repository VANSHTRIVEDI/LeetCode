



class Beautiful_String {
    public static int calculateCount(String str, char c) {

        int count = 0;

        for (int i = 0; i < str.length(); i = i + 2) {

            if (str.charAt(i) != c) {

                count++;

            }

        }

        for (int i = 1; i < str.length(); i = i + 2) {

            if (str.charAt(i) == c) {

                count++;

            }

        }

        return count;

    }

    public static int makeBeautiful(String str) {

        return Math.min(calculateCount(str, '0'), calculateCount(str, '1'));

    }
}
