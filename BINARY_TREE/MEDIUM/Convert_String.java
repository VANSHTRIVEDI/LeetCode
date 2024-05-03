package BINARY_TREE.MEDIUM;

public class Convert_String {
    public static String convertString(String str) {
        char[] charArray = str.toCharArray();

        if (charArray[0] != ' ') {

            charArray[0] = Character.toUpperCase(charArray[0]);

        }

        for (int i = 1; i < charArray.length; i++) {

            if (charArray[i - 1] == ' ' && charArray[i] != ' ') {

                charArray[i] = Character.toUpperCase(charArray[i]);

            }

        }

        return new String(charArray);
    }
}
