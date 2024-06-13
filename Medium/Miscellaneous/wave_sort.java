package Medium.Miscellaneous;

import java.util.*;

public class wave_sort {
    public static void main(String[] args) {

        List<Object> arr = new ArrayList<>(Arrays.asList(-90, 49, 10, 2.0, 1, 5, 23));

        /*
         * In Java, when dealing with ArrayList<Double>, you can only add elements that
         * are of type Double. This is because ArrayList is a generic class and Double
         * is a wrapper class for the primitive type double. Therefore, any value you
         * add to an ArrayList<Double> must either be a Double or be automatically boxed
         * to a Double by the Java compiler.
         * 
         * In contrast, when you use a primitive array, it can hold primitive types
         * directly, and you can mix different numerical types (like int, double, etc.)
         * because they will be implicitly converted to the appropriate type.
         * List<Double> b = new ArrayList<>();
         * b.add(2);
         * b.add(-90);//this won't work
         * b.add(2.0);
         * double[] inputArray = { 10, -90, 49, 2.0, 1, 5, 23 }; //this will work
         * 
         * 
         * so intead of creating a object of double we can create an array of double
         * and perfrom sort in it
         */

        for (int i = 1; i < arr.size(); i = i + 2) {

            // System.out.println(arr.get(i));
            if (Double.valueOf(arr.get(i - 1) + "") > Double.valueOf(arr.get(i) + "")) {
                swap(i, i - 1, arr);
            }
            if (Double.valueOf(arr.get(i) + "") < Double.valueOf(arr.get(i + 1) + "")) {
                swap(i, i + 1, arr);
            }

        }
        for (Object a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void swap(int i, int j, List<Object> arr) {
        Object temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);

    }

}
