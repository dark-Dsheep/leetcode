package DataStructure.Array;

import java.util.LinkedList;

public class LC_1700 {

    /*
        1700. 无法吃午餐的学生数量
     */
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int x : students) stack.addLast(x);
        int index = 0;
        int canEat = 0;
        while (index < sandwiches.length && !stack.isEmpty()) {
            while (!stack.isEmpty() && stack.peekFirst() == sandwiches[index]) {
                index++;
                canEat++;
                stack.pollFirst();
            }
            int countStu = stack.size();
            int countCycle = 0;
            while (!stack.isEmpty() && stack.peekFirst() != sandwiches[index]) {
                stack.addLast(stack.pollFirst());
                if (countCycle == countStu) {
                    return students.length - canEat;
                }
                countCycle++;
            }
        }
        return students.length - canEat;
    }

    public static void main(String[] args) {
        int[] stu = {1, 1, 0, 0};
        int[] sand = {0, 1, 0, 1};
        System.out.println(new LC_1700().countStudents(stu, sand));
    }
}
