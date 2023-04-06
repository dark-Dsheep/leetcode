package DataStructure.Array;

public class LC_1894 {

    // TODO
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        for (int x : chalk) sum += x;
        int round = (int) Math.ceil( k / (double) sum);
        for (int i = 0; i < chalk.length * round; i++) {
            if (k < chalk[(i + 1) % chalk.length]) return (i + 1) % chalk.length;
            k -= chalk[(i + 1) % chalk.length];
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] chalk = {3, 4, 1, 2};
        int k = 25;
        System.out.println(new LC_1894().chalkReplacer(chalk, k));
    }
}
