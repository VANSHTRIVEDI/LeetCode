package Bit_Manipulation;

//https://www.youtube.com/watch?v=h1EVBhCMugI
//https://leetcode.com/problems/single-number-iii/description/?envType=daily-question&envId=2024-05-31
//https://github.com/MAZHARMIK/Interview_DS_Algo/blob/master/iPad%20PDF%20Notes/Leetcode-17-Single%20Number%20III.pdf
public class Single_Number_III {
    public int[] singleNumber(int[] nums) {
        int xor2no = 0;
        for (int num : nums) {
            xor2no ^= num;
        }

        int lowestBit = xor2no & (-xor2no);// (-xor2no) using two's complement

        int[] result = new int[2];
        for (int num : nums) {
            if ((lowestBit & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}

// concept is given below

// if we will do XOR. Only non repeating will left (if one is there )
// if two on repeating element is there its XOR will be store

// 1^2^1^3^2^5

// 3^5

// 001^101

// 110

// lowestBit
// will contain the (mask) whose right most bit which is different

// then we will divide then according to their rightmost different bit

// group A :-
// group B:-

// then we will XOR the whole group then only that element will left which is
// non repeating

// then will will return both the element left of the group
