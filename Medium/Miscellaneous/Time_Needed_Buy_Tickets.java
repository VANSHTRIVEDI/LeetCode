package Medium.Miscellaneous;

public class Time_Needed_Buy_Tickets {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int total = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                total += Math.min(tickets[i], tickets[k]);
            } else {
                total += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return total;

    }
}
