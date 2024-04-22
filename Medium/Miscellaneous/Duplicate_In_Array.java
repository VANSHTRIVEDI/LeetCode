package Medium.Miscellaneous;

import java.util.*;

public class Duplicate_In_Array {
    public static int findDuplicate(ArrayList<Integer> arr) {

        HashSet<Integer> hs = new HashSet<>();

        for (int num : arr)

        {

            if (hs.contains(num))

            {

                return num;

            }

            else {

                hs.add(num);
            }

        }

        return -1;

    }
}
