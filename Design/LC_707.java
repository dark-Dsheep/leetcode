package Design;

public class LC_707 {

    //TODO
    static class MyLinkedList {
        int size;
        Node dummy;

        static class Node {
            int val;
            Node next;
            Node pre;

            public Node(int val, Node next, Node pre) {
                this.val = val;
                this.next = next;
                this.pre = pre;
            }
        }
        public MyLinkedList() {
            size = 0;
            dummy = new Node(-1, null, null);

        }

        public int get(int index) {
            if (index > size - 1)  return -1;
            var cur = dummy;
            for (int i = -1; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            var temp = dummy.next;
            var node = new Node(val, temp, dummy);
            dummy.next = node;
            temp.pre = node;
            ++size;
        }

        public void addAtTail(int val) {
            var cur = dummy.next;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val, null, cur);
            ++size;
        }

        public void addAtIndex(int index, int val) {
            if (index > size - 1) return;
            var cur = dummy;
            for (int i = -1; i < index; i++) cur = cur.next;
            var temp = cur.next;
            Node node = new Node(val, temp, cur);
            cur.next = node;
            temp.pre = node;
        }

        public void deleteAtIndex(int index) {
            if (index > size - 1) return;
            var cur = dummy;
            for (int i = -1; i < index; i++) cur = cur.next;
            if (cur.next.next != null) {
                var temp = cur.next.next;
                cur.next = temp;
                temp.pre = cur;
            } else {
                cur.next = null;
            }
        }
    }

    public static void main(String[] args) {

    }
}
