package Competition.weekly.wr344;

import java.util.HashMap;
import java.util.HashSet;

public class T2 {


    class FrequencyTracker {
        HashMap<Integer, Integer> a;
        HashMap<Integer, HashSet<Integer>> b;

        public FrequencyTracker() {
            a = new HashMap<>();
            b = new HashMap<>();
        }

        public void add(int number) {
            if (a.containsKey(number)) {
                var cnt = a.get(number);
                b.get(cnt).remove(number);
                if (b.get(cnt).size() == 0) {
                    b.remove(cnt);
                }
            }
            a.merge(number, 1, Integer::sum);
            var newCnt = a.get(number);
            b.computeIfAbsent(newCnt, v -> new HashSet<>());
            b.get(newCnt).add(number);
        }

        public void deleteOne(int number) {
            if (!a.containsKey(number)) return;
            var cnt = a.get(number);
            a.merge(number, -1, Integer::sum);
            if (a.get(number) == 0) {
                a.remove(number);
            }
            if (b.containsKey(cnt)) {
                b.get(cnt).remove(number);
                if (b.get(cnt).size() == 0) {
                    b.remove(cnt);
                }
                var newCnt = a.get(number);
                b.computeIfAbsent(newCnt, v -> new HashSet<>());
                b.get(newCnt).add(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return b.containsKey(frequency);
        }
    }

    public static void main(String[] args) {

    }
}
