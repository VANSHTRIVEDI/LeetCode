public class hehe {
    import java.util.ArrayList;

public class Solution {

    public static int search(ArrayList<Integer> arr, int n, int k) {

        int si = 0;

        int ei = n-1;

 

        int target = searchRotatedArray(arr, si, ei, k);

        return target;

         

    }

    public static int searchRotatedArray(ArrayList<Integer> arr, int si, int ei, int k){

        if(si>ei){

            return -1;

        }

        int mid = si + (ei-si)/2;

        if(arr.get(mid)==k){

            return mid;

        }

        if(arr.get(si)<=arr.get(mid)){

            if(arr.get(si) <= k && k <= arr.get(mid)){

                return searchRotatedArray(arr, si, mid-1, k);

            }else{

                return searchRotatedArray(arr, mid+1, ei, k);

            }

        }else{

            if(arr.get(mid) <= k && k <=arr.get(ei)){

                return searchRotatedArray(arr, mid+1, ei, k);

            }else{

                return searchRotatedArray(arr, si, mid-1, k);

            }

        }

    }

}
}
