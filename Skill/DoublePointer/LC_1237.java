package Skill.DoublePointer;

import java.util.ArrayList;
import java.util.List;

public class LC_1237 {

//    1237. 找出给定方程的正整数解

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1, y = 1000;
        var ans = new ArrayList<List<Integer>>();
        while (x <= 1000 && y > 0) {
            int res = customfunction.f(x, y);
            if (res > z)        { y--; }  // 结果大了
            else if (res < z)   { x++; }  // 结果小了
            else                { ans.add(List.of(x++, y--)); } // 合法解
        }
        return ans;
    }

    class CustomFunction {

        public int f(int x, int y) {
            return x + y;
        }
    }

    public static void main(String[] args) {

    }
}
