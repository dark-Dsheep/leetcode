package Math;


import java.io.PrintWriter;
import java.math.BigInteger;

public class BigInt {

    static PrintWriter out = new PrintWriter(System.out);
    static BigInteger a, b, p;
    // 绝对值
    static void abs() {
        out.println("abs:");
        a = new BigInteger("-123");
        out.println(a.abs());
        a = new BigInteger("123");
        out.println(a.abs());
    }
    // 取反
    static void negate() {
        out.println("negate:");
        a = new BigInteger("-123");
        out.println(a.negate());
        a = new BigInteger("123");
        out.println(a.negate());
    }
    // 相加
    static void add() {
        out.println("add:");
        a = new BigInteger("123");
        b = new BigInteger("123");
        out.println(a.add(b));  // 输出 246
    }
    // 相减
    static void subtract() {
        out.println("subtract:");
        a = new BigInteger("123");
        b = new BigInteger("123");
        out.println(a.subtract(b));  // 输出 0
    }
    // 相乘
    static void multiply() {
        out.println("multiply:");
        a = new BigInteger("12");
        b = new BigInteger("12");
        out.println(a.multiply(b));  // 输出 144
    }
    // 相除
    static void divide() {
        out.println("divide:");
        a = new BigInteger("12");
        b = new BigInteger("11");
        out.println(a.divide(b));  // 输出 1
    }
    // this % val
    static void remainder() {
        out.println("remainder:");
        a = new BigInteger("12");
        b = new BigInteger("10");
        out.println(a.remainder(b));  // 输出 2
        a = new BigInteger("-12");
        b = new BigInteger("10");
        out.println(a.remainder(b));  // 输出 -2
    }
    // this mod val
    static void mod() {
        out.println("mod:");
        a = new BigInteger("12");
        b = new BigInteger("10");
        out.println(a.mod(b));  // 输出 2
        a = new BigInteger("-12");
        b = new BigInteger("10");
        out.println(a.mod(b));  // 输出 8
    }

    //******************************* 数学运算 *************************************

    static void gcd() { // 最大公约数
        a = new BigInteger("120032414321432144212100");
        b = new BigInteger("240231431243123412432140");
        out.println(String.format("gcd(%s,%s)=%s", a.toString(), b.toString(), a.gcd(b).toString()));  // gcd(120032414321432144212100,240231431243123412432140)=20
    }
    static void isPrime() {  // 基于米勒罗宾判定该数是否是素数，参数越大准确性越高，复杂度越高。准确性为 (1-1/(val*2))
        a = new BigInteger("1200324143214321442127");
        out.println("a:" + a.toString());
        out.println(a.isProbablePrime(10) ? "a is prime" : "a is not prime");  // a is not prime
    }
    static void nextPrime() {  // 找出该数的下一个素数
        a = new BigInteger("1200324143214321442127");
        out.println("a:" + a.toString());
        out.println(String.format("a nextPrime is %s", a.nextProbablePrime().toString()));  // a nextPrime is 1200324143214321442199
    }
    static void modPow() {  // 快速幂，比正常版本要快，内部有数学优化
        a = new BigInteger("2");
        b = new BigInteger("10");
        p = new BigInteger("1000");
        out.println(String.format("a:%s b:%s p:%s", a, b, p));
        out.println(String.format("a^b mod p:%s", a.modPow(b, p).toString()));//  24
    }
    static void modInverse() {  // 逆元
        a = new BigInteger("10");
        b = new BigInteger("3");
        out.println(a.modInverse(b));  // a ^ (p-2) mod p = 1
    }

    public static void main(String[] args) {

    }
}
