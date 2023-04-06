package DataStructure.String;

public class LC_2232 {


    public String minimizeResult(String expression) {
        int idx = expression.indexOf('+');
        int n = expression.length();
        var sb = new StringBuilder();
        for (int i = idx - 1; i >= 0; i--) {
            int sum = expression.charAt(i) - '0';
            for (int j = idx+ 1; j < n; j++) {
//                sum +=
            }
            int pre = Integer.parseInt(expression.substring(0, i));
            System.out.println(pre);
        }
        return "";
    }


    public static void main(String[] args) {


    }
}
