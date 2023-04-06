package Algorithm.BinarySearch;

public class LC_744 {

//    744. 寻找比目标字母大的最小字母
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (letters[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l] > target ? letters[l] : letters[0];
    }

    public static void main(String[] args) {

    }
}
