package Competition.biweekly.bw95;

public class T2 {


    class DataStream {

        int[] nums = new int[100010];
        int val;
        int index;
        int k;

        public DataStream(int value, int k) {
            this.val = value;
            this.index = 0;
            this.k = k;
        }

        public boolean consec(int num) {
            nums[index++] = num;
            if (index < k) return false;
            // 3 3 3 4
            for (int i = index - k; i < index; i++) {
                if (nums[i] != val) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {

    }
}
