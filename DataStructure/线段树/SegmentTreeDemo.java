package DataStructure.线段树;

public class SegmentTreeDemo {

    static final int N = 10001;
    static int[] a = new int[N];
    static int[] f = new int[N];

    public static void main(String[] args) {
        int[] arr = {1, 3 ,5, 7, 9, 11};
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        buildTree(0, 0, arr.length - 1);
        for (int i = 0; i < 15; i++) {
            System.out.println(f[i]);
        }
    }

    static void buildTree(int k, int l, int r) {
        if (l == r)  {
            f[k] = a[l];
            return;
        }
        int m = l + r >> 1;
        buildTree(2 * k + 1, l, m);
        buildTree(2 * k + 2, m + 1, r);
        f[k] = f[2 * k + 1] + f[2 * k + 2];
    }

    static void add(int k, int l, int r, int idx, int val) {
        f[k] += val;
        if (l == r) return;
        int m = l + r >> 1;
        if (idx <= m) {
            add(2 * k + 1, l, m, idx, val);
        } else {
            add(2 * k + 2, m + 1, r, idx, val);
        }
    }

    static int calc(int k, int l, int r, int s, int t) {
        if (l == s && r == t) {
            return f[k];
        }
        int m = l + r >> 1;
        if (t <= m) {
            return calc(k + k, l, m, s, t);
        } else {
            if (s > m) {
                return calc(k + k + 1, m + 1, r, s, t);
            } else {
                return calc(k + k, l, m, s, m) + calc(k + k + 1, m + 1, r, m + 1, t);
            }
        }
    }
}
