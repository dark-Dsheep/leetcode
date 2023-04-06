package DataStructure.HashMap;

import java.util.HashMap;

public class LC_2325 {

    /*
        LC_2325. 解密消息
     */
    public String decodeMessage(String key, String message) {
        var map = new HashMap<Character, Character>();
        var k = 0;
        for (var i = 0; i < key.length(); i++) {
            var c = key.charAt(i);
            if (c == ' ' || map.containsKey(c)) continue;
            map.put(c, (char) (k + 97));
            k++;
        }
        var sb = new StringBuilder();
        for (var i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                sb.append(map.get(message.charAt(i)));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        var key = "the quick brown fox jumps over the lazy dog";
        var message = "vkbs bs t suepuv";
        System.out.println(new LC_2325().decodeMessage(key, message));
    }
}
