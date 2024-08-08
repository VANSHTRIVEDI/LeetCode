
//https://leetcode.com/problems/boats-to-save-people/?envType=daily-question&envId=2024-05-04
import java.util.Arrays;

public class Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        int count = 0;
        Arrays.sort(people);
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            count++;
        }
        return count;
    }
}
