package Competition.biweekly.bw95;

public class T1 {


    public String categorizeBox(int length, int width, int height, int mass) {
        long n = 10000;
        long v = 1000000000;
        String res = "";
        long vi = (long) width * height * length;
        if (length >= n || width >= n || height >= n || vi >= v) {
            res = "Bulky";
        }
        if (res.equals("Bulky") && mass >= 100) {
            res = "Both";
            return res;
        }
        if (mass >= 100) {
            res = "Heavy";
        }
        if (res.equals("")) {
            return "Neither";
        }
        return res;
    }

    public static void main(String[] args) {

    }


}
