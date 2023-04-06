package Algorithm.BinarySearch;

public class LC_275 {


    /*
        275. H 指数II
     */

    public int hIndex(int[] citations) {
        // 二分答案
        // 定义上下界
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(citations, mid)) {  // 模板1-尽量往左边找
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 特判一下
        return citations[l] >= n - l ? n - l : 0;
    }

    // 检查判断 citations[mid] 篇论文 至少被引用n - mid次 是否成立
    private boolean check(int[] citations, int mid) {
        int h = citations[mid];
        int cnt = citations.length - mid; // 以mid为中点判断
        return h >= cnt;
    }

    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        System.out.println(new LC_275().hIndex(citations));
    }
}
