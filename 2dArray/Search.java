
//https://leetcode.com/problems/search-a-2d-matrix/
import java.util.*;

//This 
public class Search {
    public boolean searchMatrix(int[][] arr, int target) {
        int r = 0;
        int c = (arr[0].length) - 1;

        while (c >= 0 && r < arr.length) {
            // System.out.println(arr[r][c]);
            if (arr[r][c] == target) {
                return true;
            } else if (arr[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}

// https://www.codingninjas.com/studio/problems/search-in-a-2d-matrix_980531
class Search2 {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> arrList, int target) {

        int rstart = 0;
        int rend = arrList.size() - 1;
        int colmid = arrList.get(0).size() / 2;

        if (arrList.size() == 1) {
            if (binary(rstart, 0, arrList.get(0).size() - 1, arrList, target)) {
                return true;
            } else {
                return false;
            }

        } else {
            while (rstart < rend - 1) {

                int mid = rstart + (rend - rstart) / 2;

                if (arrList.get(mid).get(colmid) == target) {
                    return true;
                } else if (arrList.get(mid).get(colmid) < target) {
                    rstart = mid;
                } else if (arrList.get(mid).get(colmid) > target) {
                    rend = mid;
                }
            }

            if (arrList.get(rstart).get(colmid) == target) {
                return true;
            }
            if (arrList.get(rstart + 1).get(colmid) == target) {
                return true;
            }

            if (binary(rstart, 0, colmid - 1, arrList, target)) {
                return true;
            }
            if (binary(rstart + 1, 0, colmid - 1, arrList, target)) {
                return true;
            }
            if (binary(rstart, colmid + 1, arrList.get(0).size() - 1, arrList, target)) {
                return true;
            }
            if (binary(rstart + 1, colmid + 1, arrList.get(0).size() - 1, arrList, target)) {
                return true;
            }

            return false;
        }

    }

    public static boolean binary(int rstart, int colstart, int colend, ArrayList<ArrayList<Integer>> arrList,
            int target) {
        int colmid = colstart + (colend - colstart) / 2;

        while (colstart <= colend) {
            if (arrList.get(rstart).get(colmid) == target) {
                return true;
            }
            if (arrList.get(rstart).get(colmid) < target) {
                colstart = colmid + 1;
            }
            if (arrList.get(rstart).get(colmid) > target) {
                colend = colmid - 1;
            }
            colmid = colstart + (colend - colstart) / 2;
        }
        return false;
    }
}
