package Design;

public class LC_2241 {

//    2241. 设计一个 ATM 机器

    static class ATM {

        private int[] values;
        private long[] count;

        public ATM() {
            this.values = new int[]{20, 50, 100, 200, 500};
            this.count = new long[5];
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                count[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            var res = new int[5];
            for (int i = 4; i >= 0; i--) {
                int k = amount / values[i];
                if (count[i] >= k) {
                    res[i] = k;
                    amount -= k * values[i];
                } else {
                    res[i] = (int) count[i];
                    amount -= res[i] * values[i];
                }
            }
            if (amount > 0) return new int[]{-1};
            for (int i = 0; i < 5; i++) {
                count[i] -= res[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
