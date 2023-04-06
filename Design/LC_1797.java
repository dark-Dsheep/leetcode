package Design;

import java.util.HashMap;

public class LC_1797 {

//    1797. 设计一个验证系统

    class AuthenticationManager {

        private int ttl;
        private HashMap<String, Integer> map;

        public AuthenticationManager(int timeToLive) {
            this.ttl = timeToLive;
            this.map = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + ttl);
        }

        public void renew(String tokenId, int currentTime) {
            if (!map.containsKey(tokenId)) return;
            if (map.get(tokenId) <= currentTime) return;
            map.put(tokenId, currentTime + ttl);
        }

        public int countUnexpiredTokens(int currentTime) {
            int cnt = 0;
            for (String tokenId : map.keySet()) {
                if (map.get(tokenId) > currentTime) {
                    cnt++;
                }
            }
            return cnt;
        }
    }


    public static void main(String[] args) {

    }
}
