package Design;

public class LC_2424 {

    /*
        2424. 最长上传前缀
     */

    static class LUPrefix {

        private int start; // 最长上传前缀的结束下标
        private int[] nums;

        public LUPrefix(int n) {
            this.start = 0;
            this.nums = new int[n];
        }

        public void upload(int video) {
            nums[video - 1] = 1;
            // 每次从最长上传前缀的结束下标开始遍历 遇到0则退出循环
            for (int i = start; i < nums.length; i++) {
                if (nums[i] != 1) break;
                ++start;
            }
        }

        public int longest() {
            return start;
        }
    }


    public static void main(String[] args) {
        LUPrefix prefix = new LUPrefix(4);
//        [[4],[3],[],[1],[],[2],[]]
        prefix.upload(3);
        System.out.println(prefix.longest());
        prefix.upload(1);
        System.out.println(prefix.longest());
        prefix.upload(2);
        System.out.println(prefix.longest());
    }
}
