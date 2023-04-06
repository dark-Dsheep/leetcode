package Competition.biweekly.bw99;

public class T2 {

    public long coloredCells(int n) {
        if (n == 1) return 1;
        return 4L * (n - 1) + coloredCells(n - 1);
    }


    public static void main(String[] args) {
        System.out.println(new T2().coloredCells(5));
    }
}
