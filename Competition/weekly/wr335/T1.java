package Competition.weekly.wr335;

public class T1 {

    int ans = 0;
    public int passThePillow(int n, int time) {
        int pos = 1; int dir = 1;
        boolean init = true;
        while (time > 0) {
            if (pos == n || (pos == 1 && !init)) {
                // 到达队首或队尾，改变传递方向
                dir = -dir;
            }
            pos += dir;
            if (pos == 1) init = false;
            time--;
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(new T1().passThePillow(4, 8));
    }
}
