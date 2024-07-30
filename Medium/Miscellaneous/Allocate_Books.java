

import java.util.ArrayList;

import java.util.Collections;

public class Allocate_Books {

    public static int countStudents(ArrayList<Integer> arr, int pages) {

        int s = 1, page = 0;

        for (int i = 0; i < arr.size(); i++) {

            if (arr.get(i) + page <= pages) {

                page += arr.get(i);

            } else {

                s++;

                page = arr.get(i);

            }

        }

        return s;

    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        if (m > n)
            return -1;

        int low = Collections.max(arr), high = arr.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {

            int mid = (low + high) / 2;

            if (countStudents(arr, mid) <= m) {

                high = mid - 1;

            } else {

                low = mid + 1;

            }

        }

        return low;

    }

}