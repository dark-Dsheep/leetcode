package DataStructure.Array;

public class LC_845 {

    /*
        845. 数组中的最长山脉
     */
    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        int len = 0;
        for (int i = 1; i < arr.length - 1; ) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) { // 中心扩展
                int l = i - 1;
                int r = i + 1;
                while (l > 0 && arr[l] > arr[l - 1]) l--;
                while (r < arr.length - 1 && arr[r] > arr[r + 1]) r++;
                len = Math.max(len, r  - l + 1);
                i = r;
            } else {
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new LC_845().longestMountain(arr));
    }
}
