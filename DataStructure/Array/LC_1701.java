package DataStructure.Array;

public class LC_1701 {


    /*
        1701. 平均等待时间
     */
    public double averageWaitingTime(int[][] customers) {
        double sum = 0;
        sum += customers[0][1];
        int end = customers[0][0] + customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            int s = customers[i][0];
            int t = customers[i][1];
            if (s < end) {
                sum += (end + t - s);
                end += t;
            } else {
                sum += t;
                end = s + t;
            }
        }
        return sum / customers.length;
    }

    public static void main(String[] args) {

    }
}
