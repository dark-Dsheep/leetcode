package Competition.weekly.wr338;

public class T1 {



    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes > k) return k;
        int base = numOnes;
        if (numZeros + numOnes >= k) return base;
        int cnt = numZeros + numOnes - k;
        base += cnt;
        return base;
    }



    public static void main(String[] args) {
        System.out.println(new T1().kItemsWithMaximumSum(6, 6, 6, 13));
    }
}
