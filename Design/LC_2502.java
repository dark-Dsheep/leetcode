package Design;

import java.util.Arrays;

public class LC_2502 {


    //    2502. 设计内存分配器
    class Allocator {
        int[] map = new int[1010];
        int n;
        public Allocator(int _n) {
            n = _n;
        }

        public int allocate(int size, int mID) {
            int end = -1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (map[i] == 0) {
                    cnt++;
                    if (cnt == size) { end = i; break; }
                } else {
                    cnt = 0;
                }
            }
            if (cnt != size) return -1;
            Arrays.fill(map, end - size + 1, end + 1, mID);
            return end - size + 1; // 返回第一个下标
        }

        public int free(int mID) {
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (map[i] == mID) { map[i] = 0; ans++; };
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
