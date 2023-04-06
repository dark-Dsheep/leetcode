package Design;

import java.util.LinkedList;

public class LC_1670 {

    /*
        1670. 设计前中后队列
     */
    static class FrontMiddleBackQueue {

        private LinkedList<Integer> q;

        public FrontMiddleBackQueue() {
            this.q = new LinkedList<>();
        }

        public void pushFront(int val) {
            q.addFirst(val);
        }

        public void pushMiddle(int val) {
            int size = q.size();
            int idx = size / 2;
            q.add(idx, val);
        }

        public void pushBack(int val) {
            q.addLast(val);
        }

        public int popFront() {
            return q.size() < 1 ? -1 : q.pollFirst();
        }

        public int popMiddle() {
            int size = q.size();
            int idx = 0;
            if (size % 2 == 0) {
                idx = size / 2 - 1;
            } else {
                idx = size / 2;
            }
            return q.remove(idx);
        }

        public int popBack() {
            return q.size() < 1 ? -1 : q.pollLast();
        }
    }



    public static void main(String[] args) {

        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushMiddle(4);
//        System.out.println(queue.q);
        System.out.println(queue.popFront());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popBack());
        System.out.println(queue.popFront());
    }
}
