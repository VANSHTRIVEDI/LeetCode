package Medium.Miscellaneous;

public class Minimum_Number_Moves_Seat_Everyone {

    public int minMovesToSeat(int[] seats, int[] students) {

        int allseats[] = new int[101];
        int allstudent[] = new int[101];

        for (int i = 0; i < seats.length; i++) {
            allseats[seats[i]]++;
            allstudent[students[i]]++;
        }
        int sum = 0;
        int j = 100, i = 100;

        while (j >= 0 || i >= 0) {
            while (allseats[j] == 0) {
                j--;
                if (j < 0)
                    break;
            }
            while (allstudent[i] == 0) {
                i--;
                if (i < 0)
                    break;
            }
            if (i < 0 || j < 0)
                break;
            sum = sum + (Math.abs(j - i));
            allseats[j]--;
            allstudent[i]--;
        }

        return sum;
    }
}
