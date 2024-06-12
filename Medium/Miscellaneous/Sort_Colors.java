package Medium.Miscellaneous;

//https://www.youtube.com/watch?v=6sMssUHgaBs
//https://leetcode.com/problems/sort-colors/description/?envType=daily-question&envId=2024-06-12
public class Sort_Colors {

    // Dutch National Flag algorithm
    // Imp to understand
    public void sortColors(int[] nums) {

        int start = 0;
        int mid = 0;
        int end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] == 2) {
                swap(mid, end, nums);
                end--;
            } else if (nums[mid] == 0) {
                swap(mid, start, nums);
                start++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            }

        }
    }

    public static void swap(int one, int two, int arr[]) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }

}

// we can solve this like this also but the problem in importan to understand
// ducth national flag algo
// we can also solve this by counting 0's 1's 2's separately and then use three
// for loops

// class Solution {
// public void sortColors(int[] nums) {
// int arr[]=new int[3];
// for(int i=0;i<nums.length;i++)
// {
// arr[nums[i]]++;
// }
// int index=0;
// for(int i=0;i<arr.length;i++)
// {
// int t=arr[i];
// for(int j=1;j<=t;j++)
// {
// nums[index]=i;
// index++;
// }
// }

// }
// }
