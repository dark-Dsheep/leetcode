package 困难题训练;

public class LC_1745 {


//    1745. 回文串分割 IV Rating(1925) TODO

    int[][] f = new int[2010][2010];
    char[] cs;
    // 第I类区间DP
    public boolean checkPartitioning(String s) {
        int K = 3;
        int N = s.length();
        cs = (" " + s).toCharArray();
        // 当k=1的时候f[i][1]
        for (int i = 1; i <= N; i++) {
            f[i][1] = calc(1, i);
        }
        for (int i = 1; i <= N; i++) {
            for (int k = 2; k <= Math.min(i, K); k++) {
                f[i][k] = 0x3f3f3f;
                for (int j = i; j > k; j--) {
                    f[i][k] = Math.min(f[i][k], f[j-1][k-1] + calc(j, i));
                }
            }
        }
        return f[N][K] == 0;
    }

    int calc(int j, int i) {
        int cnt = 0;
        for (; j < i; j++, i--) {
            if (cs[j] != cs[i]) cnt++;
        }
        return cnt;
    }


    public static void main(String[] args) {

        String s = "wmrcbdiaylnjrhzfyqxjghnjbyfofurjcxnnlarpbzqowkhnmytmjaurulaazxxigmlhvzawkvuksrplukwsmfkvtrncqfcqqhrmvokpqxerfggfwxljazhqxbimlngbyneiwxdyjhalyceyonakltmdipzhgctdexhfbxvsbvtfqgxbsrmqbtplyyslwmzgspawtbebvhslykgftpmukxsaotoiwoytuqlhszwkbffcxqrlajnxutthmszvbyqigclvakzgfamkvsyadjfgqjjsoyemkjtlysxgunrbdwovhqrzlmgllggfqvrugvrtdwmreigmxhtfeynwzxssaxfehfsnfpqumhamlgljmzugyudaiwhxnvwnjqxdjxulcvmxzyiixibswsgogsnbqzicufmdtlozuhdgclrfurujdccmyzaifwpzxqknpvqkkkwllgannmuerfnbkxjjiseowhonzyfukyusrmwpnvweolneruejlqtsltnhjadtaxxhfpbfffwpehismsvqjvqlatajwepbdsbhqqicopucutiqulgracsawjygjihqiqfecmvcknqxynsfnvdykybesulcdxmihzizrhuevpnwrlhrgqdivozzanrtijcgrnwbolkcnjpqpqgsqxqmsubebapbtkateooggzdzmhjebvomhquvamkbhexytnxsdxctrtkrjpjcwwiaipcehujbptkdvmlswmmzzqsdwzjtxqfwkzsogayixmbqxyghkgwimxtwugrzfwkavehtudulykmjwvqtuojbzhqtszghdzbkaayolnogqepmhnefkpbxarpoeribszypeuihvqnzpycedjggfldvktchwkofrnmmpnkefntgrysayfykbudgaeiwpclrqiyecvwholjmxeqiehyuxdvlmpqavhkuuxlxsjwyvhc";
        System.out.println(new LC_1745().checkPartitioning(s));
    }



}
