package Competition.biweekly.bw100;

public class T1 {

    int[] map = new int[50];
    public int distMoney(int money, int children) {
        if (money < children) return -1;
        if (money == children * 8) return children;
        int last = children;
        // 每个儿童至少获得1美元
        money -= children; // 7
        for (int i = 1; i <= children; i++) map[i] = 1;
        for (int i = 1; i <= children; i++) {
            if (money >= 7) {
                map[i] = 8;
                money -= 7;
                if (i + 1 == last && map[i+1] + money == 4) {
                    map[i] = 1;
                } else if (i == last && money > 0) {
                    map[i] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= children; i++) {
            if (map[i] == 8) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int m = 17;
        int c = 2;
        System.out.println(new T1().distMoney(m, c));
    }
}
