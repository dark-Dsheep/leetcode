package DataStructure.HashMap;


public class LC_1010 {
    /**
     * 1010. 总持续时间可被 60 整除的歌曲
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        var map = new int[60];
        for (int x : time) {
            ans += map[(60 - x % 60) % 60];
            map[x % 60]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(new LC_1010().numPairsDivisibleBy60(time));
    }
}
